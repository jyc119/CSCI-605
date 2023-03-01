/*
 * HW5: Studio 54 Queue Simulation
 * Jordan Chin, jc9627@rit.edu
 * Charlie Leyens, cal3368@rit.edu
 */

package hw5.simulation;

public class LinkedQueue<T extends Comparable<T>> implements PriorityQueue<T> {

    QueueNode<T> front;
    QueueNode<T> back;

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

    public boolean isEmpty(){
        return this.front == null && this.back == null;
    }
}
