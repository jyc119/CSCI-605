public class OutOfBoundsException extends BattleshipException{

    private int row;
    private int column;
    public OutOfBoundsException(String message, int row, int column){
        super(row, column, message);
        this.row = row;
        this.column = column;
    }

    public String toString(){
        return "battleship.OutOfBoundsException: Coordinates are past board edge, row=" + row + ", column=" + column;
    }
}
