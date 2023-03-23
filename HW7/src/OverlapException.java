public class OverlapException extends BattleshipException{

    private int row;
    private int column;

    public OverlapException(int row, int column, String message) {
        super(row, column, message);
        this.row = row;
        this.column = column;
    }

    public String toString(){
        return "battleship.OverlapException: Ships placed in overlapping positions, row=" + row + ", column=" + column;
    }
}
