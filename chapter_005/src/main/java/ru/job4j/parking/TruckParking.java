package ru.job4j.parking;

import java.util.List;

public class TruckParking implements Parking {

    private ParkingSpace parkingSpace;
    private int capacity;
    private int count;

    public TruckParking(ParkingSpace parkingSpace, int capacity) {
        this.parkingSpace = parkingSpace;
        this.capacity = capacity;
    }

    @Override
    public void parking(Vehicle truck) {

    }

    @Override
    public boolean accept(Vehicle truck) {
        return true;
    }

    @Override
    public void remove(Vehicle truck) {

    }

    @Override
    public List<Vehicle> getVehicles() {
        return parkingSpace.findAll();
    }
}
