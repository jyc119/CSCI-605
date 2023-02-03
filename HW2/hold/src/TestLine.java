import game.Dot;
import game.Line;
import game.Player;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * A test unit for the game.Line class.
 *
 * @author RIT CS
 */
public class TestLine {
    @Test(expected=AssertionError.class)
    public void testBadHoriLines() {
        new Line(new Dot(0,1), new Dot(0, 0));
        new Line(new Dot(0,0), new Dot(2, 0));
    }

    @Test(expected=AssertionError.class)
    public void testBadVertLines() {
        new Line(new Dot(1, 0), new Dot(0, 0));
        new Line(new Dot(0, 0), new Dot(0, 2));
    }

    @Test
    public void testGoodHoriLine() {
        Line horiLine = new Line(new Dot(0,0), new Dot(0,1));
        Assert.assertEquals(0, horiLine.getFirst().getRow());
        Assert.assertEquals(0, horiLine.getFirst().getColumn());
        Assert.assertEquals(0, horiLine.getSecond().getRow());
        Assert.assertEquals(1, horiLine.getSecond().getColumn());
        Assert.assertEquals(false, horiLine.hasOwner());
        assertEquals(Player.NONE, horiLine.getOwner());
        Assert.assertEquals(" ", horiLine.toString());
        horiLine.claim(Player.RED);
        Assert.assertEquals(true, horiLine.hasOwner());
        assertEquals(Player.RED, horiLine.getOwner());
        Assert.assertEquals("-", horiLine.toString());
    }

    @Test
    public void testGoodVertLine() {
        Line vertLine = new Line(new Dot(0,0), new Dot(1,0));
        Assert.assertEquals(0, vertLine.getFirst().getRow());
        Assert.assertEquals(0, vertLine.getFirst().getColumn());
        Assert.assertEquals(1, vertLine.getSecond().getRow());
        Assert.assertEquals(0, vertLine.getSecond().getColumn());
        Assert.assertEquals(false, vertLine.hasOwner());
        assertEquals(Player.NONE, vertLine.getOwner());
        Assert.assertEquals(" ", vertLine.toString());
        vertLine.claim(Player.BLUE);
        Assert.assertEquals(true, vertLine.hasOwner());
        assertEquals(Player.BLUE, vertLine.getOwner());
        Assert.assertEquals("|", vertLine.toString());
    }

    @Test
    public void testEquals() {
        Line line1 = new Line(new Dot(0,0), new Dot(0, 1));
        Line line2 = new Line(new Dot(0,0), new Dot(0, 1));
        Line line3 = new Line(new Dot(0,0), new Dot(1, 0));
        Assert.assertEquals(line1, line2);
        Assert.assertNotEquals(line1, line3);
    }
}
