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

}
