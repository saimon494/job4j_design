package ru.job4j.srp;

import java.util.List;

public interface TaskStore<T> {
    void addTask();

    List<T> getTask();
}