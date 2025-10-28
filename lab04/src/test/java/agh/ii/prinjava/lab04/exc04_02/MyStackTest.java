package agh.ii.prinjava.lab04.exc04_02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    @Test
    void testPushAndPop() throws EmptyStructureException {
        MyStack<Integer> stack = MyStack.create();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    void testPeek() throws EmptyStructureException {
        MyStack<String> stack = MyStack.create();
        stack.push("first");
        stack.push("second");

        assertEquals("second", stack.peek());
        assertEquals("second", stack.peek()); // peek should not remove
        assertEquals("second", stack.pop()); // verify it's still there
    }

    @Test
    void testSize() {
        MyStack<Integer> stack = MyStack.create();
        assertEquals(0, stack.size());

        stack.push(1);
        assertEquals(1, stack.size());

        stack.push(2);
        assertEquals(2, stack.size());
    }

    @Test
    void testIsEmpty() throws EmptyStructureException {
        MyStack<Integer> stack = MyStack.create();
        assertTrue(stack.isEmpty());

        stack.push(1);
        assertFalse(stack.isEmpty());

        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    void testPopOnEmptyStack() {
        MyStack<Integer> stack = MyStack.create();
        assertThrows(EmptyStructureException.class, stack::pop);
    }

    @Test
    void testPeekOnEmptyStack() {
        MyStack<Integer> stack = MyStack.create();
        assertThrows(EmptyStructureException.class, stack::peek);
    }

    @Test
    void testLIFOOrder() throws EmptyStructureException {
        MyStack<Integer> stack = MyStack.create();
        for (int i = 1; i <= 10; i++) {
            stack.push(i);
        }

        for (int i = 10; i >= 1; i--) {
            assertEquals(i, stack.pop());
        }
    }
}
