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
        return (T) this.front;
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
