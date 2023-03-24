/*
 * HW7: Battleship
 * Jordan Chin, jc9627@rit.edu
 * Charlie Leyens, cal3368@rit.edu
 */

/**
 * A BattleshipException that informs the program that
 * it attempted to place a ship where there is already
 * another ship
 *
 * @author Jordan Chin, jc9627@rit.edu
 * @author Charlie Leyens, cal3368@rit.edu
 */
public class OverlapException extends BattleshipException{

    /** the row number of the bad coordinates */
    private int row;

    /** the column number of the bad coordinates  */
    private int column;

    /** Descriptive error message to display for this exception */
    private static String OVERLAP = "Ships placed in " +
            "overlapping positions, ";

    /**
     * The constructor stores the coordinates of intersection
     * and sets the error message to OVERLAP.
     *
     * @param row the row number of the bad coordinates
     * @param column the column number of the bad coordinates
     */
    public OverlapException(int row, int column) {
        super(OVERLAP + "row=" + row + ", column=" + column);
        this.row = row;
        this.column = column;
    }
}
