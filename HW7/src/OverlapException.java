public class OverlapException extends BattleshipException{

    private int row;
    private int column;
    private static String OVERLAP = "battleship.OverlapException: Ships placed in overlapping positions, ";

    public OverlapException(int row, int column, String message) {
        super(OVERLAP + "row=" + row + ", column=" + column);
        this.row = row;
        this.column = column;
    }

    public String toString(){
        return "battleship.OverlapException: Ships placed in overlapping positions, row=" + row + ", column=" + column;
    }
}
