package ru.job4j.parking;

public class ParkingSpace {

    private Car[] cars;
    private Truck[] trucks;
    private int carIndex = 0;
    private int truckIndex = 0;

    public ParkingSpace(int carsPlaceSize, int trucksPlaceSize) {
        cars = new Car[carsPlaceSize];
        trucks = new Truck[trucksPlaceSize];
    }

    public int getCarIndex() {
        return carIndex;
    }

    public void setCarIndex(int carIndex) {
        this.carIndex = carIndex;
    }

    public int getTruckIndex() {
        return truckIndex;
    }

    public void setTruckIndex(int truckIndex) {
        this.truckIndex = truckIndex;
    }

    public int getFreeCarSpace() {
        return 0;
    }

    public int getFreeTruckSpace() {
        return 0;
    }
}
