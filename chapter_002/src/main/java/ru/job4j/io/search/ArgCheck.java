package ru.job4j.io.search;

import ru.job4j.io.ArgsName;

public class ArgCheck {
    private final ArgsName argsName;

    public ArgCheck(String[] args) {
        argsName = ArgsName.of(args);
    }

    public boolean valid() {
        if (!getFindType().contains("name")
                    && !getFindType().contains("mask")
                    && !getFindType().contains("regex")) {
                throw new IllegalArgumentException(
                        "Parameter -t incorrect");
        }
        return true;
    }

    public String getDirectory() {
        return argsName.get("d");
    }

    public String getFileName() {
        return argsName.get("n");
    }

    public String getFindType() {
        return argsName.get("t");
    }

    public String getOutput() {
        return argsName.get("o");
    }
}