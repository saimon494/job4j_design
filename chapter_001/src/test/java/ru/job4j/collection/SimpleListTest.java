package ru.job4j.collection;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleListTest {

    private SimpleList<Integer> list = new SimpleList<>();

    @Test
    public void whenAddAndGet() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertThat(list.get(2), is(3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetOutOfBounds() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.get(3);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        list.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        list.add(1);
        Iterator<Integer> it = list.iterator();
        list.add(2);
        it.next();
    }
}