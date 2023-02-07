/*
 * HW2: Dots and Boxes
 * Jordan Chin, jc9627@rit.edu
 * Charlie Leyens, cal3368@rit.edu
 */

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

    /** the row */
    private int row;

    /** the column */
    private int column;

    /** the collection of lines */
    private Lines lines;

    /** the players */
    private Player player;

    /**
     * Create the box and associate each line with this box.
     *
     * @param upperLeftrow the upper left row coordinate
     * @param upperLeftcolumn the upper left column coordinate
     * @param allLines the collection of lines
     */
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

    /**
     * Get the row.
     *
     * @return row
     */
    public int getRow() {
        return row;
    }

    /**
     * Get the column.
     *
     * @return column
     */
    public int getColumn() {
        return column;
    }

    /**
     * Get top line.
     *
     * @return top line
     */
    public Line getTopLine() {
        //print(lines.getLine(row,column,row,column+1));
        return lines.getLine(row, column, row, column+1);
    }

    /**
     * Get bottom line.
     *
     * @return bottom line
     */
    public Line getBottomLine() {
        return lines.getLine(row+1, column, row+1, column+1);
    }

    /**
     * Get right line.
     *
     * @return right line
     */
    public Line getRightLine() {
        return lines.getLine(row,column+1,row+1,
                column+1);
    }

    /**
     * Get left line.
     *
     * @return left line
     */
    public Line getLeftLine() {
        return lines.getLine(row, column, row+1, column);
    }

    /**
     * Get the owner of the box.
     *
     * @return the owner, game.Player.NONE if not owned
     */
    public Player getOwner(){
        return player;
    }

    /**
     * Attempt to claim a box. A box is claimed by an owner when all 4 lines
     * that form the box have been claimed. This is called each time a Line is
     * claimed. The line knows which boxes are associated with it. Based on
     * these assumptions, and the prevention of a line being claimed multiple
     * times, this should only be called exactly 4 times per Box.
     *
     * @param owner the owner that claimed the last line.
     */
    public void claim(Player owner) {
        if(this.getTopLine().hasOwner() && this.getBottomLine().hasOwner() &&
                this.getLeftLine().hasOwner() &&
                this.getRightLine().hasOwner()){
            player=owner;
        }
    }

    /**
     * Returns the label of the boxes owner. Look at the Player enum.
     *
     * @overrides toString in class Object
     */
    public String toString(){
        return player.getLabel();
    }

    /**
     * Two boxes are equal if the boxes have the same row, column, owner
     * and 4 lines.
     *
     * @overrides equals in class Object
     * @param other the box to compare with
     * @return whether they are equal or not
     */
    public boolean equals(Object other){
        Box box = (Box) other;
        if (box.row == this.row && box.column == this.column
                && box.lines == this.lines){
            return true;
        }
        return false;
    }
}
