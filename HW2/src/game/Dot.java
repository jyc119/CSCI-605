package game;

import java.util.Scanner;

/**
 * Represents a single dot in the game of Dots and Boxes.
 * <pre>
 * $ java DotsAndBoxes rows columns
 * Usage: java DotsAndBoxes rows columns
 *</pre>
 *
 * @author Jordan Chin, jc9627@rit.edu
 * @author Charlie Leyens, cal3368@rit.edu
 */

public class Dot {
    private int xcor;
    private int ycor;

    public Dot(int xVal, int yVal){
        xcor = xVal;
        ycor = yVal;
    }

    public int getRow(){
        return xcor;
    }

    public int getColumn(){
        return ycor;
    }

}
