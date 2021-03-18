package ru.job4j.template;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;

public class GeneratorTest {

    private Map<String, String> map;
    private String template = "I am ${name}. Who are ${subject}?";
    private Generator generator;

    @Before
    public void init() {
        map = new HashMap<>();
        generator = new TextGenerator();
    }

    @Ignore
    @Test
    public void whenCorrectArgs() {
        map.put("name", "Ivan");
        map.put("subject", "you");
        String result = generator.produce(template, map);
        String expected = "I am Ivan. Who are you?";
        assertThat(result, is(expected));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenMoreArgs() {
        map.put("name", "Ivan");
        map.put("subject", "you");
        map.put("object", "me");
        generator.produce(template, map);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenNotEnoughArgs() {
        map.put("name", "Ivan");
        generator.produce(template, map);
    }
}