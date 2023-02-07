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
    private Box[][] boxes;

    /**
     *Create the game board. the red player goes first.
     *
     * @param rows number of rows
     * @param columns number of columns
     */
    public GameBoard(int rows, int columns) {
        rowVals = rows+1;
        colVals = columns+1;
        counter = 0;
        curPlayer = Player.RED;
        redBoxes = 0;
        blueBoxes = 0;

        // create the dots
        this.dots = new Dot[rowVals+1][colVals+1];
        for (int row=0; row<=rowVals; ++row) {
            for (int column=0; column<=colVals; ++column) {
                this.dots[row][column] = new Dot(row, column);
            }
        }
        // create the lines
        this.lines = new Lines(rowVals, colVals, this.dots);
        this.boxes = new Box[rowVals-1][colVals-1];
        //create the boxes
        for (int row=0; row<rowVals-1; ++row) {
            for (int column=0; column<colVals-1; ++column) {
                this.boxes[row][column] = new Box(row, column,lines);
            }
        }
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
        Line curLine = lines.getLine(row1,column1,row2,column2);
        if(curLine == null || curLine.hasOwner() || curLine.getFirst().getColumn() > curLine.getSecond().getColumn() ||
                curLine.getFirst().getRow() > curLine.getSecond().getRow()
        ){
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
            Box[][] curboxes = boxes;
            lines.getLine(row1,column1,row2,column2).claim(curPlayer);
            curPlayer = (curPlayer == Player.RED) ? Player.BLUE : Player.RED;
            for(int i=0; i < lines.getLine(row1,column1,row2,column2).getBoxes().size(); i++){
                if(lines.getLine(row1,column1,row2,column2).getBoxes().get(i).getOwner() != Player.NONE){
                    curPlayer = (curPlayer == Player.RED) ? Player.BLUE : Player.RED;
                    break;
                }
            }
            counter += 1;
            /*
            if(lines.getLine(row1,column1,row2,column2).getBoxes().get(0).getOwner() == Player.NONE){
                curPlayer = (curPlayer == Player.RED) ? Player.BLUE : Player.RED;
            }
             */
            /*
            if(row1 > 0 && row1 < rowVals){
                Box box2 = new Box(row1-1,column1,this.lines);
                if(box1.getOwner() == Player.NONE && box2.getOwner() ==
                        Player.NONE){curPlayer = (curPlayer == Player.RED)
                        ? Player.BLUE : Player.RED;
                }
            }
            else if(column1 > 0 && column1 < colVals){
                Box box2 = new Box(row1, column1-1,this.lines);
                if(box1.getOwner() == Player.NONE && box2.getOwner() ==
                        Player.NONE){curPlayer = (curPlayer == Player.RED)
                        ? Player.BLUE : Player.RED;
                }
            }
            counter += 1;

             */
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

    public String toString() {
        StringBuilder gameboard = new StringBuilder();
        gameboard.append("  ");
        for(int col = 0; col < colVals; col++){
            gameboard.append(col);
            gameboard.append(" ");
        }
        gameboard.append("\n");
        int blueboxes = 0;
        int redboxes = 0;
        for(int row = 0; row < rowVals; row++){

            gameboard.append(row + " ");
            for(int col = 0; col < colVals; col++){
                gameboard.append(".");
                gameboard.append(lines.getLine(row,col,row,
                        col+1).toString());
            }

            gameboard.append("\n");
            gameboard.append("  ");
            for(int col = 0; col<colVals;col++){
                gameboard.append(this.lines.getLine(row,col,
                        row+1,col).toString());
                if(col != (colVals-1) && row != (rowVals-1)) {
                    gameboard.append(boxes[row][col].toString());
                    if(boxes[row][col].toString() ==  "B"){
                        blueboxes += 1;
                    } else if(boxes[row][col].toString() == "R"){
                        redboxes += 1;
                    }
                }
            }
            gameboard.append("\n");
        }
        blueBoxes = blueboxes;
        redBoxes = redboxes;
        gameboard.append(" Turn: " + curPlayer + " Red: " + redBoxes + " Blue: " + blueBoxes + " Moves: "+counter);
        return gameboard.toString();
    }
}
