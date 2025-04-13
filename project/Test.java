package project;
// TestDataStructures.java
public class Test {
    public static void main(String[] args) {
        // Test 1: Testing MyArrayList
        System.out.println("=== Testing MyArrayList ===");
        MyList<Integer> arrayList = new MyArrayList<>();
        // Adding Elements of array
        arrayList.add(5);
        arrayList.add(3);
        arrayList.add(8);
        arrayList.addFirst(1);
        System.out.println("Size of ArrayList: " + arrayList.size());
        System.out.println("First element: " + arrayList.getFirst());
        System.out.println("Last element: " + arrayList.getLast());
        // Sorting method
        arrayList.sort();
        System.out.print("After sorting: ");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + " ");
        }
        System.out.println();
        // Deletign
        arrayList.remove(1);
        System.out.println("After removing element at index 1, size: " + arrayList.size());

        // test 2: testing MyLinkedList
        System.out.println("\n=== Testing MyLinkedList ===");
        MyList<String> linkedList = new MyLinkedList<>();
        // adding elements
        linkedList.add("Dog");
        linkedList.add("Cat");
        linkedList.addLast("Bird");
        linkedList.addFirst("Fish");
        System.out.println("Size of LinkedList: " + linkedList.size());
        System.out.println("First element: " + linkedList.getFirst());
        System.out.println("Last element: " + linkedList.getLast());
        // sorting
        linkedList.sort();
        System.out.print("After sorting: ");
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.print(linkedList.get(i) + " ");
        }
        System.out.println(); // Bird Cat Dog Fish
        // deleting first and last
        linkedList.removeFirst();
        linkedList.removeLast();
        System.out.println("After removing first and last, size: " + linkedList.size());

        // Тест 3: testing MyStack
        System.out.println("\n=== Testing MyStack ===");
        MyStack<Integer> stack = new MyStack<>();
        // checking on empty stack
        System.out.println("Is stack empty? " + stack.isEmpty());
        // adding elements
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Size of stack: " + stack.size());
        System.out.println("Top of stack: " + stack.peek());
        // deleting elements
        System.out.println("Popped: " + stack.pop());
        System.out.println("New top: " + stack.peek());
        System.out.println("Size after pop: " + stack.size());

        // Test 4
        System.out.println("\n=== Testing MyQueue ===");
        MyQueue<String> queue = new MyQueue<>();
        // checking queue empty
        System.out.println("Is queue empty? " + queue.isEmpty());
        // adding elements
        queue.enqueue("First");
        queue.enqueue("Second");
        queue.enqueue("Third");
        System.out.println("Size of queue: " + queue.size());
        System.out.println("Front of queue: " + queue.peek());
        // deleting elements
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("New front: " + queue.peek());
        System.out.println("Size after dequeue: " + queue.size());

        // Test 5
        System.out.println("\n=== Testing MyMinHeap ===");
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        // checking heap empty
        System.out.println("Is heap empty? " + heap.isEmpty());
        // adding elemtns
        heap.add(5);
        heap.add(3);
        heap.add(7);
        heap.add(1);
        System.out.println("Size of heap: " + heap.size());
        System.out.println("Smallest element: " + heap.peekMin());
        // Deleting Elements
        System.out.println("Removed smallest: " + heap.removeMin());
        System.out.println("New smallest: " + heap.peekMin());
        System.out.println("Size after remove: " + heap.size());

        // Test 6
        System.out.println("\n=== Testing Edge Cases ===");
        MyList<Integer> emptyList = new MyArrayList<>();
        try {
            emptyList.getFirst();
        } catch (IllegalStateException e) {
            System.out.println("Caught exception on empty ArrayList: " + e.getMessage());
        }

        MyStack<String> emptyStack = new MyStack<>();
        try {
            emptyStack.pop();
        } catch (IllegalStateException e) {
            System.out.println("Caught exception on empty Stack: " + e.getMessage());
        }
    }
}