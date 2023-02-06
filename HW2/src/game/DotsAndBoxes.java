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

    private int rowVals;

    private int colVals;

    private GameBoard board;

    public DotsAndBoxes(int rows, int columns){
        rowVals = rows;
        colVals = columns;
        board = new GameBoard(rows, columns);
    }

    public void play() {
        Scanner dimensions = new Scanner(System.in);
        System.out.println(">");
        String gameMove = dimensions.nextLine();
        while(board.gameOver() == false){
        
        }
        if(board.getBlueBoxes() > board.getRedBoxes()){
            System.out.println("BLUE wins " + board.getBlueBoxes() + " to "
                    + board.getRedBoxes() + " !");
        }
        else if(board.getRedBoxes() > board.getBlueBoxes()){
            System.out.println("RED wins " + board.getRedBoxes() + " to " +
                    board.getBlueBoxes() + " !");
        }
        else {
            System.out.println("TIE game " + board.getRedBoxes() + " to " +
                    board.getBlueBoxes() + " !");
        }
    }

    public static void main(String[] args){
        Scanner move = new Scanner(System.in);
        System.out.println(">");
        String gameMove = move.nextLine();
    }
}
