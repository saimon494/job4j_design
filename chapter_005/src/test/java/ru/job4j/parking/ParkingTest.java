package ru.job4j.parking;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ParkingTest {

    private ParkingSpace parkingSpace;
    private CarParking carParking;
    private TruckParking truckParking;

    @Before
    public void init() {
        parkingSpace = new ParkingSpaceImpl();
        carParking = new CarParking(parkingSpace, 10);
        truckParking = new TruckParking(parkingSpace, 4);
    }

    @Test
    public void whenCarParkingAndLeaving() {
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        assertTrue(carParking.accept(car1));
        carParking.parking(car1);
        assertTrue(parkingSpace.contains(car1));
        assertTrue(carParking.accept(car2));
        carParking.parking(car2);
        assertTrue(parkingSpace.contains(car2));
        assertThat(carParking.getVehicles().size(), is(2));
        carParking.remove(car2);
        assertFalse(parkingSpace.contains(car2));
        assertThat(carParking.getVehicles().size(), is(1));
    }

    @Test
    public void whenCarPlaceIsFull() {
        carParking = new CarParking(parkingSpace, 2);
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        assertTrue(carParking.accept(car1));
        carParking.parking(car1);
        assertTrue(carParking.accept(car2));
        carParking.parking(car2);
        Car car3 = new Car("Car3");
        assertFalse(carParking.accept(car3));
    }

    @Test
    public void whenTruckParkingFullAndLeaving() {
        Truck truck1 = new Truck("Truck1", 2);
        Truck truck2 = new Truck("Truck2", 2);
        assertTrue(truckParking.accept(truck1));
        truckParking.parking(truck1);
        assertTrue(parkingSpace.contains(truck1));
        assertTrue(truckParking.accept(truck2));
        truckParking.parking(truck2);
        assertTrue(parkingSpace.contains(truck2));
        assertThat(truckParking.getVehicles().size(), is(2));
        Truck truck3 = new Truck("Truck3", 2);
        assertFalse(truckParking.accept(truck3));
        truckParking.remove(truck1);
        assertFalse(parkingSpace.contains(truck1));
        assertTrue(truckParking.accept(truck3));
        Truck truck4 = new Truck("Truck4", 3);
        assertFalse(truckParking.accept(truck4));
        assertTrue(carParking.accept(truck4));
    }

    @Test
    public void whenTruckParkingCarPlace() {
        Truck truck = new Truck("Truck", 2);
        assertTrue(carParking.accept(truck));
        carParking.parking(truck);
        assertTrue(parkingSpace.contains(truck));
    }

    @Test
    public void whenCarParkingTruckPlace() {
        Car car = new Car("Car");
        assertFalse(truckParking.accept(car));
    }
}