package hw5.simulation;

public interface PriorityQueue<T> {

    T dequeue();

    void enqueue(T toInsert);

    boolean isEmpty();
}
