import java.io.*;


/**
 * The main class that runs the game
 */
public class Battleship {
    public static final String ALL_SHIPS_SUNK = "All ships sunk!";

    public static final String BAD_ARG_COUNT = "Wrong number of " +
            "arguments for command";

    public static final String DIM_TOO_BIG = "Board dimensions too big to " +
            "display";

    public static final String HIT = "h";

    public static final int MAX_DIM = 20;

    public static final String Prompt = "> ";

    public static final String QUIT = "q";

    public static final String REVEAL = "!";

    public static final String SAVE = "s";

    public static final String WHITESPACE = "\\s+";

    private String filename;


    public Battleship(String filename) throws BattleshipException, IOException {
        this.filename = filename;
    }

    public void play() {
        System.out.print("Checking if " + filename + " is a saved game file... ");
        try (FileInputStream savedGame = new FileInputStream(filename)) {
            ObjectInputStream game = new ObjectInputStream(savedGame);
            System.out.println("yes");
            Board board = new Board(4, 4);
            System.out.println(board);
        } catch (IOException ignored) {{System.out.print("no; ");}}
        try (BufferedReader newGame = new BufferedReader(new FileReader(filename))) {
            System.out.println("will read as a text setup file.");
            String line = newGame.readLine();
            String[] dimensions = line.split(WHITESPACE);
            Board board = new Board(Integer.valueOf(dimensions[0]), Integer.valueOf(dimensions[1]));
            line = newGame.readLine();
            while (line != null) {
                try {
                    String[] shipInfo = line.split(WHITESPACE);
                    board.addShip(new Ship(board, Integer.valueOf(shipInfo[0]),
                            Integer.valueOf(shipInfo[1]), Orientation.valueOf(shipInfo[2]),
                            Integer.valueOf(shipInfo[3])));
                    line = newGame.readLine();
                }
                catch(BattleshipException e){
                    System.out.println(e);
                    return;
                }
            }
            while (!board.allSunk()) {
                System.out.println();
                System.out.println(board);
                InputStreamReader test = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(test);
                System.out.print(Prompt);
                String move = br.readLine();
                if (String.valueOf(move.charAt(0)).equals(HIT)) {
                    String[] hit = move.split(WHITESPACE);
                    if (hit.length == 3) {
                        board.getCell(Integer.valueOf(hit[1]), Integer.valueOf(hit[2])).hit();
                    }
                    else {
                        System.out.println("Wrong number of arguments for command: " + HIT);
                    }
                } else if (String.valueOf(move.charAt(0)).equals(SAVE)) {
                    String[] save = move.split(WHITESPACE);
                    if (save.length == 2) {
                        try (FileOutputStream saveGame = new FileOutputStream(save[1])) {
                        } catch (IOException ignored) {{System.out.print("Incorrect file name");}} // not sure if its right
                    }
                    else {
                        System.out.println("Wrong number of arguments for command: " + SAVE);
                    }
                } else if (String.valueOf(move.charAt(0)).equals(REVEAL)) {
                    String[] showBoard = move.split(WHITESPACE);
                    if (showBoard.length == 1) {
                        //Display board with ships
                    }
                    else {
                        System.out.println("Wrong number of arguments for command: " + REVEAL);
                    }
                } else if (String.valueOf(move.charAt(0)).equals(QUIT)) {
                    String[] quit = move.split(WHITESPACE);
                    if (quit.length == 1) {
                        return;
                    }
                    else {
                        System.out.println("Wrong number of arguments for command: " + QUIT);
                    }
                } else {
                    System.out.println("Invalid command");
                }
            }
            System.out.println(board);
            System.out.println(ALL_SHIPS_SUNK);
        } catch (IOException IO){
            System.out.println("No File Found");
        }
    }

    public static void main(String[] args) throws BattleshipException, IOException {
        if (args.length != 1) {
            System.out.println("Usage: java Battleship setup-file");
        } else {
            Battleship battleship = new Battleship(args[0]);
            battleship.play();
        }
    }
}
