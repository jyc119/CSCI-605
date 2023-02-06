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

    /** the collection of lines */
    private Lines lines;
    /** the collection of dots */
    private Dot[][] dots;

    public GameBoard(int rows, int columns) {
        rowVals = rows;
        colVals = columns;
        counter = 0;
        curPlayer = Player.RED;

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

    public boolean gameOver() {
        if(counter == 2*(rowVals+1)*(colVals+1) - (rowVals+1) - (colVals+1)) {
            return true;
        }
        return false;
    }

    public Player whoseTurn(){
        return curPlayer;
    }

    public boolean isLineValid(int row1, int column1, int row2, int column2) {
        if(lines.getLine(row1,column1,row2,column2).hasOwner() || lines.getLine(row1,column1,row2,column2) == null){
            return false;
        }
        return true;
    }
//* increment counter
    public void makeMove(int row1, int column1, int row2, int column2) {
        Box box1 = new Box(row1, column1, this.lines);

        if(row1 > 0 && row1 < rowVals){
            Box box2 = new Box(row1-1,column1,this.lines);
            lines.getLine(row1,column1,row2,column2).claim(curPlayer);
            if(box1.getOwner() == Player.NONE && box2.getOwner() == Player.NONE){
                curPlayer = (curPlayer == Player.RED) ? Player.BLUE : Player.RED;
            }
        }

        else if(column1 > 0 && column1 < colVals){
            Box box2 = new Box(row1, column1-1,this.lines);
            lines.getLine(row1,column1,row2,column2).claim(curPlayer);
            if(box1.getOwner() == Player.NONE && box2.getOwner() == Player.NONE){
                curPlayer = (curPlayer == Player.RED) ? Player.BLUE : Player.RED;
            }
        }

        counter += 1;
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
