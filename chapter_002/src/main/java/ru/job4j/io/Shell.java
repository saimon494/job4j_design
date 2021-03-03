package ru.job4j.io;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Shell {

    private final Stack<String> stack = new Stack<>();

    public void cd(String path) {
        String[] arr = path.split("/");
        for (String s : arr) {
            if (s.equals("..")) {
                stack.pop();
            } else {
                stack.push(s);
            }
        }
    }

    public String pwd() {
        StringBuilder rsl = new StringBuilder();
        List<String> list = new ArrayList<>(stack);
        for (String s : list) {
            rsl.append("/").append(s);
        }
        if (rsl.toString().equals("")) {
            rsl = new StringBuilder("/");
        }
        return rsl.toString();
    }
}
