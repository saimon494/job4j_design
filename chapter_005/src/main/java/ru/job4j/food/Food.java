package ru.job4j.food;

import java.time.LocalDate;

public class Food {

    private final String name;
    private LocalDate expiryDate;
    private LocalDate createDate;
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

    public void setExpiryDate(LocalDate date) {
        this.expiryDate = date;
    }

    public void setCreateDate(LocalDate date) {
        this.createDate = date;
    }
}
