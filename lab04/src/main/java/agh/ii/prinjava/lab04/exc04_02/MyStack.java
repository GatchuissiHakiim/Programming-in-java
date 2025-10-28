package agh.ii.prinjava.lab04.exc04_02;

import agh.ii.prinjava.lab04.exc04_02.impl.MyStackDLLBImpl;

/**
 * MyStack interface - LIFO (Last In First Out) data structure.
 *
 * @param <E> the type of elements held in this stack
 */
public interface MyStack<E> {
    /**
     * Pushes an element onto the top of the stack.
     *
     * @param x the element to push
     */
    void push(E x);

    /**
     * Removes and returns the element at the top of the stack.
     *
     * @return the element at the top of the stack
     * @throws EmptyStructureException if the stack is empty
     */
    E pop() throws EmptyStructureException;

    /**
     * Returns the element at the top of the stack without removing it.
     *
     * @return the element at the top
     * @throws EmptyStructureException if the stack is empty
     */
    E peek() throws EmptyStructureException;

    /**
     * Returns the number of elements in the stack.
     *
     * @return the number of elements
     */
    int size();

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    default boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Factory method to create a new MyStack instance.
     *
     * @param <T> the type of elements
     * @return a new MyStack instance
     */
    static <T> MyStack<T> create() {
        return new MyStackDLLBImpl<>();
    }
}
