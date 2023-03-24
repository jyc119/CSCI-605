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

    private int hits;

    public Ship(Board board, int row, int column, Orientation orientation,
                int length) throws OutOfBoundsException, OverlapException {

        if(row > board.getHeight() ||
                column > board.getWidth() ||
                orientation == Orientation.VERTICAL && row + length > board.getHeight() ||
                orientation == Orientation.HORIZONTAL && column+length > board.getWidth()){
            throw new OutOfBoundsException("Out of bounds!", row,column);
        }
        if(board.getCell(row,column).ship != null){
            throw new OverlapException(row, column, "Cannot have another ship here!");
        }

        this.board = board;
        this.row = row;
        this.column = column;
        this.orientation = orientation;
        this.length = length;
        this.hits = 0;
        if (orientation == Orientation.HORIZONTAL) {
            for (int i = column; i < column + this.length; i++) {
                board.getCell(row, i).putShip(this);
            }
        }
        else {
            for (int i = row; i < row + this.length; i++) {
                board.getCell(i, column).putShip(this);
            }
        }
    }

    public void hit() {
        hits++;
        if (orientation == Orientation.HORIZONTAL) {
            for (int i = column; i < column + this.length; i++) {
                if (!board.getCell(row, i).hitStatus) {
                    return;
                }
            }
            for (int i = column; i < column + this.length; i++) {
                board.getCell(row, i).CHARACTER_STATE = Cell.SUNK_SHIP_SECTION;
            }
            System.out.println(SUNK_MESSAGE);
        } else {
            for (int i = row; i < row + this.length; i++) {
                if (!board.getCell(i, column).hitStatus) {
                    return;
                }
            }
            for (int i = row; i < row + this.length; i++) {
                board.getCell(i, column).CHARACTER_STATE = Cell.SUNK_SHIP_SECTION;
            }
            System.out.println(SUNK_MESSAGE);
        }
    }

    public boolean isSunk() {
        if (hits == length) {
            return true;
        } else {
            return false;
        }
    }
}
