package ru.job4j.food;

import java.time.LocalDate;

@SuppressWarnings("checkstyle:LineLength")
public class Fish extends Food {
    public Fish(String name, LocalDate expiryDate, LocalDate createDate,
                double price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
