package ru.job4j.lsp;

public class ElectricCar implements Car {
    @Override
    public void turnOnEngine() {
        throw new AssertionError("Нет двигателя!");
    }

    @Override
    public void accelerate() {

    }
}
