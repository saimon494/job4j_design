package ru.job4j.food;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Store {
    private final List<Food> shop;

    public Shop() {
        shop = new ArrayList<>();
    }

    @Override
    public void add(Food food) {
        shop.add(food);
    }

    @Override
    public boolean accept(Food food) {
        int accept = expirationPercent(food);
        if (accept >= 25 && accept < 100) {
            if (accept >= 75) {
                food.setDiscount(0.2);
            }
            return true;
        }
        return false;
    }

    @Override
    public List<Food> getAllFood() {
        return shop;
    }
}
