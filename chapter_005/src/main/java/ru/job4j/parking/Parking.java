package ru.job4j.parking;

import java.util.List;

public interface Parking {

    void parking(Vehicle vehicle);

    boolean accept(Vehicle vehicle);

    void remove(Vehicle vehicle);

    List<Vehicle> getVehicles();
}
