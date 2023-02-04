package game;

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
    NONE("N"), RED("R"), BLUE("B");

    private String player;
    Player(String  player){
        this.player = player;
    }
    /*
    public static game.Player[] values(){
        game.Player[] player = {NONE, RED, BLUE};
        return player;
    }

    public static game.Player valueOf(String name){
        if (name == null){
            throw NullPointerException;
        }
        else if (name != "BLUE" || name != "RED" || name != "NONE"){
            throw IllegalArgumentException;
        }
        else
        }
    }
     */

    public String getLabel() {
        switch (this){
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


