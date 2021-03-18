package ru.job4j.parking;

import java.util.List;

public interface ParkingSpace {

    void add(Vehicle vehicle);

    boolean contains(Vehicle vehicle);

    List<Vehicle> findAll();
}
