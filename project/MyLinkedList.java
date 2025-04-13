package project;

// MyLinkedList.java
public class MyLinkedList<E> implements MyList<E> {
    // Node class for the linked list
    private class Node {
        E data;
        Node prev;
        Node next;

        Node(E data) {
            this.data = data;
            prev = null;
            next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    // Constructor
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Add at the end
    public void add(E item) {
        addLast(item);
    }

    // Set item at index
    public void set(int index, E item) {
        Node node = getNode(index);
        node.data = item;
    }

    // Add at specific index
    public void add(int index, E item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            addLast(item);
        } else {
            Node current = getNode(index);
            Node newNode = new Node(item);
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
            size++;
        }
    }

    // Add at the beginning
    public void addFirst(E item) {
        Node newNode = new Node(item);
        if (size == 0) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    // Add at the end
    public void addLast(E item) {
        Node newNode = new Node(item);
        if (size == 0) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Get item at index
    public E get(int index) {
        return getNode(index).data;
    }

    // Get first item
    public E getFirst() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }
        return head.data;
    }

    // Get last item
    public E getLast() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }
        return tail.data;
    }

    // Remove at index
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            Node node = getNode(index);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
    }

    // Remove first item
    public void removeFirst() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }
        head = head.next;
        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }
        size--;
    }

    // Remove last item
    public void removeLast() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }
        tail = tail.prev;
        if (tail == null) {
            head = null;
        } else {
            tail.next = null;
        }
        size--;
    }

    // Bubble sort by converting to array and back
    public void sort() {
        Object[] arr = toArray();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                Comparable<E> a = (Comparable<E>) arr[j];
                E b = (E) arr[j + 1];
                if (a.compareTo(b) > 0) {
                    Object temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        clear();
        for (int i = 0; i < arr.length; i++) {
            add((E) arr[i]);
        }
    }

    // Find first occurrence
    public int indexOf(Object object) {
        int index = 0;
        Node current = head;
        while (current != null) {
            if (object == null && current.data == null) {
                return index;
            }
            if (object != null && object.equals(current.data)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    // Find last occurrence
    public int lastIndexOf(Object object) {
        int index = size - 1;
        Node current = tail;
        while (current != null) {
            if (object == null && current.data == null) {
                return index;
            }
            if (object != null && object.equals(current.data)) {
                return index;
            }
            current = current.prev;
            index--;
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
        Node current = head;
        int i = 0;
        while (current != null) {
            result[i] = current.data;
            current = current.next;
            i++;
        }
        return result;
    }

    // Clear the list
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    // Get size
    public int size() {
        return size;
    }

    // Helper method to get node at index
    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    // Iterator
    private Node currentNode = head;

    public boolean hasNext() {
        return currentNode != null;
    }

    public E next() {
        if (!hasNext()) {
            throw new IllegalStateException("No more elements");
        }
        E data = currentNode.data;
        currentNode = currentNode.next;
        return data;
    }
}