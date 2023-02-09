package Interpreter;

public class IntExp implements Expression{

    private int value;

    public IntExp(int value){
        this.value = value;
    }

    public int evaluate(){
        return value;
    }

    public String emit(){
        return String.valueOf(value);
    }

}
