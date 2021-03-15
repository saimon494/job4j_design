package ru.job4j.gc;

import org.openjdk.jmh.annotations.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Fork(value = 1, warmups = 1)
@Warmup(iterations = 5)
@Measurement(iterations = 5)

public class Article {

    private final String originStr = "Мой дядя самых честных правил, "
            + "Когда не в шутку занемог, "
            + "Он уважать себя заставил "
            + "И лучше выдумать не мог. "
            + "Его пример другим наука; "
            + "Но, боже мой, какая скука "
            + "С больным сидеть и день и ночь, "
            + "Не отходя ни шагу прочь! "
            + "Какое низкое коварство "
            + "Полуживого забавлять, "
            + "Ему подушки поправлять, "
            + "Печально подносить лекарство, "
            + "Вздыхать и думать про себя: "
            + "Когда же черт возьмет тебя!";

    private final String testStr = "Мой дядя мог думать про тебя и день и ночь";

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

    public static boolean generateByList(String origin, String line) {
        boolean rsl = true;
        String[] originList = origin.split("[^а-яА-Яa-zA-Z]");
        String[] lineList = line.split("[^а-яА-Яa-zA-Z]");
        for (String s : lineList) {
            rsl = Arrays.asList(originList).contains(s);
            if (!rsl) {
                break;
            }
        }
        return rsl;
    }

    @Benchmark
    public void testByMap() {
        generateBy(originStr, testStr);
    }

    @Benchmark
    public void testByList() {
        generateByList(originStr, testStr);
    }

    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }
}