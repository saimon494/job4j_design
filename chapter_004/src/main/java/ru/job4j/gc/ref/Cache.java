package ru.job4j.gc.ref;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Cache {

    private final Map<String, SoftReference<String>> cache;
    private final String path;

    public Cache(String path) {
        this.cache = new HashMap<>();
        this.path = path;
    }

    public String get(String key) throws IOException {
        String rsl = "";
        if (cache.containsKey(key)) {
            rsl = cache.get(key).get();
        }
        if (rsl == null || rsl.isEmpty() || !cache.containsKey(key)) {
            rsl = readFile(key);
            cache.put(key, new SoftReference<>(rsl));
        }
        return rsl;
    }

    private String readFile(String fileName) throws IOException {
        StringJoiner stringJoiner = new StringJoiner(System.lineSeparator());
        try (BufferedReader reader = new BufferedReader(new FileReader(path + "/" + fileName))) {
            reader.lines()
                    .forEach(stringJoiner::add);
        }
        return stringJoiner.toString();
    }

    public static void main(String[] args) throws IOException {
        String path = "./chapter_004/src/main/resources";
        Cache cache = new Cache(path);
        String file1 = "Names.txt";
        System.out.println(cache.get(file1));
        String file2 = "Address.txt";
        System.out.println(cache.get(file2));
        System.out.println(cache.get(file1));
        System.out.println(cache.get(file2));
    }
}