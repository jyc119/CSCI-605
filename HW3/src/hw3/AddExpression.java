/*
 * HW3: Arithmetic Interpreter
 * Jordan Chin, jc9627@rit.edu
 * Charlie Leyens, cal3368@rit.edu
 */

package hw3;

/**
 * Implements the Expression interface for addition expressions
 * <pre>
 * $ java Interp
 * Usage: java Interp
 *</pre>
 *
 * @author Jordan Chin, jc9627@rit.edu
 * @author Charlie Leyens, cal3368@rit.edu
 */
public class AddExpression implements Expression{

    /** the expression on the left of operator */
    private Expression Left;

    /** the expression on the right of operator */
    private Expression Right;

    /**
     * Creates the expression on the left and right
     *
     * @param Left the expression on the left of operator
     * @param Right the expression on the right of the operator
     */
    public AddExpression(Expression Left, Expression Right){
        this.Left = Left;
        this.Right = Right;
    }

    /**
     * Evaluate the expression
     *
     * @overrides the evaluate method of Expression interface
     * @return the calculated evaluation
     */
    public int evaluate(){
        return Left.evaluate() + Right.evaluate();
    }

    /**
     * Emit the infix form of the expression
     *
     * @overrides the emit method of Expression interface
     * @return infix form of the expression
     */
    public String emit(){
        return "(" + Left.emit() + " + " + Right.emit() + ")";
    }
}
