package ru.job4j.food;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Store {
    private final List<Food> trash;

    public Trash() {
        trash = new ArrayList<>();
    }

    @Override
    public void add(Food food) {
        trash.add(food);
    }

    @Override
    public boolean accept(Food food) {
        return expirationPercent(food) >= 100;
    }

    @Override
    public List<Food> getAllFood() {
        return trash;
    }

    @Override
    public List<Food> clear() {
        List<Food> newStore = new ArrayList<>(trash);
        trash.clear();
        return newStore;
    }
}