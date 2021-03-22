package ru.job4j.parking;

import java.util.List;

public class TruckParking implements Parking {

    private final ParkingSpace parkingSpace;
    private final int capacity;
    private int count;

    public TruckParking(ParkingSpace parkingSpace, int capacity) {
        this.parkingSpace = parkingSpace;
        this.capacity = capacity;
    }

    @Override
    public void parking(Vehicle vehicle) {
        if (!accept(vehicle)) {
            throw new IllegalStateException("Невозможно припарковать грузовик");
        }
        parkingSpace.add(vehicle);
        count += vehicle.getSize();
    }

    @Override
    public boolean accept(Vehicle vehicle) {
        return vehicle.getSize() != 1
                && (capacity - count - vehicle.getSize()) >= 0
                && !parkingSpace.contains(vehicle);
    }

    @Override
    public void remove(Vehicle vehicle) {
        if (parkingSpace.contains(vehicle)) {
            getVehicles().remove(vehicle);
            count -= vehicle.getSize();
        }
    }

    @Override
    public List<Vehicle> getVehicles() {
        return parkingSpace.findAll();
    }
}
