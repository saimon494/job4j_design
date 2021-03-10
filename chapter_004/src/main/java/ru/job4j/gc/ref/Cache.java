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
        String rsl;
        SoftReference<String> softRef = cache.get(key);
        if (softRef != null) {
            rsl = softRef.get();
        } else {
            rsl = readFile(key);
            add(key);
        }
        return rsl;
    }

    private void add(String fileName) throws IOException {
        String rsl = readFile(fileName);
        if (rsl != null) {
            SoftReference<String> softRef = new SoftReference<>(rsl);
            cache.put(fileName, softRef);
        }
    }

    private String readFile(String fileName) throws IOException {
        String rsl;
        try (BufferedReader reader = new BufferedReader(new FileReader(path + "/" + fileName))) {
            StringJoiner stringJoiner = new StringJoiner(System.lineSeparator());
            reader.lines()
                    .forEach(stringJoiner::add);
            rsl = stringJoiner.toString();
        }
        return rsl;
    }

    public static void main(String[] args) throws IOException {
        String path = "./chapter_004/src/main/resources";
        Cache cache = new Cache(path);
        String file1 = "Names.txt";
        System.out.println(cache.get(file1));
        String file2 = "Address.txt";
        System.out.println(cache.get(file2));
    }
}