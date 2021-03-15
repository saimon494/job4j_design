package ru.job4j.ocp;

import java.util.List;

public class Animal {
    private String name;

    private final List<Animal> animals = List.of(
            new Animal("Lion"),
            new Animal("Dog")
    );

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void sound() {
        for (Animal animal : animals) {
            if (animal.getName().equals("Lion")) {
                System.out.println("Roaring");
            }
            if (animal.getName().equals("Dog")) {
                System.out.println("Barking");
            }
        }
    }
}
