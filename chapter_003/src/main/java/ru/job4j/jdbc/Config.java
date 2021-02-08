package ru.job4j.jdbc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Config {
    private final Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        loadConfig(path);
    }

    private void loadConfig(String path) {
        try {
            BufferedReader read = new BufferedReader(new FileReader(path));
            read.lines()
                    .filter(r -> (!r.contains("#") && r.contains("=")))
                    .forEach(line -> {
                        String[] lines = line.split("=");
                        values.put(lines[0], lines[1]);
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getValue(String key) {
        if (!values.containsKey(key)) {
            throw new IllegalArgumentException("No such property in file");
        }
        return values.get(key);
    }
}