package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private static final Charset CHARSET = StandardCharsets.UTF_8;
    private final String path;
    private final String botAnswers;
    private final Map<Integer, String> textMap = new HashMap<>();
    private int count = 0;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    private void readAnswers() {
        String line;
        try (BufferedReader reader = new BufferedReader(
                new FileReader(botAnswers, CHARSET))) {
            while ((line = reader.readLine()) != null) {
                textMap.put(count, line);
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeLog(String word) {
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(path, CHARSET, true))) {
            writer.write(word + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        boolean checkAnswer = true;
        String word = "";
        readAnswers();
        System.out.println("Я бот, поговори со мной:)");
        try (Scanner scanner = new Scanner(System.in)) {
            while (!OUT.equals(word)) {
                word = scanner.nextLine();
                writeLog(word);
                if (!STOP.equals(word)
                        && !OUT.equals(word)
                        && checkAnswer || CONTINUE.equals(word)) {
                    int numAnswer = (int) (Math.random() * count);
                    String answer = textMap.get(numAnswer);
                    System.out.println(answer);
                    writeLog(answer);
                } else {
                    checkAnswer = false;
                }
                if (CONTINUE.equals(word)) {
                    checkAnswer = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        String path = "chapter_002/data/logChat.txt";
        String botAnswers = "chapter_002/data/botAnswers.txt";
        ConsoleChat consoleChat = new ConsoleChat(path, botAnswers);
        consoleChat.run();
    }
}