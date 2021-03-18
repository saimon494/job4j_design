package ru.job4j.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpaceImpl implements ParkingSpace {

    private List<Vehicle> vehicles;

    public ParkingSpaceImpl() {
        this.vehicles = new ArrayList<>();
    }

    @Override
    public void add(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    @Override
    public boolean contains(Vehicle vehicle) {
        return vehicles.contains(vehicle);
    }

    @Override
    public List<Vehicle> findAll() {
        return List.copyOf(vehicles);
    }
}
