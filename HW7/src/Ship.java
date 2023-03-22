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
        if (this.orientation == Orientation.HORIZONTAL) {
            for (int i = column; i < this.length; i++) {
                board.getCell(row, i).putShip(this);
            }
        }
        else {
            for (int i = row; i < this.length; i++) {
                board.getCell(i, column).putShip(this);
            }
        }
    }

    public void hit() {
        if (this.orientation == Orientation.HORIZONTAL) {
            for (int i = column; i < this.length; i++) {
                if (board.getCell(row, i).displayChar() != Cell.HIT_SHIP_SECTION) {
                    return;
                }
            }

            for (int i = column; i < this.length; i++) {
                board.getCell(row, i).CHARACTER_STATE = Cell.SUNK_SHIP_SECTION;
            }
        } else {
            for (int i = row; i < this.length; i++) {
                if (board.getCell(i, column).displayChar() != Cell.HIT_SHIP_SECTION) {
                    return;
                }
            }
            for (int i = row; i < this.length; i++) {
                board.getCell(i, column).CHARACTER_STATE = Cell.SUNK_SHIP_SECTION;
            }
        }
    }

    public boolean isSunk() {
        if (this.orientation == Orientation.HORIZONTAL) {
            for (int i = column; i < this.length; i++) {
                if (board.getCell(row, i).displayChar() == Cell.SUNK_SHIP_SECTION) {
                    System.out.println(SUNK_MESSAGE);
                    return true;
                } else {
                    return false;
                }
            }
        }
        else {
            for (int i = row; i < this.length; i++) {
                if (board.getCell(i, column).displayChar() == Cell.SUNK_SHIP_SECTION) {
                    System.out.println(SUNK_MESSAGE);
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
