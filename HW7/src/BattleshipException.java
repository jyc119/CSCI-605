/*
 * HW6: Battleship
 * Jordan Chin, jc9627@rit.edu
 * Charlie Leyens, cal3368@rit.edu
 */


/**
 * A class to represent different violations of the game's rules.
 *
 * @author Jordan Chin, jc9627@rit.edu
 * @author Charlie Leyens, cal3368@rit.edu
 */

public class BattleshipException extends Exception {

    /** Unset default value for coordinates */
    public static final int UNSET = -1;

    /** The row number of the cell's coordinates */
    public final int row;

    /** The column number of the cell's coordinates */
    public final int column;

    /**
     * The constructor stores the coordinates where the violation
     * occurred and sets the given error message.
     *
     * @param row  The row number of the cell's coordinates
     * @param column The column number of the cell's coordinates
     * @param message the error message
     *
     */
    public BattleshipException(int row, int column, String message) {
        super(message + ", row=" + row + ", column=" + column);
        this.row = row;
        this.column = column;
    }

    /**
     * The constructor set the given error message and set the
     * coordinates to the UNSET default value.
     *
     * @param message the error message
     */
    public BattleshipException(String message){
        super(message);
        this.row = UNSET;
        this.column = UNSET;
    }
}
