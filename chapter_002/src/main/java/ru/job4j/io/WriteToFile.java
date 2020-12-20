package ru.job4j.io;

import java.io.FileOutputStream;

public class WriteToFile {
    public static int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                table[i - 1][j - 1] = i * j;
            }
        }
        return table;
    }

    public static void main(String[] args) {
        int[][] table = multiple(9);
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < table[i].length; j++) {
                    String s = table[i][j] + " " + "\t";
                    out.write(s.getBytes());
                }
                out.write(System.lineSeparator().getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
