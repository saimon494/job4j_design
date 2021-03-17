package ru.job4j.food;

import java.time.LocalDate;

public class Food {

    private final String name;
    private final LocalDate expiryDate;
    private final LocalDate createDate;
    private double price;
    private double discount;

    public Food(String name, LocalDate expiryDate, LocalDate createDate,
                double price, double discount) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
