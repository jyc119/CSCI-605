/*
 * HW7: Battleship
 * Jordan Chin, jc9627@rit.edu
 * Charlie Leyens, cal3368@rit.edu
 */

import java.io.PrintStream;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The class to represent the grid of cells (squares). A collection of ships is
 * also kept so the Board can be asked if the game is over. The class is
 * Serializable so that its instance can be saved to a file in binary form using
 * an ObjectOutputStream and restored with an ObjectInputStream. Because the
 * object holds references to all other objects in the system, no other objects
 * need to be separately saved.
 *
 * @author Jordan Chin, jc9627@rit.edu
 * @author Charlie Leyens, cal3368@rit.edu
 */
public class Board implements Serializable {

    /** number of rows */
    private final int rowDim;

    /** number of columns */
    private final int columnDim;

    /** 2D array of cells */
    private Cell[][] cells;

    /** list of ships on board */
    private ArrayList<Ship> ships;

    /**
     * Construct a board.
     *
     * @param rowDim number of cells down
     * @param columnDim number of cells across
     */
    public Board(int rowDim, int columnDim) {
        this.rowDim = rowDim;
        this.columnDim = columnDim;
        ships = new ArrayList<>();
        //Create cells
        this.cells = new Cell[rowDim+1][columnDim+1];
        for (int row=0; row<=rowDim; ++row) {
            for (int column=0; column<=columnDim; ++column) {
                this.cells[row][column] = new Cell(row, column);
            }
        }
    }

    /**
     * Used for input error checking.
     *
     * @return the number of rows in the board
     */
    public int getHeight() {
        return rowDim;
    }

    /**
     * Used for error checking.
     *
     * @return the number of columns in the board
     */
    public int getWidth() {
        return columnDim;
    }

    /**
     * Fetch the Cell object at the given location.
     *
     * @param row row number (0-based)
     * @param column column number (0-based)
     * @return the Cell created for this position on the board
     * @throws OutOfBoundsException - if either coordinate is negative or too
     * high
     */
    public Cell getCell(int row, int column) {
        return this.cells[row][column];
    }

    /**
     * Display the board in character form to the user. Cells' display
     * characters are described in Cell. Output is double-spaced in both
     * dimensions. The numbers of the columns appear above the first row,
     * and the numbers of each row appears to the left of the row.
     *
     * @param stream the output stream to which the display should be sent
     */
    public void display(PrintStream stream) {
        StringBuilder board = new StringBuilder();
        board.append("  ");
        for(int col = 0; col < columnDim; col++){
            board.append(col);
            board.append(" ");
        }
        board.append("\n");
        for(int row = 0; row < rowDim; row++) {
            board.append(row + " ");
            for (int col = 0; col < columnDim; col++) {
                board.append(cells[row][col].displayHitStatus());
                board.append(" ");
            }
            board.append("\n");
        }
        stream.append("\n");
        stream.append(board);
        stream.append("\n");
    }

    /**
     * This is the "cheating" form of the display because the user can see where
     * the unsunk parts of ships are. Cells' display characters are described in
     * Cell. Output is double-spaced in both dimensions. The numbers of the
     * columns appear above the first row, and the numbers of each row appears
     * to the left of the row.
     *
     * @param fullStream the output stream to which the display should be sent
     */
    public void fullDisplay(PrintStream fullStream) {
        StringBuilder board = new StringBuilder();
        board.append("  ");
        for(int col = 0; col < columnDim; col++){
            board.append(col);
            board.append(" ");
        }
        board.append("\n");
        for(int row = 0; row < rowDim; row++) {
            board.append(row + " ");
            for (int col = 0; col < columnDim; col++) {
                board.append(cells[row][col].displayChar());
                board.append(" ");
            }
            board.append("\n");
        }
        fullStream.append("\n");
        fullStream.append(board);
        fullStream.append("\n");
    }

    /**
     * Add a ship to the board. The only current reason that the board needs
     * direct access to the ships is to poll them to see if they are all sunk
     * and the game is over.
     *
     * @param ship the as-yet un-added ship
     */
    public void addShip(Ship ship) {
        ships.add(ship);
    }

    /**
     * Is the game over?
     *
     * @return true iff all ships report being sunk
     */
    public boolean allSunk() {
        boolean gameOver = true;
        for (Ship ship : ships) {
            if (!ship.isSunk()) {
                gameOver = false;
            }
        }
        return gameOver;
    }

    /**
     * Useful for debugging. This is not the method that displays the board
     * to the user.
     *
     * @return a one-line (hopefully) description of the board
     */
    @Override
    public String toString() {
        return "The board is " + rowDim + " by " + columnDim + " with " +
                ships.size() + " ships.";
    }
}
