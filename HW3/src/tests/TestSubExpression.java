/*
 * HW3: Arithmetic Interpreter
 * Jordan Chin, jc9627@rit.edu
 * Charlie Leyens, cal3368@rit.edu
 */

package tests;

import hw3.Expression;
import hw3.IntExpression;
import hw3.SubExp;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * A test unit for the SubExpression class.
 *
 * @author Jordan Chin, jc9627@rit.edu
 * @author Charlie Leyens, cal3368@rit.edu
 */
public class TestSubExpression {

    @Test
    public void testSubExpressionInt() {
        Expression root = new SubExp(new IntExpression(30), new IntExpression(10));
        assertEquals(20, root.evaluate());
        assertEquals("(30 - 10)", root.emit());
    }

    @Test
    public void testSubExpressionComplex() {
        Expression root = new SubExp(
                new SubExp(new IntExpression(50), new IntExpression(20)),
                new SubExp(new IntExpression(60), new IntExpression(40)));
        assertEquals(10, root.evaluate());
        assertEquals("((50 - 20) - (60 - 40))", root.emit());
    }

}
