/*
 * HW5: Studio 54 Queue Simulation
 * Jordan Chin, jc9627@rit.edu
 * Charlie Leyens, cal3368@rit.edu
 */

package hw5.simulation;

public class LinkedQueue<T> implements PriorityQueue<T> {

    QueueNode front;
    QueueNode back;

    public LinkedQueue(){
        this.front = null;
        this.back = null;
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
        return (T) this.front.key;
    }

    public void enqueue(T toInsert) {
        QueueNode<T> newNode = new QueueNode<>(toInsert);

        if (this.back == null){
            this.front = newNode;
            this.back = newNode;
        }

        this.front.next = newNode;
        this.front = newNode;
    }

    public boolean isEmpty(){
        return this.front == null && this.back == null;
    }
}
