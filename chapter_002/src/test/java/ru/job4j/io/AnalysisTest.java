package ru.job4j.io;

import org.junit.Test;

import java.io.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AnalysisTest {
    String source = "./data/server.log";
    String target = "./data/unavailable.csv";

    @Test
    public void analysisServerLog() throws IOException {
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01");
            out.println("500 10:57:01");
            out.println("400 10:58:01");
            out.println("200 10:59:01");
            out.println("500 11:01:02");
            out.println("200 12:02:02");
        }
        Analysis analysis = new Analysis();
        analysis.unavailable(source, target);
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(target))) {
            reader.lines().forEach(rsl::append);
        }
        assertThat(rsl.toString(), is("10:57:01 - 10:59:01; 11:01:02 - 12:02:02; "));
    }
}