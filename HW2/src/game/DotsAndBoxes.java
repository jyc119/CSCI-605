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
        while(board.gameOver() == false){
            GameBoard newboard = new GameBoard(3,4);
            Scanner move = new Scanner(System.in);
            System.out.println(">");
            String gameMove = move.nextLine();
            int row1 = Integer.parseInt(String.valueOf(gameMove.charAt(0)));
            int col1 = Integer.parseInt(String.valueOf(gameMove.charAt(3)));
            int row2 = Integer.parseInt(String.valueOf(gameMove.charAt(5)));
            int col2 = Integer.parseInt(String.valueOf(gameMove.charAt(7)));
            board.makeMove(row1, col1, row2, col2);
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
        GameBoard newgameboard = new GameBoard(3,4);
        newgameboard.makeMove(0,2,1,2);
        newgameboard.makeMove(0,2,0,3);
        newgameboard.makeMove(0,3,1,3);
        newgameboard.makeMove(1,2,1,3);
        newgameboard.makeMove(1,2,2,2);
        newgameboard.makeMove(2,2,2,3);
        newgameboard.makeMove(1,3,2,3);
        System.out.println(newgameboard.toString());

    }
}
