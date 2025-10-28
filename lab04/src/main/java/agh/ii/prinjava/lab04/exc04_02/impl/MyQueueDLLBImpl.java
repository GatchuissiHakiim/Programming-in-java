package agh.ii.prinjava.lab04.exc04_02.impl;

import agh.ii.prinjava.lab04.exc04_02.EmptyStructureException;
import agh.ii.prinjava.lab04.exc04_02.MyQueue;

/**
 * Doubly Linked List Based implementation of MyQueue (FIFO).
 *
 * @param <E> the type of elements held in this queue
 */
public class MyQueueDLLBImpl<E> implements MyQueue<E> {
    private static final class Node<E> {
        E elem;
        Node<E> prev;
        Node<E> next;

        Node(E elem) {
            this.elem = elem;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    @Override
    public void enqueue(E x) {
        Node<E> newNode = new Node<>(x);
        if (tail == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public E dequeue() throws EmptyStructureException {
        if (isEmpty()) {
            throw new EmptyStructureException("Queue is empty");
        }
        E elem = head.elem;
        head = head.next;
        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }
        size--;
        return elem;
    }

    @Override
    public int numOfElems() {
        return size;
    }

    @Override
    public E peek() throws EmptyStructureException {
        if (isEmpty()) {
            throw new EmptyStructureException("Queue is empty");
        }
        return head.elem;
    }
}
