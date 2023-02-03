/**
 * This class holds the collection of all lines in the game of Dots and Boxes.
 * <pre>
 * $ java DotsAndBoxes rows columns
 * Usage: java DotsAndBoxes rows columns
 *</pre>
 *
 * @author Jordan Chin, jc9627@rit.edu
 * @author Charlie Leyens, cal3368@rit.edu
 */

public class Lines {

    private int rows;
    private int cols;

    private Dot[][] dots;

    public Lines(int rows, int columns, Dot[][] Dots) {
        rows = rows;
        cols = columns;
        dots = Dots;
    }

    public Line getLine(int row1, int column1, int row2, int column2) {
        return (row1, column1, row2, column2);
    }

    public int size() {
        return ;
    }
}
