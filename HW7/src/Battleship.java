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
        } catch (IOException ignored) {}
        try (BufferedReader newGame = new BufferedReader(new FileReader(filename))) {
            System.out.println("no; will read as a text setup file.");
            String line = newGame.readLine();
            String[] dimensions = line.split(WHITESPACE);
            Board board = new Board(Integer.valueOf(dimensions[0]), Integer.valueOf(dimensions[1]));
            line = newGame.readLine();
            while (line != null) {
                String[] shipInfo = line.split(WHITESPACE);
                //try to add each ship to the board and catch error 5 and 6
//                try {
//                    board.addShip(new Ship(board, Integer.valueOf(shipInfo[0]),
//                            Integer.valueOf(shipInfo[1]), Orientation.valueOf(shipInfo[2]),
//                            Integer.valueOf(shipInfo[3])));
//                }
//                catch (BattleshipException be) {
//
//                }
                Cell cell = board.getCell(Integer.valueOf(shipInfo[0]), Integer.valueOf(shipInfo[1]));
                cell.putShip(new Ship(board, Integer.valueOf(shipInfo[0]),
                            Integer.valueOf(shipInfo[1]), Orientation.valueOf(shipInfo[2]),
                            Integer.valueOf(shipInfo[3])));
                line = newGame.readLine();
            }
            System.out.println(board.toString());
        } catch (IOException fnfe){
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
