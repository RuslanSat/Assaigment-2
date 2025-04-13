package project;

// MyQueue.java
public class MyQueue<T> {
    private MyList<T> list;

    // Constructor
    public MyQueue() {
        list = new MyLinkedList<>();
    }

    // Add to queue
    public void enqueue(T item) {
        list.addLast(item);
    }

    // Remove from queue
    public T dequeue() {
        if (list.size() == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        T item = list.getFirst();
        list.removeFirst();
        return item;
    }

    // Peek at front
    public T peek() {
        if (list.size() == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.getFirst();
    }

    // Check if empty
    public boolean isEmpty() {
        return list.size() == 0;
    }

    // Get size
    public int size() {
        return list.size();
    }
}