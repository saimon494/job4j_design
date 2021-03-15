package ru.job4j.ocp;

public class Customer {

    private String status;

    public String getStatus() {
        return status;
    }

    public static class Discount {
        private Double price;
    }

    public Double giveDiscount() {
        Discount discount = new Discount();
        Double finalPrice = discount.price;
        if (new Customer().getStatus().equals("favorite")) {
            finalPrice *= 0.2;
        }
        if (new Customer().getStatus().equals("vip")) {
            finalPrice *= 0.4;
        }
        return finalPrice;
    }
}
