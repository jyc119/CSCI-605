/*
 * HW7: Battleship
 * Jordan Chin, jc9627@rit.edu
 * Charlie Leyens, cal3368@rit.edu
 */

import java.io.Serializable;

/**
 * A single spot on the Battleship game board.
 * A cell knows if there is a ship on it, and it remember
 * if it has been hit.
 *
 *  * @author Jordan Chin, jc9627@rit.edu
 *  * @author Charlie Leyens, cal3368@rit.edu
 */
public class Cell implements Serializable {

    /** Character to display for a ship that has been entirely sunk */
    public static final char SUNK_SHIP_SECTION = '*';

    /** Character to display for a ship that has been hit but not sunk */
    public static final char HIT_SHIP_SECTION = '☐';

    /** Character to display for a water cell that has been hit */
    public static final char HIT_WATER = '.';

    /**
     * Character to display for a water cell that has not been hit.
     * This character is also used for an unhit ship segment.
     */
    public static final char PRISTINE_WATER = '_';

    /**
     * Character to display for a ship section that has not been
     * sunk, when revealing the hidden locations of ships
     */
    public static final char HIDDEN_SHIP_SECTION = 'S';

    /** hit status of cell */
    public boolean hitStatus;

    /** the string representation of the state of the cell */
    public char CHARACTER_STATE = PRISTINE_WATER;

    /** cell row */
    private final int row;

    /** cell column */
    private final int column;

    /** ship associated with cell */
    public Ship ship;

    /**
     * Create a new cell
     *
     * @param row cell row
     * @param column cell column
     */
    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        this.hitStatus = false;
    }

    /**
     * Place a ship on this cell. Of course, ships typically cover more than one
     * Cell, so the same ship will usually be passed to more than one Cell's
     * putShip method.
     *
     * @param ship ship to be placed on cell
     * @throws OverlapException - if there is already a ship there
     */
    public void putShip(Ship ship) throws OverlapException{
        if (!(this.ship == null)) {
            throw new OverlapException(row, column);
        }
        else {
            this.ship = ship;
        }
    }

    /**
     * Simulate hitting this cell. If there is a ship here, it will be hit.
     * Calling this method changes the status of the cell, as reflected by
     * displayChar() and displayHitStatus().
     *
     * @throws CellPlayedException - if this cell had already been hit
     */
    public void hit() throws CellPlayedException {
        if(hitStatus) {
            throw new CellPlayedException(this.row, this.column);
        }
        if (!(this.ship == null)) {
            hitStatus = true;
            CHARACTER_STATE = HIT_SHIP_SECTION;
            this.ship.hit();
        }
        else {
            CHARACTER_STATE = HIT_WATER;
            hitStatus = true;
        }
    }


    public char displayHitStatus() {return CHARACTER_STATE;}

    public char displayChar() {
        if (hitStatus) {
            return CHARACTER_STATE;
        }
        else if (this.ship == null) {
            return PRISTINE_WATER;
        }
        else {
            return HIDDEN_SHIP_SECTION;
        }
    }
}