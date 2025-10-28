package agh.ii.prinjava.lab04.exc04_02.impl;

/**
 * Doubly Linked List implementation helper class.
 *
 * @param <E> the type of elements held in this list
 */
public class DLinkList<E> {
    private static class Node<E> {
        E elem;
        Node<E> next;
        Node<E> prev;

        Node(E elem) {
            this.elem = elem;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    /**
     * Adds an element to the beginning of the list.
     *
     * @param elem the element to add
     */
    public void addFirst(E elem) {
        Node<E> newNode = new Node<>(elem);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param elem the element to add
     */
    public void addLast(E elem) {
        Node<E> newNode = new Node<>(elem);
        if (tail == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /**
     * Removes and returns the first element of the list.
     *
     * @return the first element
     * @throws IllegalStateException if the list is empty
     */
    public E removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
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

    /**
     * Removes and returns the last element of the list.
     *
     * @return the last element
     * @throws IllegalStateException if the list is empty
     */
    public E removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        E elem = tail.elem;
        tail = tail.prev;
        if (tail == null) {
            head = null;
        } else {
            tail.next = null;
        }
        size--;
        return elem;
    }

    /**
     * Returns the first element without removing it.
     *
     * @return the first element
     * @throws IllegalStateException if the list is empty
     */
    public E peekFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return head.elem;
    }

    /**
     * Returns the last element without removing it.
     *
     * @return the last element
     * @throws IllegalStateException if the list is empty
     */
    public E peekLast() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return tail.elem;
    }

    /**
     * Checks if the list is empty.
     *
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return the size
     */
    public int listSize() {
        return size;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = head;
        while (current != null) {
            sb.append(current.elem);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
