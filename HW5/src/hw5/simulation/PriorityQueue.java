/*
 * HW5: Studio 54 Queue Simulation
 * Jordan Chin, jc9627@rit.edu
 * Charlie Leyens, cal3368@rit.edu
 */

package hw5.simulation;

public interface PriorityQueue<T> {

    T dequeue();

    void enqueue(T toInsert);

    boolean isEmpty();
}
