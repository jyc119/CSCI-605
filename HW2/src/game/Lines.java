package game;

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
    private int columns;

    private Dot[][] dots;

    public Lines(int rowsVal, int columnsVal, Dot[][] Dots) {
        rows = rowsVal;
        columns = columnsVal;
        dots = Dots;
    }

    public Line getLine(int row1, int column1, int row2, int column2) {
        if(row2 < row1 || column2 < column1){
            return null;
        }
        return new Line(dots[row1][column1],dots[row2][column2]);
    }

    public int size() {
        int m = rows + 1;
        int n = columns + 1;
        return 2*m*n - m - n;
    }
}
