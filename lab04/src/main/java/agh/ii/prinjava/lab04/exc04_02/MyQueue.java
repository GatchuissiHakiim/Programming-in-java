package agh.ii.prinjava.lab04.exc04_02;

import agh.ii.prinjava.lab04.exc04_02.impl.MyQueueDLLBImpl;

/**
 * MyQueue interface - FIFO (First In First Out) data structure.
 *
 * @param <E> the type of elements held in this queue
 */
public interface MyQueue<E> {
    /**
     * Adds an element to the end of the queue.
     *
     * @param x the element to enqueue
     */
    void enqueue(E x);

    /**
     * Removes and returns the element at the front of the queue.
     *
     * @return the element at the front of the queue
     * @throws EmptyStructureException if the queue is empty
     */
    E dequeue() throws EmptyStructureException;

    /**
     * Returns the number of elements in the queue.
     *
     * @return the number of elements
     */
    int numOfElems();

    /**
     * Returns the element at the front of the queue without removing it.
     *
     * @return the element at the front
     * @throws EmptyStructureException if the queue is empty
     */
    E peek() throws EmptyStructureException;

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
    default boolean isEmpty() {
        return numOfElems() == 0;
    }

    /**
     * Factory method to create a new MyQueue instance.
     *
     * @param <T> the type of elements
     * @return a new MyQueue instance
     */
    static <T> MyQueue<T> create() {
        return new MyQueueDLLBImpl<>();
    }
}
