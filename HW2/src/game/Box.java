package game;

import java.util.Scanner;

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

    public Box(int allRows, int allCols, Lines allLines){
        row = allRows;
        column = allCols;
        lines = allLines;
    }

    public int getRow(){
        return row;
    }

    public int getColumn(){
        return column;
    }

    public void claim(Player player){

    }

    public Line getTopLine(){

    }

    public Line getBottomLine(){

    }

    public Line getRightLine(){

    }

    public Line getLeftLine(){

    }

}
