package ru.job4j.parking;

public abstract class Vehicle {

    private final String name;

    public Vehicle(String name) {
        this.name = name;
    }

    abstract int getSize();
}
