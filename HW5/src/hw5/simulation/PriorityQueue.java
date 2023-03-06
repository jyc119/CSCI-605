/*
 * HW5: Studio 54 Queue Simulation
 * Jordan Chin, jc9627@rit.edu
 * Charlie Leyens, cal3368@rit.edu
 */

package hw5.simulation;

public interface PriorityQueue<T> {

    /**
     * Removes and returns the item at the front of the queue
     *
     * @return T the item at the front of the queue otherwise
     * returns a null
     */

    T dequeue();

    /**
     * Add an item to the queue at the appropriate location
     *
     * @param toInsert the item to insert in the queue
     */
    void enqueue(T toInsert);

    /**
     * Is there anything in the queue?
     *
     * @return true if the queue is empty; otherwise returns false
     */

    boolean isEmpty();
}
