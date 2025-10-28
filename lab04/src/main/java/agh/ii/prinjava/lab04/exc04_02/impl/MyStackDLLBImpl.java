package agh.ii.prinjava.lab04.exc04_02.impl;

import agh.ii.prinjava.lab04.exc04_02.EmptyStructureException;
import agh.ii.prinjava.lab04.exc04_02.MyStack;

/**
 * Doubly Linked List Based implementation of MyStack (LIFO).
 *
 * @param <E> the type of elements held in this stack
 */
public class MyStackDLLBImpl<E> implements MyStack<E> {
    private static final class Node<E> {
        E elem;
        Node<E> prev;
        Node<E> next;

        Node(E elem) {
            this.elem = elem;
        }
    }

    private Node<E> head; // top of stack
    private int size;

    @Override
    public void push(E x) {
        Node<E> newNode = new Node<>(x);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public E pop() throws EmptyStructureException {
        if (isEmpty()) {
            throw new EmptyStructureException("Stack is empty");
        }
        E elem = head.elem;
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
        size--;
        return elem;
    }

    @Override
    public E peek() throws EmptyStructureException {
        if (isEmpty()) {
            throw new EmptyStructureException("Stack is empty");
        }
        return head.elem;
    }

    @Override
    public int size() {
        return size;
    }
}
