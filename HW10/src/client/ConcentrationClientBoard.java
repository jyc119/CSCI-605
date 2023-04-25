/*
 * HW10: Concentration
 * Jordan Chin, jc9627@rit.edu
 * Charlie Leyens, cal3368@rit.edu
 */

package client;

import common.ConcentrationException;
import common.ConcentrationProtocol;

/**
 * The board for the concentration client
 *
 * @author RIT CS
 * @author Jordan Chin, jc9627@rit.edu
 * @author Charlie Leyens, cal3368@rit.edu
 */
public class ConcentrationClientBoard {

    private String board[][];

    /** the square dimension of the board */
    private int DIM;

    /**
     * Create the board in non-cheat mode.
     *
     * @param DIM square dimension
     * @throws ConcentrationException if the dimension is illegal
     */
    public ConcentrationClientBoard(int DIM) throws ConcentrationException {
        this(DIM, false);
    }

    /**
     * Create the board.
     *
     * @param DIM square dimension
     * @param cheat whether to display the fully revealed board or not
     * @throws ConcentrationException if the dimensions are invalid
     */
    public ConcentrationClientBoard(int DIM, boolean cheat) {
        /**
         * Create the grid of cards and populate from the shuffled list.
         */
        this.DIM = DIM;
        this.board = new String[DIM][DIM];

        // hide all the cards in the board
        for (int row = 0; row < DIM; ++row) {
            for (int col = 0; col < DIM; ++col) {
                this.board[row][col] = ".";
            }
        }
    }

    /**
     * Get the square dimension of the board
     * @return square dimension
     */
    public int getDIM() {
        return this.DIM;
    }

    /**
     * Gets the card at the specified row ad column
     * @param row The row of the card
     * @param col The column of the card
     * @return The card
     * @throws ConcentrationException
     */
    public String getCard(int row, int col)
            throws ConcentrationException {
        if (row < 0 || col < 0 || row > DIM-1 || col > DIM-1) {
            throw new ConcentrationException(String.format(ConcentrationProtocol
                    .ERROR_MSG, "Invalid coordinate"));
        }
        return board[row][col];
    }

    /**
     * Set a letter at a board location
     * @param row The row of the card
     * @param col The column of the card
     * @param letter The letter set
     */
    public void setCard(int row, int col, String  letter){
        this.board[row][col] = letter;
    }

    /**
     * Return a string representation of the board
     * @return The board
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        // build the top row of indices
        str.append("  ");
        for (int col=0; col<this.DIM; ++col) {
            str.append(col);
        }
        str.append("\n");
        // build each row of the actual board
        for (int row=0; row<this.DIM; ++row) {
            str.append(row).append("|");
            // build the columns of the board
            for (int col=0; col<this.DIM; ++col) {
                str.append(this.board[row][col]);
            }
            str.append("\n");
        }
        return str.toString();
    }
}
