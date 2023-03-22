import java.io.*;
import java.util.ArrayList;

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
    private int rows;

    private int columns;

    private Board board;


    public Battleship(String filename) throws BattleshipException, IOException {
    }

//    public void play() {
//
//        Board board = new Board()
//        System.out.println(board.toString());
//    }

    public static void main(String[] args) throws BattleshipException, IOException {
        if (args.length != 1) {
            System.out.println("Usage: java Battleship setup-file");
        } else {
            System.out.print("Checking if " + args[0] + " is a saved game file... ");
            try (FileInputStream savedGame = new FileInputStream(args[0])) {
                ObjectInputStream game = new ObjectInputStream(savedGame);
                System.out.println("yes");
            } catch (IOException ignored) {
            }
            try (BufferedReader newGame = new BufferedReader(new FileReader(args[0]))) {
                    System.out.println("no; will read as a text setup file.");
                } catch (FileNotFoundException fnfe){
                System.out.println("No File Found");
            }
        }
    }
}
