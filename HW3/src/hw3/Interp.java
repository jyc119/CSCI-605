package hw3;

import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Interp {

    public Expression helper(String[] tokenList){

        String[] leftExp;
        String[] rightExp;

        if (tokenList[0].equals("+")){
            if(tokenList.length == 3){
                leftExp = new String[]{tokenList[1]};
                rightExp = new String[]{tokenList[2]};
            }
            else{
                leftExp = Arrays.copyOfRange(tokenList, 1, tokenList.length - 3);
                rightExp = Arrays.copyOfRange(tokenList, tokenList.length - 3, tokenList.length);
            }
            return new AddExpression(helper(leftExp), helper(rightExp));
        }
        else if(tokenList[0].equals("-")) {
            if(tokenList.length == 3){
                leftExp = new String[]{tokenList[1]};
                rightExp = new String[]{tokenList[2]};
            }
            else{
                leftExp = Arrays.copyOfRange(tokenList, 1, tokenList.length - 3);
                rightExp = Arrays.copyOfRange(tokenList, tokenList.length - 3, tokenList.length);
            }
            return new SubExp(helper(leftExp), helper(rightExp));
        }
        else if(tokenList[0].equals("*")) {
            if(tokenList.length == 3){
                leftExp = new String[]{tokenList[1]};
                rightExp = new String[]{tokenList[2]};
            }
            else{
                leftExp = Arrays.copyOfRange(tokenList, 1, tokenList.length - 3);
                rightExp = Arrays.copyOfRange(tokenList, tokenList.length - 3, tokenList.length);
            }
            return new MulExp(helper(leftExp), helper(rightExp));
        }
        else if(tokenList[0].equals("/")) {
            if(tokenList.length == 3){
                leftExp = new String[]{tokenList[1]};
                rightExp = new String[]{tokenList[2]};
            }
            else{
                leftExp = Arrays.copyOfRange(tokenList, 1, tokenList.length - 3);
                rightExp = Arrays.copyOfRange(tokenList, tokenList.length - 3, tokenList.length);
            }
            return new DivExp(helper(leftExp), helper(rightExp));
        }
        else if(tokenList[0].equals("%")) {
            if(tokenList.length == 3){
                leftExp = new String[]{tokenList[1]};
                rightExp = new String[]{tokenList[2]};
            }
            else{
                leftExp = Arrays.copyOfRange(tokenList, 1, tokenList.length - 3);
                rightExp = Arrays.copyOfRange(tokenList, tokenList.length - 3, tokenList.length);
            }
            return new ModExp(helper(leftExp), helper(rightExp));
        }
        Expression number = new IntExpression(Integer.parseInt(String.valueOf(tokenList[0])));
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

            String[] arr = new String[tokenList.size()];

            for (int i = 0; i < tokenList.size(); i++){
                arr[i] = tokenList.get(i);
            }
            Expression expression1 = helper(arr);
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
