package tests;

import hw3.AddExpression;
import hw3.Expression;
import hw3.IntExpression;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * A test unit for the MulExpression class.
 *
 * @author Jordan Chin, jc9627@rit.edu
 * @author Charlie Leyens, cal3368@rit.edu
 */
public class TestMulExpression {

    @Test
    public void testMulExpressionInt() {
        Expression root = new AddExpression(new IntExpression(14), new IntExpression(10));
        assertEquals(140, root.evaluate());
        assertEquals("(14 * 10)", root.emit());
    }

    @Test
    public void testMulExpressionComplex() {
        Expression root = new AddExpression(
                new AddExpression(new IntExpression(13), new IntExpression(20)),
                new AddExpression(new IntExpression(2), new IntExpression(3)));
        assertEquals(100, root.evaluate());
        assertEquals("((13 * 20) * (2 * 3))", root.emit());
    }

}
