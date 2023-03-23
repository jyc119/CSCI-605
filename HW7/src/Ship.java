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
                int length) throws BattleshipException  {

        if(row > board.getHeight() ||
                column > board.getWidth() ||
                orientation == Orientation.VERTICAL && row + length > board.getHeight() ||
                orientation == Orientation.HORIZONTAL && column+length > board.getWidth()){
            throw new OutOfBoundsException("Out of bounds!", row,column);
        }
        System.out.println("here");
        if(board.getCell(row,column).getShip() != null){
            throw new OverlapException(row, column, "Cannot have another ship here!");
        }

        this.board = board;
        this.row = row;
        this.column = column;
        this.orientation = orientation;
        this.length = length;
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
        if (orientation == Orientation.HORIZONTAL) {
            for (int i = column; i < column + this.length; i++) {
                if (board.getCell(row, i).displayChar() != Cell.HIT_SHIP_SECTION) {
                    return;
                }
            }
            for (int i = column; i < column + this.length; i++) {
                board.getCell(row, i).CHARACTER_STATE = Cell.SUNK_SHIP_SECTION;
            }
            System.out.println(SUNK_MESSAGE);
            board.ships--;
        } else {
            for (int i = row; i < row + this.length; i++) {
                if (board.getCell(i, column).displayChar() != Cell.HIT_SHIP_SECTION) {
                    return;
                }
            }
            for (int i = row; i < row + this.length; i++) {
                board.getCell(i, column).CHARACTER_STATE = Cell.SUNK_SHIP_SECTION;
            }
            System.out.println(SUNK_MESSAGE);
            board.ships--;
        }
    }

    public boolean isSunk() {
        if (this.orientation == Orientation.HORIZONTAL) {
            for (int i = column; i < column + this.length; i++) {
                if (board.getCell(row, i).displayChar() == Cell.SUNK_SHIP_SECTION) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        else {
            for (int i = row; i < row + this.length; i++) {
                if (board.getCell(i, column).displayChar() == Cell.SUNK_SHIP_SECTION) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
