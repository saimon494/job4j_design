package ru.job4j.menu;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MenuTest {

    private Menu menu;

    @Before
    public void init() {
        menu = new Menu(new Node("Задача 0", new SimpleAction()));
    }

    @Test
    public void whenPrintMenu() {
        menu.add("Задача 0", "Задача 1.", new SimpleAction());
        menu.add("Задача 1.", "Задача 1.1.", new SimpleAction());
        menu.add("Задача 1.", "Задача 1.2.", new SimpleAction());
        menu.add("Задача 1.2.", "Задача 1.2.1.", new SimpleAction());
        menu.add("Задача 1.1.", "Задача 1.1.1.", new SimpleAction());
        menu.add("Задача 0", "Задача 2.", new SimpleAction());
        String rsl = menu.print();

        StringBuilder expected = new StringBuilder()
                .append("Задача 1.").append(System.lineSeparator())
                .append("----Задача 1.1.").append(System.lineSeparator())
                .append("--------Задача 1.1.1.").append(System.lineSeparator())
                .append("----Задача 1.2.").append(System.lineSeparator())
                .append("--------Задача 1.2.1.").append(System.lineSeparator())
                .append("Задача 2.").append(System.lineSeparator());
        System.out.println(expected);
        assertThat(rsl, is(expected.toString()));
    }
}