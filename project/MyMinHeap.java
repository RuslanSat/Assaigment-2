package project;

// MyMinHeap.java
public class MyMinHeap<T extends Comparable<T>> {
    private MyList<T> heap;

    // Constructor
    public MyMinHeap() {
        heap = new MyArrayList<>();
    }

    // Add item to heap
    public void add(T item) {
        heap.add(item);
        siftUp(heap.size() - 1);
    }

    // Remove smallest item
    public T removeMin() {
        if (heap.size() == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        T min = heap.get(0);
        T last = heap.getLast();
        heap.removeLast();
        if (heap.size() > 0) {
            heap.set(0, last);
            siftDown(0);
        }
        return min;
    }

    // Peek at smallest item
    public T peekMin() {
        if (heap.size() == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap.get(0);
    }

    // Check if empty
    public boolean isEmpty() {
        return heap.size() == 0;
    }

    // Get size
    public int size() {
        return heap.size();
    }

    // Sift up to maintain heap property
    private void siftUp(int index) {
        int parent = (index - 1) / 2;
        while (index > 0 && heap.get(index).compareTo(heap.get(parent)) < 0) {
            T temp = heap.get(index);
            heap.set(index, heap.get(parent));
            heap.set(parent, temp);
            index = parent;
            parent = (index - 1) / 2;
        }
    }

    // Sift down to maintain heap property
    private void siftDown(int index) {
        int minIndex = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < heap.size() && heap.get(left).compareTo(heap.get(minIndex)) < 0) {
            minIndex = left;
        }
        if (right < heap.size() && heap.get(right).compareTo(heap.get(minIndex)) < 0) {
            minIndex = right;
        }
        if (minIndex != index) {
            T temp = heap.get(index);
            heap.set(index, heap.get(minIndex));
            heap.set(minIndex, temp);
            siftDown(minIndex);
        }
    }
}