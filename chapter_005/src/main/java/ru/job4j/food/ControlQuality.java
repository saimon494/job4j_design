package ru.job4j.food;

import java.util.ArrayList;
import java.util.List;

public class ControlQuality {

    private final List<Store> storage;

    public ControlQuality(List<Store> storage) {
        this.storage = storage;
    }

    public void addToStore(Food food) {
        for (Store store : storage) {
            if (store.accept(food)) {
                store.add(food);
                break;
            }
        }
    }

    public void resort() {
        List<Food> newStore = new ArrayList<>();
        storage.forEach(store -> newStore.addAll(store.clear()));
        newStore.forEach(this::addToStore);
    }
}