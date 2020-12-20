package ru.job4j.tree;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.function.Predicate;

public class Tree<E> implements SimpleTree<E> {

    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        Optional<Node<E>> el = findBy(parent);
        if (el.isPresent() && findBy(child).isEmpty()) {
            Node<E> parentNode = el.get();
            Node<E> childNode = new Node<>(child);
            parentNode.getChildren().add(childNode);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Predicate<Node<E>> predicate = e -> e.getValue().equals(value);
        return findByPredicate(predicate);
    }

    public boolean isBinary() {
        Predicate<Node<E>> predicate = e -> e.getChildren().size() > 2;
        return findByPredicate(predicate).isEmpty();
    }

    private Optional<Node<E>> findByPredicate(Predicate<Node<E>> predicate) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (predicate.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.getChildren());
        }
        return rsl;
    }
}
