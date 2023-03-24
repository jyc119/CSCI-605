public class OverlapException extends BattleshipException{

    private int row;
    private int column;
    private static String OVERLAP = "Ships placed in " +
            "overlapping positions, ";

    public OverlapException(int row, int column) {
        super(OVERLAP + "row=" + row + ", column=" + column);
        this.row = row;
        this.column = column;
    }
}
