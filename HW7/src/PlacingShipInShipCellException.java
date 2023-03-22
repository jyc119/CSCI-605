public class PlacingShipInShipCellException extends BattleshipException{

    private int row;
    private int column;

    public PlacingShipInShipCellException(int row, int column, String message) {
        super(row, column, message);
    }

    public String toString(){
        return "PlacingShipInShipCellException: attempted to place ship at row=" + row + " , column=" + column;
    }
}
