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

    private Player player;

    public Box(int upperLeftrow, int upperLeftcolumn, Lines allLines) {
        row = upperLeftrow;
        column = upperLeftcolumn;
        lines = allLines;
        player = Player.NONE;

        lines.getLine(upperLeftrow, upperLeftcolumn, upperLeftrow,
                upperLeftcolumn+1).setBox(this);
        lines.getLine(upperLeftrow, upperLeftcolumn, upperLeftrow+1,
                upperLeftcolumn).setBox(this);
        lines.getLine(upperLeftrow+1, upperLeftcolumn,
                upperLeftrow+1, upperLeftcolumn+1).setBox(this);
        lines.getLine(upperLeftrow, upperLeftcolumn+1,
                upperLeftrow+1, upperLeftcolumn+1).setBox(this);
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Line getTopLine() {
        //print(lines.getLine(row,column,row,column+1));
        return lines.getLine(row, column, row, column+1);
    }

    public Line getBottomLine() {
        return lines.getLine(row+1, column, row+1, column+1);
    }

    public Line getRightLine() {
        return lines.getLine(row,column+1,row+1,
                column+1);
    }

    public Line getLeftLine() {
        return lines.getLine(row, column, row+1, column);
    }

    public Player getOwner(){
        return player;
    }

    public void claim(Player owner) {
        if(this.getTopLine().hasOwner() && this.getBottomLine().hasOwner() &&
                this.getLeftLine().hasOwner() &&
                this.getRightLine().hasOwner()){
            player=owner;
        }
    }

    public String toString(){
        return player.getLabel();
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
