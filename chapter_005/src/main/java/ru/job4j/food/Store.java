package ru.job4j.food;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public interface Store {

    void add(Food food);

    boolean accept(Food food);

    List<Food> getAllFood();

    default int expirationPercent(Food food) {
        long wholeExp = ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        long currentExp = ChronoUnit.DAYS.between(food.getCreateDate(), LocalDate.now());
        return (int) (currentExp * 100L / wholeExp);
    }
}
