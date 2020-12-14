package ru.job4j.collection;

import java.util.*;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", children=" + children +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return children == user.children &&
                Objects.equals(name, user.name) &&
                Objects.equals(birthday, user.birthday);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(name, children, birthday);
//    }

    public int hashCode() {
        int result = 17;
        result = 31 * result + (name == null ? 0 : name.hashCode());
        result = 31 * result + children;
        result = 31 * result + (birthday == null ? 0 : birthday.hashCode());
        return result;
    }

    public static void main(String[] args) {
        User user1 = new User("Vasya", 1, new GregorianCalendar(1985, 02, 20));
        User user2 = new User("Vasya", 1, new GregorianCalendar(1985, 02, 20));
        System.out.println(user1.equals(user2));
        System.out.println("user1.hashCode() = " + user1.hashCode());
        System.out.println("user2.hashCode() = " + user2.hashCode());
        Map<User, Object> map = new HashMap<>();
        map.put(user1, new Object());
        map.put(user2, new Object());
        map.entrySet().forEach(System.out::println);
        System.out.println(map.get(user1));
        System.out.println(map.get(user2));

    }
}
