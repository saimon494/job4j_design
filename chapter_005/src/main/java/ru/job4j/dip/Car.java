package ru.job4j.dip;

public class Car {

    private Engine engine;

    public Car(Engine e) {
        engine = e;
    }

    public void start() {
        engine.start();
    }
}
