/*
 * HW2: Dots and Boxes
 * Jordan Chin, jc9627@rit.edu
 * Charlie Leyens, cal3368@rit.edu
 */

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

    /** the rows */
    private int rows;

    /** the columns */
    private int columns;

    /** the collection of dots */
    private Dot[][] dots;

    /** the collection of horizontal lines */
    private Line[][] horiLines;

    /** the collection of vertical lines */
    private Line[][] vertLines;

    /**
     * Creates all the lines in the game. We assume that all lines are specified
     * from left to right (horizontal) or top to bottom (vertical) For a
     * rectangular grid assume that m = rows+1 and n = columns+1. Therefore
     * there will be 2mn - m - n lines in the grid.
     *
     * @param rowsVal the number of rows
     * @param columnsVal the number of columns
     * @param Dots the grid of dots
     */
    public Lines(int rowsVal, int columnsVal, Dot[][] Dots) {
        rows = rowsVal;
        columns = columnsVal;
        dots = Dots;
        this.horiLines = new Line[rowsVal+1][columnsVal+1];
        this.vertLines = new Line[rowsVal+1][columnsVal+1];

        for (int row=0; row<=rowsVal; row++) {
            for (int column=0; column<=columnsVal; column++) {
                if (column < columnsVal){
                    horiLines[row][column] = new Line(dots[row][column],
                            dots[row][column+1]);
                }
                if (row < rowsVal){
                    vertLines[row][column] = new Line(dots[row][column],
                            dots[row+1][column]);
                }
            }
        }
    }

    /**
     * Get a line by two coordinates. Note that in order to find the line it
     * must be specified left to right (horizontal) or top to bottom (vertical)
     * or else it won't be found.
     *
     * @param row1 the first row
     * @param column1 the first column
     * @param row2 the second row
     * @param column2 the second column
     * @return the line, or null if it can't be found
     */
    public Line getLine(int row1, int column1, int row2, int column2) {
        if(row2 < row1 || column2 < column1){
            return null;
        }
        for (int row=0; row<=rows; row++) {
            for (int column=0; column<=columns; column++) {
                if (column < columns && row == row1 && column == column1 && row
                        == row2 && column+1 == column2){
                    return horiLines[row][column];
                }
                else if (row <  rows && row == row1 && column == column1 &&
                        row+1 == row2 && column == column2){
                    return vertLines[row][column];
                }
            }
        }
        return null;
    }

    /**
     * Get the number of lines in the collection.
     *
     * @return number of lines
     */
    public int size() {
        int m = rows + 1;
        int n = columns + 1;
        return 2*m*n - m - n;
    }
}
