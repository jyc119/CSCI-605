import java.io.Serializable;

/**
 * A single spot on the Battleship game board.
 * A cell knows if there is a ship on it, and it remember
 * if it has been hit.
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

    public char CHARACTER_STATE = PRISTINE_WATER;

    private final int row;

    private final int column;

    public Ship ship;


    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public void putShip(Ship ship) {
        this.ship = ship;
    }

    public Ship getShip(){
        return this.ship;
    }

    public void hit() throws CellPlayedException {
        if(CHARACTER_STATE == HIT_WATER ||
                CHARACTER_STATE == HIT_SHIP_SECTION ||
                CHARACTER_STATE == SUNK_SHIP_SECTION){
            throw new CellPlayedException(this.row, this.column, "Already hit!");
        }
        if (!(this.ship == null)) {
            CHARACTER_STATE = HIT_SHIP_SECTION;
            this.ship.hit();
        }
        else {
            CHARACTER_STATE = HIT_WATER;
        }
    }

//    public char displayHitStatus() {
//    }

    public char displayChar() {
        return CHARACTER_STATE;
    }
}
