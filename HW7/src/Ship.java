/*
 * HW7: Battleship
 * Jordan Chin, jc9627@rit.edu
 * Charlie Leyens, cal3368@rit.edu
 */

import java.io.Serializable;

/**
 * A single ship in a Battleship game
 *
 * @author Jordan Chin, jc9627@rit.edu
 * @author Charlie Leyens, cal3368@rit.edu
 */
public class Ship implements Serializable {

    /** Message to display if ship has been sunk */
    public static final String SUNK_MESSAGE = "A battleship has been sunk!";

    /** holds the board */
    private Board board;

    /** The number of rows in the board */
    private final int row;

    /** The number of columns in the board */
    private final int column;

    /** The orientation of the ship */
    private final Orientation orientation;

    /** The length of the ship */
    private final int length;

    /** The total number of hits the ship took */
    private int hits;

    /**
     * Initialize this new ship's state. Tell the Board object
     * and each involved Cell object about the existence of
     * this ship by trying to put the ship at each applicable Cell.
     *
     * @param board The board the ship is in
     * @param row The number of rows in board
     * @param column The number of columns in board
     * @param orientation  The orientation of the ship
     * @param length The length of the ship
     * @throws OutOfBoundsException
     * @throws OverlapException
     */
    public Ship(Board board, int row, int column, Orientation orientation,
                int length) throws OutOfBoundsException, OverlapException {
        if(row > board.getHeight() ||
                column > board.getWidth() ||
                orientation == Orientation.VERTICAL && row + length >
                        board.getHeight() ||
                orientation == Orientation.HORIZONTAL && column+length >
                        board.getWidth()){
            throw new OutOfBoundsException(row,column);
        }
        if(board.getCell(row,column).ship != null){
            throw new OverlapException(row, column);
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

    /**
     *
     * A Cell object has been hit and tells this ship that
     * is sitting on it that the cell has been hit. If this
     * ship has been hit as many times as it is long, the
     * SUNK_MESSAGE is displayed.
     *
     */
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
                board.getCell(i, column).CHARACTER_STATE =
                        Cell.SUNK_SHIP_SECTION;
            }
            System.out.println(SUNK_MESSAGE);
        }
    }

    /**
     * Checks if the ship is sunk
     * @return if the ship sinks
     */
    public boolean isSunk() {
        return hits == length;
    }
}
