/*
 * HW5: Studio 54 Queue Simulation
 * Jordan Chin, jc9627@rit.edu
 * Charlie Leyens, cal3368@rit.edu
 */

package hw5.simulation;

public class QueueNode<T> {
    protected T key;

    protected QueueNode next;

    public QueueNode(T key){
        this.key = key;
        this.next = null;
    }

    public T getKey() {
        return key;
    }
}
