package ru.job4j.template;

import org.junit.Test;

import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;

public class GeneratorTest {

    @Test
    public void whenCorrectArgs() {
        String template = "I am ${name}. Who are ${subject}?";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Ivan");
        map.put("subject", "you");
        Generator generator = new TextGenerator();
        String result = generator.produce(template, map);
        String expected = "I am Ivan. Who are you?";
        assertThat(result, is(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenIncorrectArgs() {
        String template = "I am ${name}. Who are ${subject}?";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Ivan");
        map.put("subject", "23");
        Generator generator = new TextGenerator();
        String result = generator.produce(template, map);
        String expected = "I am Ivan. Who are you?";
        assertThat(result, is(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenIncorrectTemplate() {
        String template = "I am ${name}. I am from ${subject}.";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Ivan");
        Generator generator = new TextGenerator();
        String result = generator.produce(template, map);
        String expected = "I am Ivan. Who are you?";
        assertThat(result, is(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNotEnoughArgs() {
        String template = "I am ${name}. Who are ${subject}?";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Ivan");
        Generator generator = new TextGenerator();
        String result = generator.produce(template, map);
        String expected = "I am Ivan. Who are you?";
        assertThat(result, is(expected));
    }
}