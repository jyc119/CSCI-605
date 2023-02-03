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
    public static final String EMPTY = " ";
    public static final String HORI_LINE = "-";
    public static final String VERT_LINE = "|";

    public Line(Dot firstDotVal, Dot secondDotVal) {
        firstDot = firstDotVal;
        secondDot = secondDotVal;
    }

    public Dot getFirst(){
        return firstDot;
    }

    public Dot getSecond(){
        return secondDot;
    }

    public String toString() {
        if(firstDot.getRow() == secondDot.getRow()){
            return HORI_LINE;
        }
        else if(firstDot.getColumn() == secondDot.getColumn()){
            return VERT_LINE;
        }
        else{
            return EMPTY;
        }
    }

    public boolean equals(Object other){
        Line line = (Line) other;
        if (line.firstDot == this.firstDot && line.secondDot == this.secondDot){
            return true;
        }
        return false;
    }
}
