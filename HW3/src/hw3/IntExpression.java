/*
 * HW3: Arithmetic Interpreter
 * Jordan Chin, jc9627@rit.edu
 * Charlie Leyens, cal3368@rit.edu
 */
package hw3;

/**
 * Implements Expression interface for integers
 * <pre>
 * $ java Interp
 * Usage: java Interp
 *</pre>
 *
 * @author Jordan Chin, jc9627@rit.edu
 * @author Charlie Leyens, cal3368@rit.edu
 */
public class IntExpression implements Expression{

    /** the value of the expression */
    private int value;


    public IntExpression(int value){
        this.value = value;
    }

    /**
     * Evaluate the expression
     *
     * @overrides the evaluate method of Expression interface
     * @return the calculated evaluation
     */
    public int evaluate(){
        return value;
    }

    /**
     * Emit the infix form of the expression
     *
     * @overrides the emit method of Expression interface
     * @return infix form of the expression
     */
    public String emit(){
        return String.valueOf(value);
    }
}
