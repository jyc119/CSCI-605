package hw3;

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
