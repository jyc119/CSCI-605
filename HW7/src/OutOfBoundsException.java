/*
 * HW7: Battleship
 * Jordan Chin, jc9627@rit.edu
 * Charlie Leyens, cal3368@rit.edu
 */

/**
 * A BattleshipException that informs the program
 * that it attempted to place a ship outside the
 * bounds of the board
 *
 * @author Jordan Chin, jc9627@rit.edu
 * @author Charlie Leyens, cal3368@rit.edu
 */
public class OutOfBoundsException extends BattleshipException{

    /** The row number of the bad coordinates */
    private int row;

    /** The column number of the bad coordinates */
    private int column;

    /** Descriptive error message to display for this exception */
    private static final String PAST_EDGE = "Coordinates are past board edge, ";

    /**
     * The constructor stores the illegal coordinates where the
     * violation occurred and sets the error message to PAST_EDGE.
     *
     * @param row The row number of the bad coordinates
     * @param column The column number of the bad coordinates
     */
    public OutOfBoundsException(int row, int column){
        super(PAST_EDGE + "row=" + row + ", column=" + column);
        this.row = row;
        this.column = column;
    }
}
