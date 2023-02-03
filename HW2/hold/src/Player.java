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

        return [NONE, RED, BLUE];
    }

    public static Player valueOf(String name){

    }

    public String getLabel() {
        switch(this){
            case NONE:
                return "None";
            case RED:
                return "R";
            case BLUE:
                return "B";
        }
        return null;
    }
}


