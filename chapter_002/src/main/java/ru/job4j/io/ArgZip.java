package ru.job4j.io;

public class ArgZip {
    private final ArgsName argsName;

    public ArgZip(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException(
                    "No args");
        }
        argsName = ArgsName.of(args);
    }

    public boolean valid() {
        if (directory().isEmpty()) {
            throw new IllegalArgumentException(
                    "Parameter -d not set");
        } else if (exclude().isEmpty()) {
            throw new IllegalArgumentException(
                    "Parameter -e not set");
        } else if (output().isEmpty()) {
            throw new IllegalArgumentException(
                    "Parameter -o not set");
        }
        return true;
    }

    public String directory() {
        return argsName.get("d");
    }

    public String exclude() {
        return argsName.get("e");
    }

    public String output() {
        return argsName.get("o");
    }
}
