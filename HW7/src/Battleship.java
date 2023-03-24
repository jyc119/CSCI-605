/*
 * HW7: Battleship
 * Jordan Chin, jc9627@rit.edu
 * Charlie Leyens, cal3368@rit.edu
 */

import java.io.*;

/**
 * The main class that runs the game
 *
 * @author Jordan Chin, jc9627@rit.edu
 * @author Charlie Leyens, cal3368@rit.edu
 */
public class Battleship {

    /** At end of game */
    public static final String ALL_SHIPS_SUNK = "All ships sunk!";

    /** For player commands */
    public static final String BAD_ARG_COUNT = "Wrong number of " +
            "arguments for command ";

    /** For when the config file has too large a dimension in it */
    public static final String DIM_TOO_BIG = "Board dimensions too big to " +
            "display";

    /** the hit command */
    public static final String HIT = "h";

    /** We don't allow boards larger than this value, height or width. */
    public static final int MAX_DIM = 20;

    /** What to display when the program is ready for a user command */
    public static final String Prompt = "> ";

    /** the quit command */
    public static final String QUIT = "q";

    /** the reveal command */
    public static final String REVEAL = "!";

    /** the save command */
    public static final String SAVE = "s";

    /** The regular expression to use with String.split(String) */
    public static final String WHITESPACE = "\\s+";

    /** the board */
    private Board board;

    /**
     * Construct a battleship game
     *
     * @param filename the setup file
     * @throws BattleshipException - If the init configuration file is incorrect
     * @throws IOException - If there are errors problems reading the file
     */
    public Battleship(String filename) throws BattleshipException, IOException {
        System.out.print("Checking if " + filename + " is a saved game " +
                "file... ");
        try (ObjectInputStream game = new ObjectInputStream(new
                FileInputStream(filename))){
            System.out.println("yes");
            board = (Board) game.readObject();
            board.display(System.out);
            return;
        } catch (IOException | ClassNotFoundException e) {
            {
                System.out.print("no; ");
            }
        }
        try (BufferedReader newGame = new BufferedReader(new
                FileReader(filename))) {
            System.out.println("will read as a text setup file.");
            String line = newGame.readLine();
            String[] dimensions = line.split(WHITESPACE);
            if (Integer.parseInt(dimensions[0]) > MAX_DIM ||
                    Integer.parseInt(dimensions[1]) > MAX_DIM) {
                System.out.println(DIM_TOO_BIG);
                return;
            } else {
                board = new Board(Integer.parseInt(dimensions[0]),
                        Integer.parseInt(dimensions[1]));
            }
            line = newGame.readLine();
            while (line != null) {
                try {
                    String[] shipInfo = line.split(WHITESPACE);
                    board.addShip(new Ship(board, Integer.parseInt(shipInfo[0]),
                            Integer.parseInt(shipInfo[1]),
                            Orientation.valueOf(shipInfo[2]),
                            Integer.parseInt(shipInfo[3])));
                    line = newGame.readLine();
                } catch (BattleshipException be) {
                    System.out.println(be);
                    System.exit(0);
                }
            }
            board.display(System.out);
            }
        }

    /**
     * The main user input loop for processing commands.
     */
    public void play() {
        while (!board.allSunk()) {
            BufferedReader br = new BufferedReader(new InputStreamReader
                    (System.in));
            System.out.print(Prompt);
            String move = null;
            try {
                move = br.readLine();
            } catch (IOException IO) {
                System.out.println(IO.getMessage());
            }
            if (move.equals("help")) {
                String[] help = move.split(WHITESPACE);
                if (help.length == 1) {
                    System.out.println("h row column - Hit a cell.\n" + "s " +
                            "file - Save game state to file. (Serialization " +
                            "process)\n" + "! - Reveal all ship locations.\n" +
                            "q - Quit game.");
                    continue;
                } else {
                    System.out.println(BAD_ARG_COUNT + REVEAL);
                }
            }
                if (String.valueOf(move.charAt(0)).equals(HIT)) {
                    String[] hit = move.split(WHITESPACE);
                    try {
                        if (hit.length == 3) {
                            if (Integer.parseInt(hit[1]) > board.getHeight()
                                    || Integer.parseInt(hit[2]) >
                                    board.getWidth()) {
                                throw new OutOfBoundsException(Integer.parseInt
                                        (hit[1]), Integer.parseInt(hit[2]));
                            }
                            board.getCell(Integer.parseInt(hit[1]),
                                    Integer.parseInt(hit[2])).hit();
                        } else {
                            System.out.println(BAD_ARG_COUNT + HIT);
                        }
                    } catch (BattleshipException e) {
                        System.out.println(e);
                    }
                } else if (String.valueOf(move.charAt(0)).equals(SAVE)) {
                    String[] save = move.split(WHITESPACE);
                    if (save.length == 2) {
                        try (ObjectOutputStream saveGame = new
                                ObjectOutputStream(new FileOutputStream
                                (save[1]))) {
                            saveGame.writeObject(board);
                            continue;
                        } catch (IOException ignored) {
                            {
                                System.out.print("Incorrect file name");
                            }
                        }
                    } else {
                        System.out.println(BAD_ARG_COUNT + SAVE);
                    }
                } else if (String.valueOf(move.charAt(0)).equals(REVEAL)) {
                    String[] showBoard = move.split(WHITESPACE);
                    if (showBoard.length == 1) {
                        board.fullDisplay(System.out);
                        continue;
                    } else {
                        System.out.println(BAD_ARG_COUNT + REVEAL);
                    }
                } else if (String.valueOf(move.charAt(0)).equals(QUIT)) {
                    String[] quit = move.split(WHITESPACE);
                    if (quit.length == 1) {
                        return;
                    } else {
                        System.out.println(BAD_ARG_COUNT + QUIT);
                    }
                } else {
                    System.out.println("Invalid command");
                }
                board.display(System.out);
        }
            System.out.println(ALL_SHIPS_SUNK);
    }

    /**
     * Read the setup file and build all data structures needed later. The setup
     * file is either a text file describing the initial state of a new game or
     * an ObjectStream file that contains a saved game.
     *
     * @param args one element: the name of the setup file
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Battleship setup-file");
        } else {
            try {
                Battleship battleship = new Battleship(args[0]);
                battleship.play();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
