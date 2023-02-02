package game;

import java.util.Scanner;

/**
 * This class is an enumeration for representing the players in the Dots And Boxes game.
 * <pre>
 * $ java DotsAndBoxes rows columns
 * Usage: java DotsAndBoxes rows columns
 *</pre>
 *
 * @author Jordan Chin, jc9627@rit.edu
 * @author Charlie Leyens, cal3368@rit.edu
 */

public enum Player {
    NONE, RED, BLUE;

    public static Player[] values(){

    }

    public static Player valueOf(String name){

    }

    public String getLabel() {
        switch(this){
            case NONE:
                return "NONE";
            case RED:
                return "RED";
            case BLUE:
                return "BLUE";
        }
    }
}


