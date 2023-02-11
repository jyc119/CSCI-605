/*
 * HW3: Arithmetic Interpreter
 * Jordan Chin, jc9627@rit.edu
 * Charlie Leyens, cal3368@rit.edu
 */

package tests;

import hw3.Expression;
import hw3.IntExpression;
import hw3.MulExp;
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
        Expression root = new MulExp(new IntExpression(14),
                new IntExpression(10));
        assertEquals(140, root.evaluate());
        assertEquals("(14 * 10)", root.emit());
    }

    @Test
    public void testMulExpressionComplex() {
        Expression root = new MulExp(
                new MulExp(new IntExpression(13),
                        new IntExpression(20)),
                new MulExp(new IntExpression(2),
                        new IntExpression(3)));
        assertEquals(1560, root.evaluate());
        assertEquals("((13 * 20) * (2 * 3))", root.emit());
    }

}
