package hw3;

public class IntExpression implements Expression{

    private int value;

    public IntExpression(int value){
        this.value = value;
    }

    public int evaluate(){
        return value;
    }

    public String emit(){
        return String.valueOf(value);
    }
}
