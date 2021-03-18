package ru.job4j.food;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ControlQualityTest {
    private List<Store> store;
    private ControlQuality controlQuality;

    @Before
    public void init() {
        store = new ArrayList<>();
        store.add(new Warehouse());
        store.add(new Shop());
        store.add(new Trash());
        controlQuality = new ControlQuality(store);
    }

    @Ignore
    @Test
    public void whenBreadInWarehouse() {
        LocalDate expiryDate = LocalDate.parse("2021-03-21");
        LocalDate createDate = LocalDate.parse("2021-03-18");
        Bread bread = new Bread("Bread", expiryDate, createDate, 50, 0);
        controlQuality.addToStore(bread);
        assertThat(store.get(0).getAllFood().get(0), is(bread));
    }

    @Ignore
    @Test
    public void whenMeatInShop() {
        LocalDate expiryDate = LocalDate.parse("2021-04-20");
        LocalDate createDate = LocalDate.parse("2021-02-28");
        Meat meat = new Meat("Meat", expiryDate, createDate, 300, 0);
        controlQuality.addToStore(meat);
        assertThat(store.get(1).getAllFood().get(0), is(meat));
    }

    @Ignore
    @Test
    public void whenFishInTrash() {
        LocalDate expiryDate = LocalDate.parse("2021-03-10");
        LocalDate createDate = LocalDate.parse("2020-11-28");
        Fish fish = new Fish("Fish", expiryDate, createDate, 500, 0);
        controlQuality.addToStore(fish);
        assertThat(store.get(2).getAllFood().get(0), is(fish));
    }
}