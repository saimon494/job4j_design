package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> last;
    private int size = 0;

    private static class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> prev;

        public Node(Node<T> prev, T value, Node<T> next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    public void add(T value) {
        Node<T> node = new Node<T>(last, value, null);
        if (head == null) {
            head = node;
            last = node;
            size++;
            return;
        }
        last.next = node;
        last = node;
        size++;
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        T rsl = head.value;
        head = head.next;
        size--;
        return rsl;
    }

    public T deleteLast() {
        if (last == null) {
            throw new NoSuchElementException();
        }
        Node<T> node = last;
        if (last == head) {
            last = null;
            head = null;
        } else {
            last = last.prev;
            node.prev = null;
            last.next = null;
        }
        size--;
        return node.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void revert() {
        Node<T> prev = null;
        Node<T> current = head;
        Node<T> next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }
}
