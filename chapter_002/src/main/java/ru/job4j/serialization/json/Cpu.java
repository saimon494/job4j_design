package ru.job4j.serialization.json;

public class Cpu {
    private final String name;

    public Cpu(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cpu{" +
                "name='" + name + '\'' +
                '}';
    }
}
