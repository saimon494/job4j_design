package ru.job4j.parking;

import java.util.List;

public class CarParking implements Parking {

    private ParkingSpace parkingSpace;
    private int capacity;
    private int count;

    public CarParking(ParkingSpace parkingSpace, int capacity) {
        this.parkingSpace = parkingSpace;
        this.capacity = capacity;
    }

    @Override
    public void parking(Vehicle car) {

    }

    @Override
    public boolean accept(Vehicle car) {
        return true;
    }

    @Override
    public void remove(Vehicle car) {

    }

    @Override
    public List<Vehicle> getVehicles() {
        return parkingSpace.findAll();
    }
}
