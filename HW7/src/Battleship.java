import java.io.IOException;

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

    private Board board;


    public Battleship(String filename) throws BattleshipException, IOException {

    }

    public void play() {

    }

    public static void main(String[] args) throws BattleshipException, IOException {
        Board board = new Board(5, 5);
        System.out.println(board.toString());
    }
}
