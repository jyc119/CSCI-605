public class OutOfBoundsException extends BattleshipException{

    private int row;
    private int column;
    private static final String PAST_EDGE = "battleship.OutOfBoundsException: Coordinates are past board edge, ";
    public OutOfBoundsException(int row, int column){
        super(PAST_EDGE + "row=" + row + ", column=" + column);
        this.row = row;
        this.column = column;
    }
}
