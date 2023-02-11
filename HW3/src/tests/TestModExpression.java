/*
 * HW3: Arithmetic Interpreter
 * Jordan Chin, jc9627@rit.edu
 * Charlie Leyens, cal3368@rit.edu
 */

package tests;

import hw3.Expression;
import hw3.IntExpression;
import hw3.ModExp;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * A test unit for the ModExpression class.
 *
 * @author Jordan Chin, jc9627@rit.edu
 * @author Charlie Leyens, cal3368@rit.edu
 */
public class TestModExpression {
    @Test
    public void testModExpressionInt() {
        Expression root = new ModExp(new IntExpression(26), new IntExpression(10));
        assertEquals(6, root.evaluate());
        assertEquals("(26 % 10)", root.emit());
    }

    @Test
    public void testModExpressionComplex() {
        Expression root = new ModExp(
                new ModExp(new IntExpression(13), new IntExpression(10)),
                new ModExp(new IntExpression(7), new IntExpression(20)));
        assertEquals(3, root.evaluate());
        assertEquals("((13 % 10) % (7 % 20))", root.emit());
    }
}
