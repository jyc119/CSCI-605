import java.io.Serializable;

/**
 * A single ship in a Battleship game
 */
public class Ship implements Serializable {

    public static final String SUNK_MESSAGE = "A battleship has been sunk!";

    private Board board;

    private final int row;

    private final int column;

    private final Orientation orientation;

    private final int length;

    public Ship(Board board, int row, int column, Orientation orientation,
                int length) {
        this.board = board;
        this.row = row;
        this.column = column;
        this.orientation = orientation;
        this.length = length;
    }

    public void hit() {

    }

//    public boolean isSunk() {
//        if () {
//            return true;
//        }
//        else {
//            return false;
//        }
//    }
}
