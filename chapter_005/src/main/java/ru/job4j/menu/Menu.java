package ru.job4j.menu;

import java.util.LinkedList;
import java.util.Queue;

public class Menu implements Printable, AddNode, FindNode {

    private final Node root;

    public Menu(Node root) {
        this.root = root;
    }

    @Override
    public boolean add(String parent, String child, Action action) {
        boolean rsl = false;
        Node node = findBy(parent);
        if (node != null) {
            node.getChildren().add(new Node(child, action));
            rsl = true;
        }
        return rsl;
    }

    @Override
    public Node findBy(String name) {
        Node rsl = null;
        Queue<Node> data = new LinkedList<>();
        data.add(this.root);
        while (!data.isEmpty()) {
            Node node = data.poll();
            if (node.getName().equals(name)) {
                rsl = node;
                break;
            }
            data.addAll(node.getChildren());
        }
        return rsl;
    }

    @Override
    public String print() {
        StringBuilder builder = new StringBuilder();
        for (Node node : root.getChildren()) {
            builder.append(printMenu(node, 0));
        }
        return builder.toString();
    }

    private String printMenu(Node node, int depth) {
        StringBuilder builder = new StringBuilder();
        String tab = "----".repeat(depth);
        builder.append(tab).append(node.getName()).append(System.lineSeparator());

        if (node.getChildren().size() > 0) {
            for (Node child : node.getChildren()) {
                builder.append(printMenu(child, depth + 1));
            }
        }
        return builder.toString();
    }
}
