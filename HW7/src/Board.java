import java.io.PrintStream;
import java.io.Serializable;

public class Board implements Serializable {

    private final int rowDim;

    private final int columnDim;

    private Cell[][] cells;

    public int ships;

    public Board(int rowDim, int columnDim) {
        this.rowDim = rowDim;
        this.columnDim = columnDim;
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

    }

    public void fullDisplay(PrintStream fullStream) {

    }

    public void addShip(Ship ship) {
        ships++;
    }

    public boolean allSunk() {
        if (ships == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public String toString() {
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
        return board.toString();
    }

    public String revealBoard() {
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
        return board.toString();
    }
}
