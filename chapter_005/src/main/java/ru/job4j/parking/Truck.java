package ru.job4j.parking;

public class Truck extends Vehicle {

    private final int size;

    public Truck(String name, int size) {
        super(name);
        this.size = size;
    }

    @Override
    int getSize() {
        return size;
    }
}
