package hw5.simulation;

import java.util.Scanner;


public class GateKeeper {

    public void play(){
        PriorityQueue<Patron> hq = new HeapQueue<Patron>();
        int choice = 0;
        int coolness = 0;
        boolean regularity;
        while (true) {
            System.out.println("""
                    Enter an option
                    1 to Add a patron to the queue
                    2 to Admit a patron
                    3 to Close for the night (quit)""");
            Scanner giveInput = new Scanner(System.in);
            while (true) {
                try {
                    System.out.print("Your choice: ");
                    choice = Integer.parseInt(giveInput.nextLine());
                } catch (Exception e) {
                    System.out.println("Choice must be an integer");
                    continue;
                }
                break;
            }
            if (choice == 1) {
                System.out.print("Patron name: ");
                String name = giveInput.nextLine();
                while (true) {
                    try {
                        System.out.print("Coolness (1-10): ");
                        coolness = Integer.parseInt(giveInput.nextLine());
                    } catch (Exception e) {
                        System.out.println("Coolness must be an integer");
                        continue;
                    }
                    break;
                }
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
            else if (choice == 3) return;
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
