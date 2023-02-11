/*
 * HW3: Arithmetic Interpreter
 * Jordan Chin, jc9627@rit.edu
 * Charlie Leyens, cal3368@rit.edu
 */

package hw3;

import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Create the arithmetic interpreter
 * <pre>
 * $ java Interp
 * Usage: java Interp
 *</pre>
 *
 * @author Jordan Chin, jc9627@rit.edu
 * @author Charlie Leyens, cal3368@rit.edu
 */
public class Interp {

    /**
     * Create a subarray of tokens from the math expression.
     *
     * @param
     * @return
     */
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

    /**
     *
     *
     * @param
     * @return
     */
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

    /**
     * Reads in the expression in prefix form and prints the expression in
     * infix form and the evaluation of the expression.
     */
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

    /**
     * The main function for evaluating simple arithmetic
     * expressions.
     *
     * @param args command line arguments
     */
    public static void main(String[] args){
        Interp test = new Interp();
        test.readPrefix();
    }
}
