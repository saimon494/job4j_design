package ru.job4j.kiss;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MaxMinTest {

    @Test
    public void max() {
        List<Integer> list = List.of(1, 5, 6, 10, 15, 4);
        Comparator<Integer> comparator = Integer::compare;
        Integer rsl = new MaxMin().max(list, comparator);
        assertThat(rsl, is(15));
    }

    @Test
    public void min() {
        List<Integer> list = List.of(1, 5, 6, 10, 15, 4);
        Comparator<Integer> comparator = Integer::compare;
        Integer rsl = new MaxMin().min(list, comparator);
        assertThat(rsl, is(1));
    }
}