package hw3;

import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Interp {

    public Expression helper(ArrayList<String> tokenList){
        if (tokenList.get(0).equals("+")){

            return new AddExpression(helper((ArrayList<String>) tokenList.subList(1,tokenList.size())), helper((ArrayList<String>) tokenList.subList(2,tokenList.size())));
        }
        else if(tokenList.get(0) == "-") {
            return new SubExp(helper((ArrayList<String>) tokenList.subList(1,tokenList.size())), helper((ArrayList<String>) tokenList.subList(2,tokenList.size())));
        }
        else if(tokenList.get(0) == "*") {
            return new MulExp(helper((ArrayList<String>) tokenList.subList(1,tokenList.size())), helper((ArrayList<String>) tokenList.subList(2,tokenList.size())));
        }
        else if(tokenList.get(0) == "/") {
            return new DivExp(helper((ArrayList<String>) tokenList.subList(1,tokenList.size())), helper((ArrayList<String>) tokenList.subList(2,tokenList.size())));
        }
        else if(tokenList.get(0) == "%") {
            return new ModExp(helper((ArrayList<String>) tokenList.subList(1,tokenList.size())), helper((ArrayList<String>) tokenList.subList(2,tokenList.size())));
        }
        System.out.println(tokenList.get(0));
        System.out.println("HERE");
        Expression number = new IntExpression(Integer.parseInt(String.valueOf(tokenList.get(0))));
        return number;
    }

    public void readPrefix(){
        System.out.println("Welcome to your Arithmetic Interpreter v1.0 :)");
        Scanner interpreter = new Scanner(System.in);
        System.out.println(">");
        String expression = interpreter.nextLine();
        while(!Objects.equals(expression, "quit")){
            expression = expression.replaceAll("\\s", "");
            String[] tokens = expression.split("");
            ArrayList<String> tokenList = new ArrayList<String>
                    (Arrays.asList(tokens));
            System.out.println(tokenList);
            Expression expression1 = helper(tokenList);
            System.out.println(expression1.emit());
            System.out.println(expression1.evaluate());
        }
        System.out.println("Goodbye!");
        return;
    }

    public static void main(String[] args){
        Interp test = new Interp();
        test.readPrefix();
    }
}
