package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        T rsl = value.get(0);
        for (int i = 1; i < value.size(); i++) {
            if (comparator.compare(value.get(i), rsl) > 0) {
                rsl = value.get(i);
            }
        }
        return rsl;
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return max(value, comparator.reversed());
    }
}