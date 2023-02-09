package tests;

import hw3.DivExp;
import hw3.Expression;
import hw3.IntExpression;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * A test unit for the DivExpression class.
 *
 * @author Jordan Chin, jc9627@rit.edu
 * @author Charlie Leyens, cal3368@rit.edu
 */
public class TestDivExpression {
    @Test
    public void testSubExpressionInt() {
        Expression root = new DivExp(new IntExpression(8),
                new IntExpression(4));
        assertEquals(2, root.evaluate());
        assertEquals("(8 / 4)", root.emit());
    }

    @Test
    public void testSubExpressionComplex() {
        Expression root = new DivExp(
                new DivExp(new IntExpression(40),
                        new IntExpression(5)),
                new DivExp(new IntExpression(50),
                        new IntExpression(25)));
        assertEquals(4, root.evaluate());
        assertEquals("((40 / 5) / (50 / 25))", root.emit());
    }
}
