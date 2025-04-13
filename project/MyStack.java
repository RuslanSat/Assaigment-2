package project;

// MyStack.java
public class MyStack<T> {
    private MyList<T> list;

    // Constructor
    public MyStack() {
        list = new MyArrayList<>();
    }

    // Push item to stack
    public void push(T item) {
        list.addLast(item);
    }

    // Pop item from stack
    public T pop() {
        if (list.size() == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        T item = list.getLast();
        list.removeLast();
        return item;
    }

    // Peek at top item
    public T peek() {
        if (list.size() == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.getLast();
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