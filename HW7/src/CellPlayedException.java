public class CellPlayedException extends BattleshipException{

    private int row;
    private int column;
    public CellPlayedException(int row, int column, String message) {
        super(row, column, message);
        this.row = row;
        this.column = column;
    }

    public String toString(){
        return "CellPlayedException: This cell has already been hit, row=" + row + " , column=" + column;
    }
}
