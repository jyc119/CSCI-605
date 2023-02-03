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
    private int row;
    private int column;

    public Dot(int yVal, int xVal) {
        if ((xVal < 0) || (yVal < 0)) {
            throw new AssertionError();
        } else; {
            row = xVal;
            column = yVal;
        }
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean equals(Object other){
        Dot dot = (Dot) other;
        if (dot.row == this.row && dot.column == this.column){
            return true;
        }
        return false;
    }

    public String toString() {
        return ".";
    }

}
