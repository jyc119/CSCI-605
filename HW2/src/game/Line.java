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
    private Dot firstDot;
    private Dot secondDot;
    private Player player;
    private ArrayList<Box> boxes;
    public static final String EMPTY = " ";
    public static final String HORI_LINE = "-";
    public static final String VERT_LINE = "|";

    public Line(Dot firstDotVal, Dot secondDotVal) {
        if(firstDotVal.getColumn() > secondDotVal.getColumn() || firstDotVal.getRow() > secondDotVal.getRow()){
            throw new AssertionError();
        }
        /*
        else if(this.toString() == HORI_LINE && this.firstDot.getRow() - 1 > 0 && this.firstDot.getRow() + 1 > 0 ||
                  this.toString() == VERT_LINE && this.firstDot.getColumn() - 1 > 0 && this.firstDot.getColumn() + 1 > 0) {
            firstDot = firstDotVal;
            secondDot = secondDotVal;
            player = Player.NONE;
        }
         */
        else{
            firstDot = firstDotVal;
            secondDot = secondDotVal;
            player = Player.NONE;
            boxes =  new ArrayList<Box>();
        }
    }

    public Dot getFirst(){
        return firstDot;
    }

    public Dot getSecond(){
        return secondDot;
    }

    public Player getOwner(){
        return player;
    }
    /*
    public ArrayList<Box> getBoxes(){
        if(firstDot.getRow() == secondDot.getRow()){

        }
    }
    */

    public boolean hasOwner(){
        if(player == Player.RED || player == Player.BLUE ){
            return true;
        }
        return false;
    }

    public ArrayList<Box> getBoxes(){
        return boxes;
    }

    public void claim(Player owner){
            player = owner;
    }

    public void setBox(Box box){
        boxes.add(box);
    }

    public String toString() {
        if(firstDot.getRow() == secondDot.getRow() && player != Player.NONE){
            return HORI_LINE;
        }
        else if(firstDot.getColumn() == secondDot.getColumn() && player != Player.NONE){
            return VERT_LINE;
        }
        else{
            return EMPTY;
        }
    }

    public boolean equals(Object other){
        Line line = (Line) other;
        if (line.firstDot.equals(this.firstDot) && line.secondDot.equals(this.secondDot)){
            return true;
        }
        System.out.println("ggg");
        return false;
    }
}
