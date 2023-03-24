import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Board implements Serializable {

    private final int rowDim;

    private final int columnDim;

    private Cell[][] cells;

    private ArrayList<Ship> ships;

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

    public int getHeight() {
        return rowDim;
    }

    public int getWidth() {
        return columnDim;
    }

    public Cell getCell(int row, int column) {
        return this.cells[row][column];
    }

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

    public void addShip(Ship ship) {
        ships.add(ship);
    }

    public boolean allSunk() {
        boolean gameOver = true;
        for (Ship ship : ships) {
            if (!ship.isSunk()) {
                gameOver = false;
            }
        }
        return gameOver;
    }

    @Override
    public String toString() {
        return "The board is " + rowDim + " by " + columnDim + " with " +
                ships.size() + " ships.";
    }
}
