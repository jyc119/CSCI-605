package game;

import java.util.Scanner;

/**
 * The main program for the pen and paper game, Dots And Boxes.
 * <pre>
 * $ java game.DotsAndBoxes rows columns
 * Usage: java game.DotsAndBoxes rows columns
 *</pre>
 *
 * @author Jordan Chin, jc9627@rit.edu
 * @author Charlie Leyens, cal3368@rit.edu
 */

public class DotsAndBoxes {


    public static final String PROMPT = ">";

    public DotsAndBoxes(int rows, int columns){
        rows = rowsTotal;
        columns = columnsTotal;
    }

    public void play() {
}

    public static void main(String[] args){
        Scanner move = new Scanner(System.in);
        System.out.println(">");
        String gameMove = move.nextLine();
        System.out.println(gameMove);
    }
}
