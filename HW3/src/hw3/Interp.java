package hw3;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Interp implements Expression{

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
