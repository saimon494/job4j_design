package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class RoleStoreTest {

    @Test
    public void whenAdd() {
        Store<Role> store = new RoleStore();
        Role role = new Role("aaa");
        store.add(role);
        assertThat(store.findById("aaa"), is(role));
        assertNull(store.findById("bbb"));
    }

    @Test
    public void whenReplace() {
        Store<Role> store = new RoleStore();
        Role role1 = new Role("aaa");
        Role role2 = new Role("bbb");
        store.add(role1);
        store.replace("aaa", role2);
        assertThat(store.findById("bbb"), is(role2));
    }

    @Test
    public void whenDelete() {
        Store<Role> store = new RoleStore();
        Role role = new Role("aaa");
        store.add(role);
        store.delete("aaa");
        assertNull(store.findById("aaa"));
    }
}