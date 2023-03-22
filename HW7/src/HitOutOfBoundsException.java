public class HitOutOfBoundsException extends BattleshipException{

    private int row;
    private int column;
    public HitOutOfBoundsException(int row, int column, String message) {
        super(row, column, message);
        this.row = row;
        this.column = column;
    }

    public String toString(){
        return "HitOutOfBoundsException: attempted to hit at row=" + row + " , column=" + column;
    }
}
