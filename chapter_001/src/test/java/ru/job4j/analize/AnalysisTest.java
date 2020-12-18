package ru.job4j.analize;

import org.junit.Test;

import java.util.*;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AnalysisTest {

    @Test
    public void whenDeleteUsers() {
        List<User> previous = new ArrayList<>(Arrays.asList(
                new User(1, "aaa"),
                new User(2, "bbb"),
                new User(3, "ccc"),
                new User(4, "ddd")));
        List<User> current = new ArrayList<>(Arrays.asList(
                new User(1, "aaa"),
                new User(2, "bbb")));
        Info rsl = Analysis.diff(previous, current);
        assertThat(rsl.toString(), is("Info{added=0, changed=0, deleted=2}"));
    }

    @Test
    public void whenChangeUsers() {
        List<User> previous = new ArrayList<>(Arrays.asList(
                new User(1, "aaa"),
                new User(2, "bbb"),
                new User(3, "ccc"),
                new User(4, "ddd")));
        List<User> current = new ArrayList<>(Arrays.asList(
                new User(1, "eee"),
                new User(2, "fff"),
                new User(3, "ggg"),
                new User(4, "hhh")));
        Info rsl = Analysis.diff(previous, current);
        assertThat(rsl.toString(), is("Info{added=0, changed=4, deleted=0}"));
    }

    @Test
    public void whenAddUsers() {
        List<User> previous = new ArrayList<>(Arrays.asList(
                new User(1, "aaa"),
                new User(2, "bbb")));
        List<User> current = new ArrayList<>(Arrays.asList(
                new User(1, "aaa"),
                new User(2, "bbb"),
                new User(3, "ccc"),
                new User(4, "ddd")));
        Info rsl = Analysis.diff(previous, current);
        assertThat(rsl.toString(), is("Info{added=2, changed=0, deleted=0}"));
    }

    @Test
    public void whenAddAndDeleteUsers() {
        List<User> previous = new ArrayList<>(Arrays.asList(
                new User(1, "aaa"),
                new User(2, "bbb"),
                new User(3, "ccc")));
        List<User> current = new ArrayList<>(Arrays.asList(
                new User(1, "aaa"),
                new User(3, "ddd"),
                new User(4, "eee")));
        Info rsl = Analysis.diff(previous, current);
        assertThat(rsl.toString(), is("Info{added=1, changed=1, deleted=1}"));
    }
}