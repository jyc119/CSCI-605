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
    private int column;
    private Lines lines;

    public Box(int upperLeftrow, int upperLeftcolumn, Lines allLines) {
        row = upperLeftrow;
        column = upperLeftcolumn;
        lines = allLines;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void claim(Player player) {

    }

    public Line getTopLine() {
        return new Line(new Dot(row, column), new Dot(row, column + 1));
    }

    public Line getBottomLine() {
        return new Line(new Dot(row + 1, column),
                new Dot(row + 1, column + 1));
    }

    public Line getRightLine() {
        return new Line(new Dot(row, column + 1),
                new Dot(row + 1, column + 1));
    }

    public Line getLeftLine() {
        return new Line(new Dot(row, column), new Dot(row + 1, column));
    }

    public void claim(Player owner){

    }

    public String toString(){
        return Player.getLabel();
    }

    public boolean equals(Object other){
        Box box = (Box) other;
        if (box.row == this.row && box.column == this.column
                && box.lines == this.lines){
            return true;
        }
        return false;
    }
}
