/*
 * HW5: Studio 54 Queue Simulation
 * Jordan Chin, jc9627@rit.edu
 * Charlie Leyens, cal3368@rit.edu
 */

package hw5.simulation;

public class LinkedQueue<T extends Comparable<T>> implements PriorityQueue<T> {

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
        return (T) tmp.key;
    }

    public void enqueue(T toInsert) {
        QueueNode<T> newNode = new QueueNode<>(toInsert);

        if (this.back == null){
            this.front = newNode;
            this.back = newNode;
        }

        QueueNode<T> curr = this.front;
        QueueNode<T> prev = null;

        while (curr.next != null && (newNode.getKey().compareTo((T) curr.next.getKey())) < 0){
            System.out.println(curr.getKey().getName());
            curr = curr.next;
        }

        QueueNode<T> tmp = curr.next;
        curr.next = newNode;
        newNode.next = tmp;
    }

    public boolean isEmpty(){
        return this.front == null && this.back == null;
    }
}
