/*
 * HW5: Studio 54 Queue Simulation
 * Jordan Chin, jc9627@rit.edu
 * Charlie Leyens, cal3368@rit.edu
 */

package hw5.simulation;

/**
 * Creates a node to be used in the linkedList
 * queue implementation of priority queue
 *
 * @author Jordan Chin, jc9627@rit.edu
 * @author Charlie Leyens, cal3368@rit.edu
 */
public class QueueNode<T> {

    /** the node key containing the patron details */
    protected T key;

    /** the next queueNode in the list to point to */
    protected QueueNode next;

    /**
     * The constructor for the hw5.simulation.QueueNode.
     * Initializes the key and the pointer to the next node
     */
    public QueueNode(T key){
        this.key = key;
        this.next = null;
    }

    /**
     * Get the key in the node. Contains the patron details
     *
     * @return the key
     */
    public T getKey() {
        return key;
    }
}
