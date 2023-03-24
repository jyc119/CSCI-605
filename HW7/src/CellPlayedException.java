public class CellPlayedException extends BattleshipException{

    private int row;
    private int column;
    private static final String ALREADY_HIT = "CellPlayedException: This cell has already been hit, ";
    public CellPlayedException(int row, int column) {
        super(ALREADY_HIT + "row=" + row + " , column=" + column);
        this.row = row;
        this.column = column;
    }
}
