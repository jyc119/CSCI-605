package game;

import java.util.Scanner;

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
    private Dot first;
    private Dot second;

    public Line(Dot firstDot, Dot secondDot) {
        first = firstDot;
        second = secondDot;
    }
}
