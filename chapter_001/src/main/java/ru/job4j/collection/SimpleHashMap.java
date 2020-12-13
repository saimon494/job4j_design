package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleHashMap<K, V> implements Iterable {

    class Node<K, V> {
        private int hash;
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node<?, ?> node = (Node<?, ?>) o;
            return Objects.equals(key, node.key)
                    && Objects.equals(value, node.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }

    private final static int DEFAULT_CAPACITY = 16;
    private Node<K, V>[] table = new Node[DEFAULT_CAPACITY];
    private int size;
    private double loadFactor = 0.75;
    private double threshold = table.length * loadFactor;
    private int modCount = 0;

    public boolean insert(K key, V value) {
        boolean result = true;
        if (key == null) {
            putForNullKey(value);
        } else if (size == 0) {
            int hash = SimpleHashMap.hash(key);
            int index = SimpleHashMap.indexFor(hash, table.length);
            addNode(hash, key, value, index);
        } else {
            int hash = SimpleHashMap.hash(key);
            int index = SimpleHashMap.indexFor(hash, table.length);
            Node<K, V> elem = table[index];
            if (elem != null && elem.hash == hash
                    && (elem.key == key || key.equals(elem.key))) {
                elem.value = value;
                result = false;
            } else {
                addNode(hash, key, value, index);
            }
        }
        modCount++;
        return result;
    }

    private void putForNullKey(V value) {
        for (Node<K, V> elem = table[0]; elem != null; elem = elem.next) {
            if (elem.key == null) {
                elem.value = value;
            }
        }
        addNode(0, null, value, 0);
    }

    private static int hash(Object key) {
        int h = key.hashCode();
        return (key == null) ? 0 : (h ^ (h >>> 16));
    }

    private static int indexFor(int h, int length) {
        return h & (length - 1);
    }

    private void addNode(int hash, K key, V value, int index) {
        Node<K, V> elem = table[index];
        table[index] = new Node<>(hash, key, value, elem);
        if (++size > threshold) {
            resize(2 * table.length);
        }
    }

    private void resize(int newCapacity) {
        Node[] newTable = new Node[newCapacity];
        transfer(newTable);
        table = newTable;
    }

    private void transfer(Node[] newTable) {
        Node[] src = table;
        int newCapacity = newTable.length;
        for (int j = 0; j < src.length; j++) {
            Node<K, V> e = src[j];
            if (null != e) {
                src[j] = null;
                int i = indexFor(e.hash, newCapacity);
                newTable[i] = e;
            }
        }
    }

    public V get(K key) {
        int index;
        if (key == null) {
            index = indexFor(0, table.length);
        } else {
            index = indexFor(key.hashCode(), table.length);
        }
        if (table[index] != null) {

            if (table[index].getKey() == null) {
                return table[index].getValue();
            }
            if (table[index].getKey().equals(key)) {
                return  table[index].getValue();
            }
        }
        return null;
    }

    public boolean delete(K key) {
        boolean result = false;
        int index;
        if (key == null) {
            index = indexFor(0, table.length);
        } else {
            index = indexFor(key.hashCode(), table.length);
        }
        if (table[index] != null) {
            if (table[index].getKey().equals(key)) {
                table[index] = null;
                size--;
                result = true;
            }
        }
        modCount++;
        return result;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<V> iterator() {
        int expectedModCount = modCount;
        return new Iterator<>() {

            private int point = 0;

            @Override
            public boolean hasNext() {
                while (table[point] == null && point < table.length - 1) {
                    point++;
                }
                return table[point] != null;
            }

            @Override
            public V next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                V elem = table[point].getValue();
                point++;
                return elem;
            }
        };
    }
}
