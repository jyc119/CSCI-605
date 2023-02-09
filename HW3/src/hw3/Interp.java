package hw3;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Interp implements Expression{

    public Expression helper(ArrayList<String> tokenList){
        if (tokenList.get(0) == "+"){

            return new AddExpression(helper(tokenList.subList(1,tokenList.size())), helper(tokenList.subList(2,tokenList.size())));
        }
        else if(tokenList.get(0) == "-") {
            return SubExp(helper(tokenList[1:]),helper(tokenList[2:]));
        }
        else if(tokenList.get(0) == "*") {
            return MulExp(helper(tokenList[1:]),helper(tokenList[2:]));
        }
        else if(tokenList.get(0) == "/") {
            return DivExp(helper(tokenList[1:]),helper(tokenList[2:]));
        }
        else if(tokenList.get(0) == "%") {
            return ModExp(helper(tokenList[1:]),helper(tokenList[2:]));
        }

        Expression number = new IntExpression(Integer.parseInt(String.valueOf(tokenList.get(0))));
        return number;
    }

    public void readPrefix(){
        System.out.println("Welcome to your Arithmetic Interpreter v1.0 :)");
        Scanner interpreter = new Scanner(System.in);
        System.out.println(">");
        String expression = interpreter.nextLine();
        while(expression != "quit"){
            String[] tokens = expression.split("");
            ArrayList<String> tokenList = new ArrayList<String>
                    (Arrays.asList(tokens));

        }
        System.out.println("Goodbye!");
        return;
    }

    public static void main(String[] args){

    }
}
