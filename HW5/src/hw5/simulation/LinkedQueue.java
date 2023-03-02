/*
 * HW5: Studio 54 Queue Simulation
 * Jordan Chin, jc9627@rit.edu
 * Charlie Leyens, cal3368@rit.edu
 */

package hw5.simulation;

/**
 * A priority queue using a linked list. Links in descending order i.e. higher
 * priority is at the front of the list.
 *
 * @author Jordan Chin, jc9627@rit.edu
 * @author Charlie Leyens, cal3368@rit.edu
 */
public class LinkedQueue<T extends Comparable<T>> implements PriorityQueue<T> {

    /** queue node at the front of the list */
    private QueueNode<T> front;

    /** queue node at the end of the list */
    private QueueNode<T> back;

    /**
     * The constructor for the hw5.simulation.LinkedQueue.
     * Initializes the front and back of the list as null. (Queue is empty)
     */
    public LinkedQueue(){
        this.front = null;
        this.back = null;
    }

    /**
     * Removes and returns the item at the front of the queue
     *
     * @return T the item at the front of the queue otherwise
     * returns a null
     */

    public QueueNode<T> getFront(){
        return front;
    }

    public QueueNode<T> getBack(){
        return back;
    }

    public T dequeue() {
        if (this.front == null){
            return null;
        }
        QueueNode tmp = this.front;
        this.front = this.front.next;

        if (this.front == null){
            this.back = null;
        }
        return (T) tmp.key;
    }

    /**
     * Add an item to the queue at the appropriate location
     *
     * @param toInsert the queueNode containing the
     * patron to insert in the queue
     */
    public void enqueue(T toInsert) {
        QueueNode<T> newNode = new QueueNode<>(toInsert);
        if (this.back == null){
            this.front = newNode;
            this.back = newNode;
            return;
        }
        QueueNode<T> curr = this.front;
        while (curr.next != null && (newNode.getKey().
                compareTo((T) curr.next.getKey())) > 0){
            curr = curr.next;
        }
        if (this.front == null || this.front.getKey().
                compareTo(newNode.getKey())<0){
            newNode.next=this.front;
            this.front = newNode;
        }
        else{
            curr = this.front;
            while (curr.next != null && newNode.getKey().
                    compareTo((T) curr.next.getKey()) < 0){
                curr = curr.next;
            }
            newNode.next = curr.next;
            curr.next = newNode;
        }
    }

    /**
     * Determines if the queue is empty
     *
     * @return true if the queue is empty; otherwise returns false
     */
    public boolean isEmpty(){
        return this.front == null && this.back == null;
    }
}
