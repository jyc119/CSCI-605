package hw5.simulation;

public class QueueNode<T> {
    protected T key;

    protected QueueNode next;

    public QueueNode(T key){
        this.key = key;
        this.next = null;
    }
}
