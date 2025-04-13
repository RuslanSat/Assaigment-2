package project;

// MyArrayList.java
public class MyArrayList<T> implements MyList<T> {
    private Object[] array;
    private int size;
    private int capacity;

    // Constructor
    public MyArrayList() {
        capacity = 10;
        array = new Object[capacity];
        size = 0;
    }

    // Add item at the end
    public void add(T item) {
        if (size == capacity) {
            // Double the array size
            Object[] newArray = new Object[capacity * 2];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
            capacity = capacity * 2;
        }
        array[size] = item;
        size++;
    }

    // Set item at index
    public void set(int index, T item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        array[index] = item;
    }

    // Add item at specific index
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (size == capacity) {
            Object[] newArray = new Object[capacity * 2];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
            capacity = capacity * 2;
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = item;
        size++;
    }

    // Add at the beginning
    public void addFirst(T item) {
        add(0, item);
    }

    // Add at the end
    public void addLast(T item) {
        add(item);
    }

    // Get item at index
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return (T) array[index];
    }

    // Get first item
    public T getFirst() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }
        return (T) array[0];
    }

    // Get last item
    public T getLast() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }
        return (T) array[size - 1];
    }

    // Remove item at ondex
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size--;
    }

    // Remove first item
    public void removeFirst() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }
        remove(0);
    }

    // Remove last item
    public void removeLast() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }
        remove(size - 1);
    }

    // Bubble sort
    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                Comparable<T> a = (Comparable<T>) array[j];
                T b = (T) array[j + 1];
                if (a.compareTo(b) > 0) {
                    Object temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Find first occurrence of an object
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (object == null && array[i] == null) {
                return i;
            }
            if (object != null && object.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    // Find last occurrence of an object
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (object == null && array[i] == null) {
                return i;
            }
            if (object != null && object.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    // Check if object exists
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    // Convert to array
    public Object[] toArray() {
        Object[] result = new Object[size];
        for (int i = 0; i < size; i++) {
            result[i] = array[i];
        }
        return result;
    }

    // Clear the list
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    // Get size
    public int size() {
        return size;
    }

    // Iterator implementation
    private int currentIndex = 0;

    public boolean hasNext() {
        return currentIndex < size;
    }

    public T next() {
        if (!hasNext()) {
            throw new IllegalStateException("No more elements");
        }
        T item = (T) array[currentIndex];
        currentIndex++;
        return item;
    }
}