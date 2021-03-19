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
    private LocalDate expiryDate;
    private LocalDate createDate;
    private Bread bread;
    private Meat meat;
    private Fish fish;

    @Before
    public void init() {
        store = new ArrayList<>();
        store.add(new Warehouse());
        store.add(new Shop());
        store.add(new Trash());
        controlQuality = new ControlQuality(store);
        bread = new Bread("Bread", expiryDate, createDate, 50, 0);
        meat = new Meat("Meat", expiryDate, createDate, 300, 0);
        fish = new Fish("Fish", expiryDate, createDate, 500, 0);
    }

    //@Ignore
    @Test
    public void whenBreadInWarehouse() {
        bread.setExpiryDate(LocalDate.parse("2021-03-21"));
        bread.setCreateDate(LocalDate.parse("2021-03-19"));
        controlQuality.addToStore(bread);
        assertThat(store.get(0).getAllFood().get(0), is(bread));
    }

    //@Ignore
    @Test
    public void whenMeatInShop() {
        meat.setExpiryDate(LocalDate.parse("2021-04-20"));
        meat.setCreateDate(LocalDate.parse("2021-02-28"));
        controlQuality.addToStore(meat);
        assertThat(store.get(1).getAllFood().get(0), is(meat));
    }

    //@Ignore
    @Test
    public void whenFishInTrash() {
        fish.setExpiryDate(LocalDate.parse("2021-03-10"));
        fish.setCreateDate(LocalDate.parse("2020-11-28"));
        controlQuality.addToStore(fish);
        assertThat(store.get(2).getAllFood().get(0), is(fish));
    }

    @Test
    public void whenResort() {
        bread.setExpiryDate(LocalDate.parse("2021-03-27"));
        bread.setCreateDate(LocalDate.parse("2021-03-17"));
        meat.setExpiryDate(LocalDate.parse("2021-06-21"));
        meat.setCreateDate(LocalDate.parse("2021-02-20"));
        fish.setExpiryDate(LocalDate.parse("2021-06-21"));
        fish.setCreateDate(LocalDate.parse("2021-02-20"));
        List<Food> products = List.of(bread, meat, fish);
        products.forEach(controlQuality::addToStore);
        assertThat(store.get(0).getAllFood().get(0), is(products.get(0)));
        assertThat(store.get(0).getAllFood().get(1), is(products.get(1)));
        assertThat(store.get(0).getAllFood().get(2), is(products.get(2)));
        meat.setExpiryDate(meat.getExpiryDate().minusDays(95));
        fish.setExpiryDate(fish.getExpiryDate().minusDays(30));
        controlQuality.resort();
        assertThat(store.get(0).getAllFood().get(0), is(products.get(0)));
        assertThat(store.get(1).getAllFood().get(0), is(products.get(2)));
        assertThat(store.get(2).getAllFood().get(0), is(products.get(1)));
    }
}