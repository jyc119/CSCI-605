/*
 * HW6: Battleship
 * Jordan Chin, jc9627@rit.edu
 * Charlie Leyens, cal3368@rit.edu
 */

/**
 * A BattleshipException that informs the program
 * that it attempted to "hit" the same Cell instance
 * more than once
 *
 * @author Jordan Chin, jc9627@rit.edu
 * @author Charlie Leyens, cal3368@rit.edu
 */

public class CellPlayedException extends BattleshipException{

    /** The row number of the cell's coordinates */
    private int row;

    /** The column number of the cell's coordinates */
    private int column;

    /** Descriptive error message to display for this exception */
    private static final String ALREADY_HIT = "This cell has already been hit, ";

    /**
     * The constructor stores the coordinates
     * where the violation occurred and sets
     * the error message to ALREADY_HIT.
     *
     * @param row the row number of the cell's coordinates
     * @param column the column number of the cell's coordinates
     */
    public CellPlayedException(int row, int column) {
        super(ALREADY_HIT + "row=" + row + " , column=" + column);
        this.row = row;
        this.column = column;
    }
}
