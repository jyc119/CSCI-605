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

    private Line[][] allLines;

    public Lines(int rowsVal, int columnsVal, Dot[][] Dots) {
        rows = rowsVal;
        columns = columnsVal;
        dots = Dots;

        this.allLines = new Line[rows][columns];
        for (int row=0; row<rowsVal; ++row) {
            for (int column=0; column<columnsVal; ++column) {
                System.out.println(row);
                System.out.println(column);
                this.allLines[row][column] = new Line(dots[row][column] , dots[row][column+1]);
            }
        }

    }

    public Line getLine(int row1, int column1, int row2, int column2) {
        if(row2 < row1 || column2 < column1){
            return null;
        }
        for (int row=0; row<rows; ++row) {
            for (int column=0; column<columns; ++column) {
                Line curLine = this.allLines[row][column];
                /*
                System.out.println(curLine.getFirst().getRow());
                System.out.println(curLine.getFirst().getColumn());
                System.out.println(curLine.getSecond().getRow());
                System.out.println(curLine.getSecond().getColumn());
                */
                if(curLine.getFirst().getRow() == row1 && curLine.getFirst().getColumn() == column1 && curLine.getSecond().getRow() == row2 && curLine.getSecond().getColumn() == column2) {
                    System.out.println("whay");
                    return curLine;
                }
            }
        }
        System.out.println("usucl");
        return new Line(dots[row1][column1],dots[row2][column2]);
    }

    public int size() {
        int m = rows + 1;
        int n = columns + 1;
        return 2*m*n - m - n;
    }
}
