package client;

import common.ConcentrationException;
import common.ConcentrationProtocol;
import game.ConcentrationCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConcentrationClientBoard {

    /** the actual board is a 2-D grid of cards */
    private ConcentrationCard board[][];

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
    public ConcentrationClientBoard(int DIM, boolean cheat) throws
            ConcentrationException {
//        // check for bad dimensions
//        if (DIM < MIN_DIM || DIM > MAX_DIM) {
//            throw new ConcentrationException("Board size out of range: " + DIM);
//        } else if (DIM % 2 != 0) {
//            throw new ConcentrationException("Board size not even: " + DIM);
//        }

        /** create the pair of cards and shuffle them */
        List<Character> chars = new ArrayList<>(DIM*DIM);
        for (char i=0; i<(DIM*DIM)/2; ++i) {
            chars.add((char)(i+'A'));
            chars.add((char)(i+'A'));
        }
        Collections.shuffle(chars);

        /**
         * Create the grid of cards and populate from the shuffled list.
         */
        this.DIM = DIM;
        this.board = new ConcentrationCard[DIM][DIM];
        for (int row=0; row<DIM; ++row) {
            for (int col=0; col<DIM; ++col) {
                this.board[row][col] = new ConcentrationCard(row, col,
                        chars.remove(0));
            }
        }

        // if cheat mode is enabled display the fully revealed board
        if (cheat) {
            System.out.println("SOLUTION:");
            System.out.println(this.toString());
        }

        // hide all the cards in the board
        for (int row = 0; row < DIM; ++row) {
            for (int col = 0; col < DIM; ++col) {
                this.board[row][col].hide();
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
     * Get a card from the board at a coordinate.
     *
     * @param row the row
     * @param col the column
     * @return the card
     * @throws ConcentrationException if the coordinate is invalid
     */
    public ConcentrationCard getCard(int row, int col)
            throws ConcentrationException {
        if (row < 0 || col < 0 || row > DIM-1 || col > DIM-1) {
            throw new ConcentrationException(String.format(ConcentrationProtocol.ERROR_MSG, "Invalid coordinate"));
        }
        return board[row][col];
    }

    /**
     * Returns a string representation of the board, for example a
     * 4x4 game that is just underway.
     *
     *   0123
     * 0|G...
     * 1|G...
     * 2|....
     * 3|....
     *
     * @return the board as a string
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
                ConcentrationCard card = this.board[row][col];
                // based on whether the card is hidden or not display
                // build with the correct letter
                if (card.isHidden()) {
                    str.append(ConcentrationCard.HIDDEN);
                } else {
                    str.append(this.board[row][col].getLetter());
                }
            }
            str.append("\n");
        }
        return str.toString();
    }
}
