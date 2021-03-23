package ru.job4j.menu;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private String name;
    private final List<Node> children = new ArrayList<>();
    private final Action action;

    public Node(String name, Action action) {
        this.name = name;
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Node> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return name;
    }
}
