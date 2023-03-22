public class CellAlreadyHitException extends BattleshipException{

    private int row;
    private int column;
    public CellAlreadyHitException(int row, int column, String message) {
        super(row, column, message);
        this.row = row;
        this.column = column;
    }

    public String toString(){
        return "CellAlreadyHitException: attempted to hit already hit cell at row=" + row + " , column=" + column;
    }
}
