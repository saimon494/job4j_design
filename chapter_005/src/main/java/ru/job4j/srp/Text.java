package ru.job4j.srp;

public class Text {
    private String text;

    public String replaceWord(String word) {
        return text.replaceAll(word, text);
    }

    public boolean findWord(String word) {
        return text.contains(word);
    }
}