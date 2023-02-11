package hw3;

import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Interp {

    public String[][] getSubArray(String[] tokenList){
        String[] leftExp;
        String[] rightExp;

        if(tokenList.length == 3){
            leftExp = new String[]{tokenList[1]};
            rightExp = new String[]{tokenList[2]};
        }
        else{
            leftExp = Arrays.copyOfRange(tokenList, 1,
                    tokenList.length - 3);
            rightExp = Arrays.copyOfRange(tokenList,
                    tokenList.length - 3, tokenList.length);
        }
        return new String[][]{leftExp, rightExp};
    }

    public Expression helper(String[] tokenList){

        int firstChar = tokenList[0].charAt(0);
        if((int) firstChar > 47 || (int) firstChar < 37){
            Expression number = new IntExpression(Integer.parseInt
                (String.valueOf(tokenList[0])));
            return number;
        }

        String[][] exp = getSubArray(tokenList);
        String[] leftExp = exp[0];
        String[] rightExp = exp[1];

        if (tokenList[0].equals("+")){
            return new AddExpression(helper(leftExp), helper(rightExp));
        }
        else if(tokenList[0].equals("-")) {
            return new SubExp(helper(leftExp), helper(rightExp));
        }
        else if(tokenList[0].equals("*")) {
            return new MulExp(helper(leftExp), helper(rightExp));
        }
        else if(tokenList[0].equals("/")) {
            return new DivExp(helper(leftExp), helper(rightExp));
        }
        else if(tokenList[0].equals("%")) {
            return new ModExp(helper(leftExp), helper(rightExp));
        }
        return null;
    }

    public void readPrefix(){
        System.out.println("Welcome to your Arithmetic Interpreter v1.0 :)");
        while(true) {
            Scanner interpreter = new Scanner(System.in);
            System.out.println(">");
            String expression = interpreter.nextLine();
            if(Objects.equals(expression, "quit")) {
                System.out.println("Goodbye!");
                return;
            }else {
                String[] tokens = expression.split(" ");
                ArrayList<String> tokenList = new ArrayList<String>
                        (Arrays.asList(tokens));
                String[] arr = new String[tokenList.size()];
                for (int i = 0; i < tokenList.size(); i++){
                    arr[i] = tokenList.get(i);
                }
                Expression expression1 = helper(arr);
                System.out.println("Emit: " + expression1.emit());
                System.out.println("Evaluate: " + expression1.evaluate());
                }
        }
    }

    public static void main(String[] args){
        Interp test = new Interp();
        test.readPrefix();
    }
}
