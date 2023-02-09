package hw3;

public class SubExp implements Expression{

    private Expression Left;
    private Expression Right;

    public SubExp (Expression Left, Expression Right){
        this.Left = Left;
        this.Right = Right;
    }

    public int evaluate(){
        return Left.evaluate() - Right.evaluate();
    }

    public String emit(){
        return "(" + Left.emit() + " - " + Right.emit() + ")";
    }
}
