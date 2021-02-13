package ru.job4j.generics;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SimpleArrayTest {
    private SimpleArray<Integer> array = new SimpleArray(3);

    @Test
    public void whenAdd() {
        array.add(1);
        array.add(2);
        array.add(3);
        Iterator<Integer> it = array.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddException() {
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
    }

    @Test
    public void whenSet() {
        array.add(1);
        array.add(1);
        array.add(3);
        array.set(1, 2);
        Iterator<Integer> it = array.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenSetException() {
        array.add(1);
        array.add(1);
        array.add(3);
        array.set(3, 2);
    }

    @Test
    public void whenRemove() {
        array.add(1);
        array.add(2);
        array.add(3);
        array.remove(2);
        Iterator<Integer> it = array.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenRemoveException() {
        array.add(1);
        array.add(2);
        array.add(3);
        array.remove(4);
    }

    @Test
    public void whenGet() {
        array.add(11);
        array.add(12);
        array.add(13);
        assertThat(array.get(1), is(12));
    }
}