package ru.job4j.collection;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;
import java.util.Iterator;

public class SimpleSetTest {

    @Test
    public void whenAdd() {
        SimpleSet<String> simpleSet = new SimpleSet<>();
        simpleSet.add("first");
        simpleSet.add("second");
        Iterator<String> iterator = simpleSet.iterator();
        assertThat(iterator.next(), is("first"));
        assertThat(iterator.next(), is("second"));
        assertThat(iterator.hasNext(), is(false));
    }
}