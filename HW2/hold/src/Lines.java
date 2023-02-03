/**
 * This class holds the collection of all lines in the game of Dots and Boxes.
 * <pre>
 * $ java DotsAndBoxes rows columns
 * Usage: java DotsAndBoxes rows columns
 *</pre>
 *
 * @author Jordan Chin, jc9627@rit.edu
 * @author Charlie Leyens, cal3368@rit.edu
 */

public class Lines {

    private int rows;
    private int cols;

    private Dot[][] dots;

    public Lines(int noRows, int noCols, Dot[][] allDots) {
        rows = noRows;
        cols = noCols;
        dots = allDots;
    }

}
