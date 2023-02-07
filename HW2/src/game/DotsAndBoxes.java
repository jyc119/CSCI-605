/*
 * HW2: Dots and Boxes
 * Jordan Chin, jc9627@rit.edu
 * Charlie Leyens, cal3368@rit.edu
 */

package game;

import java.util.Objects;
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

    /** the prompt for the user to enter coordinates */
    public static final String PROMPT = ">";

    /** the number of rows */
    private int rowVals;

    /** the number of columns */
    private int colVals;

    /** the game board */
    private GameBoard board;

    /**
     *Create the game.
     *
     * @param rows number of rows in the board
     * @param columns number of columns in the board
     */
    public DotsAndBoxes(int rows, int columns){
        rowVals = rows;
        colVals = columns;
        board = new GameBoard(rows, columns);
    }

    /**
     *The game play loop.
     */
    public void play() {
        while(board.gameOver() == false){
            System.out.println(board.toString());
            Scanner move = new Scanner(System.in);
            System.out.println(">");
            String gameMove = move.nextLine();
            gameMove = gameMove.replaceAll("\\s", "");
            if(gameMove.equals("q")){
                return;
            }
            int row1 = Integer.parseInt(String.valueOf(gameMove.charAt(0)));
            int col1 = Integer.parseInt(String.valueOf(gameMove.charAt(1)));
            int row2 = Integer.parseInt(String.valueOf(gameMove.charAt(2)));
            int col2 = Integer.parseInt(String.valueOf(gameMove.charAt(3)));
            if(board.isLineValid(row1, col1, row2, col2)){
                board.makeMove(row1, col1, row2, col2);
            }
            else {
                System.out.println("Invalid line!");
            }
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

    /**
     *The main routine gets the row and column from the command line and then
     * instantiates and plays the game.
     *
     * @param args command line arguments
     */
    public static void main(String[] args){
        DotsAndBoxes gb = new DotsAndBoxes(3,4);
        gb.play();

    }
}
