package ru.job4j.food;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Store {

    private final List<Food> warehouse;

    public Warehouse() {
        warehouse = new ArrayList<>();
    }

    @Override
    public void add(Food food) {
        warehouse.add(food);
    }

    @Override
    public boolean accept(Food food) {
        return expirationPercent(food) < 25;
    }

    @Override
    public List<Food> getAllFood() {
        return warehouse;
    }
}
