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

    private Player curPlayer;
    private int redBoxes;
    private int blueBoxes;

    /** the collection of lines */
    private Lines lines;
    /** the collection of dots */
    private Dot[][] dots;
    private Box[][] boxes;

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
        this.boxes = new Box[rows-1][columns-1];
        //create the boxes
        for (int row=0; row<rows-1; ++row) {
            for (int column=0; column<columns-1; ++column) {
                this.boxes[row][column] = new Box(row, column,lines);
            }
        }
    }

    public boolean gameOver() {
        if(counter == lines.size()) {
            return true;
        }
        return false;
    }

    public Player whoseTurn(){
        return curPlayer;
    }

    public boolean isLineValid(int row1, int column1, int row2, int column2) {
        if(lines.getLine(row1,column1,row2,column2).hasOwner() ||
                lines.getLine(row1,column1,row2,column2) == null){
            return false;
        }
        return true;
    }
//* increment counter
    public void makeMove(int row1, int column1, int row2, int column2) {
        if(isLineValid(row1,column1,row2,column2)){
            Box box1 = new Box(row1, column1, this.lines);

            lines.getLine(row1,column1,row2,column2).claim(curPlayer);

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
        }
    }

    public int getBlueBoxes() {
        return blueBoxes;
    }

    public int getRedBoxes() {
        return redBoxes;
    }

    public Lines getLines(){
        return lines;
    }

    public String toString() {

        StringBuilder gameboard = new StringBuilder();
        gameboard.append("  ");
        for(int col = 0; col < colVals; col++){
            gameboard.append(col);
            gameboard.append(" ");
        }
        gameboard.append("\n");
        for(int row = 0; row < rowVals; row++){

            gameboard.append(row + " ");
            for(int col = 0; col < colVals; col++){
                gameboard.append(".");
                gameboard.append(lines.getLine(row,col,row,col+1).toString());
            }

            gameboard.append("\n");
            gameboard.append("  ");
            for(int col = 0; col<colVals;col++){
                gameboard.append(this.lines.getLine(row,col,row+1,col).toString());
                if(col != (colVals-1) && row != (rowVals-1)) {
                    gameboard.append(boxes[row][col].toString());
                }
            }

            gameboard.append("\n");
        }
        gameboard.append("Turn: " + curPlayer + " Red: " + redBoxes + " Blue: " + blueBoxes + " Moves: "+counter);

        /*
        String[] gameboard = {
                " ", " ", "0", " ", "1", " ", "2", " ", "3", "\n",
                "0", " ", ".", " ", ".", " ", ".", " ", ".", "\n",
                " ", " ", " ", " ", " ", " ", " ", " ", " ", "\n",
                "1", " ", ".", " ", ".", " ", ".", " ", ".", "\n",
                " ", " ", " ", " ", " ", " ", " ", " ", " ", "\n",
                "2", " ", ".", " ", ".", " ", ".", " ", ".", "\n",
                " ", " ", " ", " ", " ", " ", " ", " ", " ", "\n",
                "Turn: ", "Red: #", "Blue: #", "Moves: #"};

         */

        return gameboard.toString();
    }
}
