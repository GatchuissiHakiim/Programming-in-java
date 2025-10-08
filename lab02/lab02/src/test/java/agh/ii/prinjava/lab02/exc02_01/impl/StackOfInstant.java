package agh.ii.prinjava.lab02.exc02_01.impl;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StackOfIntsTest {

    @Test
    void testLinkedListBasedImpl() {
        LinkedListBasedImpl stack = new LinkedListBasedImpl();
        assertTrue(stack.isEmpty());
        stack.push(10);
        stack.push(20);
        assertEquals(20, stack.peek());
        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    void testArrayBasedImpl() {
        ArrayBasedImpl stack = new ArrayBasedImpl();
        assertTrue(stack.isEmpty());
        stack.push(5);
        stack.push(15);
        assertEquals(15, stack.peek());
        assertEquals(15, stack.pop());
        assertEquals(5, stack.pop());
        assertTrue(stack.isEmpty());
    }
}