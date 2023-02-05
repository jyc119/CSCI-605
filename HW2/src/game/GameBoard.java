package game;

/**
 * This is the main class for representing and playing the Dots And Boxes game.
 * <pre>
 * $ java DotsAndBoxes rows columns
 * Usage: java DotsAndBoxes rows columns
 *</pre>
 *
 * @author Jordan Chin, jc9627@rit.edu
 * @author Charlie Leyens, cal3368@rit.edu
 */

public class GameBoard {

    private int rowVals;

    private int colVals;

    private int counter;

    public GameBoard(int rows, int columns) {
        rowVals = rows;
        colVals = columns;
        counter = 0;
    }

    public boolean gameOver() {
        if(counter == 2*(rowVals+1)*(colVals+1) - (rowVals+1) - (colVals+1)) {
            return true;
        }
        return false;
    }

    public Player whoseTurn() {
    }

    public boolean isLineValid(int row1, int column1, int row2, int column2) {
    }

    public void makeMove(int row1, int column1, int row2, int column2) {

    }

    public String toString() {
        String[] gameboard = {
                " ", " ", "0", " ", "1", " ", "2", " ", "3", "\n",
                " ", " ", " ", " ", " ", " ", " ", " ", " ", "\n",
                "0", " ", ".", " ", ".", " ", ".", " ", ".", "\n",
                " ", " ", " ", " ", " ", " ", " ", " ", " ", "\n",
                "1", " ", ".", " ", ".", " ", ".", " ", ".", "\n",
                " ", " ", " ", " ", " ", " ", " ", " ", " ", "\n",
                "2", " ", ".", " ", ".", " ", ".", " ", ".", "\n",
                " ", " ", " ", " ", " ", " ", " ", " ", " ", "\n",
                "Turn: ", "Red: #", "Blue: #", "Moves: #"};
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < gameboard.length; i++) {
            strBuilder.append(gameboard[i]);
        }
        return strBuilder.toString();
    }
}
