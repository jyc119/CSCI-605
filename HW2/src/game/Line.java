/*
 * HW2: Dots and Boxes
 * Jordan Chin, jc9627@rit.edu
 * Charlie Leyens, cal3368@rit.edu
 */

package game;

import java.util.ArrayList;

/**
 * Represents a single line in the game of Dots and Boxes.
 * <pre>
 * $ java DotsAndBoxes rows columns
 * Usage: java DotsAndBoxes rows columns
 *</pre>
 *
 * @author Jordan Chin, jc9627@rit.edu
 * @author Charlie Leyens, cal3368@rit.edu
 */

public class Line {

    /** the first dot */
    private Dot firstDot;

    /** the second dot */
    private Dot secondDot;

    /** the player */
    private Player player;

    /** the collection of boxes */
    private ArrayList<Box> boxes;

    /** an unclaimed line */
    public static final String EMPTY = " ";

    /** horizontal line */
    public static final String HORI_LINE = "-";

    /** vertical line */
    public static final String VERT_LINE = "|";

    /**
     * Create the line.
     *
     * @param firstDotVal the first coordinate
     * @param secondDotVal the second coordinate
     */
    public Line(Dot firstDotVal, Dot secondDotVal) {
        if(firstDotVal.getColumn() > secondDotVal.getColumn() ||
                firstDotVal.getRow() > secondDotVal.getRow()){
            throw new AssertionError();
        }
        else{
            firstDot = firstDotVal;
            secondDot = secondDotVal;
            player = Player.NONE;
            boxes =  new ArrayList<>();
        }
    }

    /**
     * Get the first coordinate.
     *
     * @return first dot
     */
    public Dot getFirst(){
        return firstDot;
    }

    /**
     * Get the second coordinate.
     *
     * @return second dot
     */
    public Dot getSecond(){
        return secondDot;
    }

    /**
     * Get the owner of the line.
     *
     * @return the owner, if any
     */
    public Player getOwner(){
        return player;
    }

    /**
     * Check if the line has been claimed.
     *
     * @return the owner, if any
     */
    public boolean hasOwner(){
        if(player == Player.RED || player == Player.BLUE ){
            return true;
        }
        return false;
    }

    /**
     * Get the boxes associated with this line.
     *
     * @return the associated boxes
     */
    public ArrayList<Box> getBoxes(){
        return boxes;
    }

    /**
     * Claim a line, and possibly also claims associated boxes.
     *
     * @param owner the owner
     */
    public void claim(Player owner){
        player = owner;
        for (int counter = 0; counter < boxes.size(); counter++){
            if(boxes.get(counter).getTopLine().hasOwner() &&
                    boxes.get(counter).getBottomLine().hasOwner() &&
                    boxes.get(counter).getLeftLine().hasOwner() &&
                    boxes.get(counter).getRightLine().hasOwner()){
                boxes.get(counter).claim(owner);
            }
        }
    }

    /**
     * Set a line with a box it is associated with.
     *
     * @param box the box to associate with
     */
    public void setBox(Box box){
        boxes.add(box);
    }

    /**
     * Returns a string representation of the line,
     * " " for empty, "-" for a horizontal line, and "|" for a vertical line.
     *
     * @overrides toString in class Object
     * @return the string
     */
    public String toString() {
        if(firstDot.getRow() == secondDot.getRow() && player != Player.NONE){
            return HORI_LINE;
        }
        else if(firstDot.getColumn() == secondDot.getColumn() && player
                != Player.NONE){
            return VERT_LINE;
        }
        else{
            return EMPTY;
        }
    }

    /**
     * Two lines are equal if their first and second dots are equal.
     *
     * @overrides equals in class Object
     * @param other the line to compare with
     * @return whether the lines are equal or not
     */
    public boolean equals(Object other){
        Line line = (Line) other;
        if (line.firstDot.equals(this.firstDot) &&
                line.secondDot.equals(this.secondDot)){
            return true;
        }
        return false;
    }
}
