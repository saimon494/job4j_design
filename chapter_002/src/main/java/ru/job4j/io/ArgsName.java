package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        return values.get(key);
    }

    private void parse(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException(
                    "No args");
        }
        for (String line : args) {
            String[] words = line.split("=");
            if (args.length < 2) {
                throw new IllegalArgumentException(
                        "Not enough args");
            }
            values.put(words[0].substring(1), words[1]);
        }
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }
}
