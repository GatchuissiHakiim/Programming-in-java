package agh.ii.prinjava.lab04.exc04_02;

/**
 * Demo main class to test MyQueueDLLBImpl and MyStackDLLBImpl.
 * Demonstrates FIFO behavior for queues and LIFO behavior for stacks.
 */
public class DemoMain {
    public static void main(String[] args) {
        System.out.println("=== MyQueue Demo ===");
        demoQueue();
        System.out.println("\n=== MyStack Demo ===");
        demoStack();
    }

    private static void demoQueue() {
        MyQueue<Integer> q = MyQueue.create();
        System.out.println("Queue demo: enqueue 1, 2, 3");
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        try {
            System.out.println("peek -> " + q.peek());            // expect 1
            System.out.println("numOfElems -> " + q.numOfElems()); // expect 3
            System.out.println("dequeue -> " + q.dequeue());      // expect 1 (FIFO)
            System.out.println("dequeue -> " + q.dequeue());      // expect 2
            System.out.println("dequeue -> " + q.dequeue());      // expect 3
            System.out.println("isEmpty -> " + q.isEmpty());      // expect true

            // Demonstrate exception on empty queue
            System.out.println("\nAttempting dequeue on empty queue (should throw exception):");
            q.dequeue();
        } catch (EmptyStructureException ex) {
            System.out.println("✓ Caught expected EmptyStructureException: " + ex.getMessage());
        }
    }

    private static void demoStack() {
        MyStack<String> s = MyStack.create();
        System.out.println("Stack demo: push a, b, c");
        s.push("a");
        s.push("b");
        s.push("c");

        try {
            System.out.println("peek -> " + s.peek());    // expect c
            System.out.println("size -> " + s.size());    // expect 3
            System.out.println("pop -> " + s.pop());      // expect c (LIFO)
            System.out.println("pop -> " + s.pop());      // expect b
            System.out.println("pop -> " + s.pop());      // expect a
            System.out.println("isEmpty -> " + s.isEmpty());// expect true

            // Demonstrate exception on empty stack
            System.out.println("\nAttempting pop on empty stack (should throw exception):");
            s.pop();
        } catch (EmptyStructureException ex) {
            System.out.println("✓ Caught expected EmptyStructureException: " + ex.getMessage());
        }
    }
}
