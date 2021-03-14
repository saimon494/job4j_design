package ru.job4j.gc;

import org.openjdk.jmh.annotations.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Article {
    public static boolean generateBy(String origin, String line) {
        boolean rsl = true;
        String[] originList = origin.split("[^а-яА-Яa-zA-Z]");
        Map<String, Integer> originMap = new HashMap<>();
        for (String s : originList) {
            originMap.put(s, null);
        }
        String[] lineList = line.split("[^а-яА-Яa-zA-Z]");
        for (String s : lineList) {
            if (!originMap.containsKey(s)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @Warmup(iterations = 5)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void init() {
        // Do nothing
    }

    public static void main(String[] args) {
        String origin = "Когда не в шутку занемог, ";
        String[] originList = origin.split("[^а-яА-Я]");
        System.out.println(Arrays.toString(originList));
    }
}