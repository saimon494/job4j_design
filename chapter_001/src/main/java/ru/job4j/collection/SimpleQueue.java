package ru.job4j.collection;

public class SimpleQueue<T> {

    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public T poll() {
        if(out.isEmpty()) {
            for (int i = 0; i <= in.getSize(); i++) {
                out.push(in.pop());
                in.setSize(in.getSize() - 1);
                out.setSize(out.getSize() + 1);
            }
        }
        out.setSize(out.getSize() - 1);
        return out.pop();
    }

    public void push(T value) {
        in.push(value);
        in.setSize(in.getSize() + 1);
    }
}
