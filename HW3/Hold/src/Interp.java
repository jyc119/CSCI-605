import java.util.Scanner;

public class Interp implements Expression{

    public void readPrefix(){
        System.out.println("Welcome to your Arithmetic Interpreter v1.0 :)");
        Scanner interpreter = new Scanner(System.in);
        System.out.println(">");
        String expression = interpreter.nextLine();
        while(expression != "quit"){

        }
        System.out.println("Goodbye!");
        return;
    }

    public static void main(String[] args){

    }
}
