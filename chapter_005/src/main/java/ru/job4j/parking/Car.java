package ru.job4j.parking;

public class Car extends Vehicle {

    public Car(String name) {
        super(name);
    }

    @Override
    public int getSize() {
        return 1;
    }
}
