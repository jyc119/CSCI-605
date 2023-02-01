package game;

/**
 * Represents a single "box" in the game of Dots and Boxes.
 * <pre>
 * $ java DotsAndBoxes rows columns
 * Usage: java DotsAndBoxes rows columns
 *</pre>
 *
 * @author Jordan Chin, jc9627@rit.edu
 * @author Charlie Leyens, cal3368@rit.edu
 */

public class Box {

    private int row;
    private int col;
    private Lines lines;

    public Box(int allRows, int allCols, Lines allLines){
        row = allRows;
        col = allCols;
        lines = allLines;
    }

}
