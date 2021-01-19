package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        byte b = 12;
        short s = 1000;
        int i = 10000;
        long l = 10000L;
        float f = 1.2f;
        double d = 12.12;
        char c = 'd';
        boolean bool = true;
        LOG.debug("Primitive types: byte = {}, short = {}, int = {}, long = {}, float = {}, double = {}, char = {}, boolean = {}",
                b, s, i, l, f, d, c, bool);
    }
}