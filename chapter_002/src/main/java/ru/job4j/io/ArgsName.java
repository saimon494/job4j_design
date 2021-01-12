package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        String rsl = values.get(key);
        if (rsl == null) {
            throw new IllegalArgumentException("Parameter -" + key + " not set");
        }
        return rsl;
    }

    private void parse(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException(
                    "No args");
        }
        for (String arg : args) {
            String[] words = arg.split("=");
            if (words.length != 2) {
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
