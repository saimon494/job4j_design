package ru.job4j.food;

import java.time.LocalDate;

public class Meat extends Food {
    public Meat(String name, LocalDate expiryDate, LocalDate createDate,
                double price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
