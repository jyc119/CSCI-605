/*
 * HW3: Arithmetic Interpreter
 * Jordan Chin, jc9627@rit.edu
 * Charlie Leyens, cal3368@rit.edu
 */

package hw3;

/**
 * Interface for various expressions
 * <pre>
 * $ java Interp
 * Usage: java Interp
 *</pre>
 *
 * @author Jordan Chin, jc9627@rit.edu
 * @author Charlie Leyens, cal3368@rit.edu
 */
public interface Expression {

    /**
     * Evaluate the expression
     *
     * @return the calculated evaluation
     */
    int evaluate();

    /**
     * Emit the infix form of the expression
     *
     * @return infix form of the expression
     */
    String emit();
}
