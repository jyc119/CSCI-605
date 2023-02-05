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

    private Line[][] horiLines;
    private Line[][] vertLines;

    public Lines(int rowsVal, int columnsVal, Dot[][] Dots) {
        rows = rowsVal;
        columns = columnsVal;
        dots = Dots;
        this.horiLines = new Line[rowsVal+1][columnsVal+1];
        this.vertLines = new Line[rowsVal+1][columnsVal+1];
        for (int row=0; row<=rowsVal; row++) {
            for (int column=0; column<=columnsVal; column++) {
                if (column < columnsVal){
                    horiLines[row][column] = new Line(dots[row][column], dots[row][column+1]);
                }
                if (row < rowsVal){
                    vertLines[row][column] = new Line(dots[row][column], dots[row+1][column]);
                }
            }
        }
    }

    public Line getLine(int row1, int column1, int row2, int column2) {
        if(row2 < row1 || column2 < column1){
            return null;
        }

        for (int row=0; row<=rows; row++) {
            for (int column=0; column<=columns; column++) {
                if (column < columns && row == row1 && column == column1 && row == row2 && column+1 == column2){
                    System.out.println(horiLines[row][column].getFirst().getColumn());
                    System.out.println(horiLines[row][column].getFirst().getRow());
                    return horiLines[row][column];
                }
                else if (row <  rows && row == row1 && column == column1 && row+1 == row2 && column == column2){
                    System.out.println(vertLines[row][column].getFirst().getColumn());
                    System.out.println(vertLines[row][column].getFirst().getRow());
                    return vertLines[row][column];
                }
            }
        }
        return null;
    }

    public int size() {
        int m = rows + 1;
        int n = columns + 1;
        return 2*m*n - m - n;
    }
}
