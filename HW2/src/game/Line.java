package game;

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
    public static final String EMPTY = " ";
    public static final String HORI_LINE = "-";
    public static final String VERT_LINE = "|";

    public Line(Dot firstDotVal, Dot secondDotVal) {
        if(firstDotVal.getColumn() > secondDotVal.getColumn() || firstDotVal.getRow() > secondDotVal.getRow()){
            throw new AssertionError();
        } else {

            firstDot = firstDotVal;
            secondDot = secondDotVal;
            player = Player.NONE;
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

    public void claim(Player owner){
        player = owner;
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
        if (line.firstDot.getColumn() == this.firstDot.getColumn() && line.firstDot.getRow() == this.firstDot.getRow() && line.secondDot.getColumn() == this.secondDot.getColumn() && line.secondDot.getRow() == line.secondDot.getRow()){
            return true;
        }
        System.out.println("ggg");
        return false;
    }
}
