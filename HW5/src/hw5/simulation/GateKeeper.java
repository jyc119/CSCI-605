/*
 * HW5: Studio 54 Queue Simulation
 * Jordan Chin, jc9627@rit.edu
 * Charlie Leyens, cal3368@rit.edu
 */

package hw5.simulation;

import java.util.Scanner;

/**
 * The main program for the queue simulation
 * <pre>
 * $ java GateKeeper
 * Usage: java GateKeeper
 *</pre>
 *
 * @author Jordan Chin, jc9627@rit.edu
 * @author Charlie Leyens, cal3368@rit.edu
 */
public class GateKeeper {

    /**
     * The game play loop. Implements simulation using either HeapQueue or
     * LinkedQueue depending on which class is initialized.
     */
    public void play(){
         PriorityQueue<Patron> hq = new LinkedQueue<>();
        // PriorityQueue<Patron> hq = new HeapQueue<>();
        int choice = 0;
        int coolness = 0;
        String regular = null;
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
                        if (1 <= coolness && coolness <= 10) {
                            break;
                        }
                        else {
                            System.out.println("Coolness must be (1-10)");
                        }
                    } catch (Exception e) {
                        System.out.println("Coolness must be an integer");
                    }
                }
                while (true) {
                    System.out.print("Regular (y/n): ");
                    regular = giveInput.nextLine();
                    if (regular.equals("y")) {
                        regularity = true;
                        break;
                    }
                    else if (regular.equals("n")) {
                        regularity = false;
                        break;
                    }
                    else {
                        System.out.println("Input must be (y/n)");
                    }
                }
                hq.enqueue(new Patron(name, coolness, regularity));
            }
            else if (choice == 2) {
                if (hq.isEmpty()) {
                    System.out.println("Queue is empty.");
                } else {
                    Patron admittedPatron = hq.dequeue();
                    System.out.println(admittedPatron.getRegularity() +
                            admittedPatron.getName() + " with coolness factor "
                            + admittedPatron.getCoolness() + " gets in!!!");
                }
            }
            else if (choice == 3) return;
            else {
                System.out.println("Error: Invalid input");
            }
        }
    }

    /**
     * Main function. Initiates the simulation and runs the simulation.
     *
     * @param args command line arguments. None passed.
     */
    public static void main(String args[]){
        GateKeeper simulation = new GateKeeper();
        simulation.play();
    }
}
