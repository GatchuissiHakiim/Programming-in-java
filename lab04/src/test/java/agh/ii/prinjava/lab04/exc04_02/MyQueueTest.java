package agh.ii.prinjava.lab04.exc04_02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyQueueTest {

    @Test
    void testEnqueueAndDequeue() throws EmptyStructureException {
        MyQueue<Integer> queue = MyQueue.create();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
    }

    @Test
    void testPeek() throws EmptyStructureException {
        MyQueue<String> queue = MyQueue.create();
        queue.enqueue("first");
        queue.enqueue("second");

        assertEquals("first", queue.peek());
        assertEquals("first", queue.peek()); // peek should not remove
        assertEquals("first", queue.dequeue()); // verify it's still there
    }

    @Test
    void testNumOfElems() {
        MyQueue<Integer> queue = MyQueue.create();
        assertEquals(0, queue.numOfElems());

        queue.enqueue(1);
        assertEquals(1, queue.numOfElems());

        queue.enqueue(2);
        assertEquals(2, queue.numOfElems());
    }

    @Test
    void testIsEmpty() throws EmptyStructureException {
        MyQueue<Integer> queue = MyQueue.create();
        assertTrue(queue.isEmpty());

        queue.enqueue(1);
        assertFalse(queue.isEmpty());

        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    void testDequeueOnEmptyQueue() {
        MyQueue<Integer> queue = MyQueue.create();
        assertThrows(EmptyStructureException.class, queue::dequeue);
    }

    @Test
    void testPeekOnEmptyQueue() {
        MyQueue<Integer> queue = MyQueue.create();
        assertThrows(EmptyStructureException.class, queue::peek);
    }

    @Test
    void testFIFOOrder() throws EmptyStructureException {
        MyQueue<Integer> queue = MyQueue.create();
        for (int i = 1; i <= 10; i++) {
            queue.enqueue(i);
        }

        for (int i = 1; i <= 10; i++) {
            assertEquals(i, queue.dequeue());
        }
    }
}
