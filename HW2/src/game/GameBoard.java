/*
 * HW2: Dots and Boxes
 * Jordan Chin, jc9627@rit.edu
 * Charlie Leyens, cal3368@rit.edu
 */

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

    /** the number of rows */
    private int rowVals;

    /** the number of columns */
    private int colVals;

    /** the counter for number of moves */
    private int counter;

    /** the player whose turn it is */
    private Player curPlayer;

    /** the collection of boxes claimed by RED */
    private int redBoxes;

    /** the collection of boxes claimed by BLUE */
    private int blueBoxes;

    /** the collection of lines */
    private Lines lines;

    /** the collection of dots */
    private Dot[][] dots;

    /**
     *Create the game board. the red player goes first.
     *
     * @param rows number of rows
     * @param columns number of columns
     */
    public GameBoard(int rows, int columns) {
        rowVals = rows;
        colVals = columns;
        counter = 0;
        curPlayer = Player.RED;
        redBoxes = 0;
        blueBoxes = 0;

        // create the dots
        this.dots = new Dot[rows+1][columns+1];
        for (int row=0; row<=rows; ++row) {
            for (int column=0; column<=columns; ++column) {
                this.dots[row][column] = new Dot(row, column);
            }
        }
        // create the lines
        this.lines = new Lines(rows, columns, this.dots);
    }

    /**
     *Is the game over? This happens when the number of lines claimed equals the
     *  number of moves made.
     *
     * @return whether the game is over, man!
     */
    public boolean gameOver() {
        if(counter == lines.size()) {
            return true;
        }
        return false;
    }

    /**
     *Whose turn is it anyway?
     *
     * @return the player who has the current turn
     */
    public Player whoseTurn(){
        return curPlayer;
    }

    /**
     *Are the coordinates for this line valid or not? To be valid it must be a
     * line that exists and is unclaimed.
     *
     * @param row1 first row
     * @param column1 first column
     * @param row2 second row
     * @param column2 second column
     * @return whether the line is valid or not
     */
    public boolean isLineValid(int row1, int column1, int row2, int column2) {
        if(lines.getLine(row1,column1,row2,column2).hasOwner() ||
                lines.getLine(row1,column1,row2,column2) == null){
            return false;
        }
        return true;
    }

    /**
     *Make a move in the game given a valid line to claim. A move is made by
     * specifying an unclaimed line to be owned by the current player. If the
     * move claims a box, that player gets to go again, otherwise the next turn
     * is swapped to the other player.
     *
     * @param row1 first row
     * @param column1 first column
     * @param row2 second row
     * @param column2 second column
     */
    public void makeMove(int row1, int column1, int row2, int column2) {
        if(isLineValid(row1,column1,row2,column2)){
            Box box1 = new Box(row1, column1, this.lines);

            if(row1 > 0 && row1 < rowVals){
                Box box2 = new Box(row1-1,column1,this.lines);
                lines.getLine(row1,column1,row2,column2).claim(curPlayer);
                if(box1.getOwner() == Player.NONE && box2.getOwner() ==
                        Player.NONE){curPlayer = (curPlayer == Player.RED)
                        ? Player.BLUE : Player.RED;
                }
            }
            else if(column1 > 0 && column1 < colVals){
                Box box2 = new Box(row1, column1-1,this.lines);
                lines.getLine(row1,column1,row2,column2).claim(curPlayer);
                if(box1.getOwner() == Player.NONE && box2.getOwner() ==
                        Player.NONE){curPlayer = (curPlayer == Player.RED)
                        ? Player.BLUE : Player.RED;
                }
            }
            counter += 1;
        }
    }

    /**
     * Get the blue boxes.
     *
     * @return blue boxes
     */
    public int getBlueBoxes() {
        return blueBoxes;
    }

    /**
     *Get the red boxes.
     *
     * @return red boxes
     */
    public int getRedBoxes() {
        return redBoxes;
    }

    /**
     *Return a string representation of the board, e.g. a 2x3 board:
     *    0 1 2 3
     *  0 .-. . .
     *    |R|   |
     *  1 .-.-.-.
     *    |B|
     *  2 ._._. .
     *
     *  Turn: {PLAYER}, Red: #, Blue: # , Moves: #
     *
     * @overrides toString in class Object
     * @return the string
     */
    public String toString() {
        StringBuilder gameboard = new StringBuilder();
        gameboard.append(String.join(" ", " ", "0", " ", "1", " ", "2", " ", "3", "\n"));
        for(int row = 0; row < rowVals; row++){
            for(int col = 0; col < colVals; col++){
                gameboard.append(" ");
                if(row % 2 == 0){
                    if(col%2 == 0){
                        gameboard.append(" ");
                    } else{
                        gameboard.append(lines.getLine(row,col,row,col+1).toString());
                    }
                }else{
                    if(col%2 == 0){
                        gameboard.append(lines.getLine(row,col,row+1,col).toString());
                    }
                    else{
                        Box curbox = new Box(row-1,col-1,lines);
                        if(curbox.getOwner() == Player.RED){
                            redBoxes += 1;
                        }else if(curbox.getOwner() == Player.BLUE){
                            blueBoxes += 1;
                        }
                        gameboard.append(curbox.toString());
                    }
                }
            }
            gameboard.append("\n");
        }
        gameboard.append(String.join("Turn: " + curPlayer, "Red: " + redBoxes, "Blue: " + blueBoxes, "Moves: "+counter));
        return gameboard.toString();
    }
}
