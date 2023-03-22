public class ShipOutOfBoundsException extends BattleshipException{

    private int row;
    private int column;
    public ShipOutOfBoundsException(String message, int row, int column){
        super(row, column, message);
        this.row = row;
        this.column = column;
    }

    public String toString(){
        return "ShipOutOfBounds: attempted cell value of row=" + row + " , column=" + column;
    }
}
