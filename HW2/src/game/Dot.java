/*
 * HW2: Dots and Boxes
 * Jordan Chin, jc9627@rit.edu
 * Charlie Leyens, cal3368@rit.edu
 */

package game;

import java.lang.AssertionError;

/**
 * Represents a single dot in the game of Dots and Boxes.
 * <pre>
 * $ java DotsAndBoxes rows columns
 * Usage: java DotsAndBoxes rows columns
 *</pre>
 *
 * @author Jordan Chin, jc9627@rit.edu
 * @author Charlie Leyens, cal3368@rit.edu
 */
public class Dot {

    /** the row */
    private int row;

    /** the column */
    private int column;

    /** the string representation of a dot, is in fact a period */
    public static final String DOT = ".";

    /**
     * Create the dot.
     *
     * @param xVal the column
     * @param yVal the row
     */
    public Dot(int yVal, int xVal) {
        if ((xVal < 0) || (yVal < 0)) {
            throw new AssertionError();
        } else; {
            row = yVal;
            column = xVal;
        }
    }

    /**
     * Get the row.
     *
     * @return the row
     */
    public int getRow() {
        return row;
    }

    /**
     * Get the column.
     *
     * @return the column
     */
    public int getColumn() {
        return column;
    }

    /**
     * Two dots are equal if they have the same row and column.
     *
     * @overrides equals in class Object
     * @param other the dot to compare with
     * @return whether they are equal or not
     */
    public boolean equals(Object other){
        Dot dot = (Dot) other;
        if (dot.row == this.row && dot.column == this.column){
            return true;
        }
        return false;
    }

    /**
     * Return the string representation of a dot. Don't get too excited,
     * it's just a dot. :P
     */
    public String toString() {
        return DOT;
    }

}
