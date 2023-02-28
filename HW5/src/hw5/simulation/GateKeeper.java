package hw5.simulation;

import java.util.Scanner;


public class GateKeeper {

    public void play(){
        PriorityQueue<Patron> hq = new HeapQueue<Patron>();
        int choice = 0;
        while (choice != 3) {
            System.out.println("""
                    Enter an option
                    1 to Add a patron to the queue
                    2 to Admit a patron
                    3 to Close for the night (quit)""");
            Scanner giveInput = new Scanner(System.in);
            System.out.print("Your choice: ");
            if (giveInput.hasNextInt()) {
                choice = Integer.parseInt(giveInput.nextLine());
            }
            else {
                System.out.println("Error: Invalid input");
                continue;
            }
            if (choice == 1) {
                boolean regularity = true;
                System.out.print("Patron name: ");
                String name = giveInput.nextLine();
                System.out.print("Coolness (1-10): ");
                int coolness = Integer.parseInt(giveInput.nextLine());
                System.out.print("Regular (y/n): ");
                if (giveInput.nextLine().equals("y")) {
                    regularity = true;
                } else {
                   regularity = false;
                }
                hq.enqueue(new Patron(name, coolness, regularity));
            }
            else if (choice == 2) {
                if (hq.isEmpty()) {
                    System.out.println("Queue is empty");
                } else {
                    Patron admittedPatron = hq.dequeue();
                    System.out.println(admittedPatron.getName() +
                            " with coolness factor " +
                            admittedPatron.getCoolness() + " gets in!!!");
                }
            }
            else if (choice == 3) {
            }
            else {
                System.out.println("Error: Invalid input");
            }
        }
    }

    public static void main(String args[]){
        GateKeeper simulation = new GateKeeper();
        simulation.play();
    }
}
