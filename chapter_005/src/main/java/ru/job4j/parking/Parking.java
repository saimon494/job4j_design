package ru.job4j.parking;

public interface Parking {

    void addCar(Car car);

    void addTruck(Truck truck);

    void addTruckToCarPlace(Truck truck, int carPlaces);

    void removeCar(Car car);

    void removeTruck(Truck truck);
}
