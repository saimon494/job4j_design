package ru.job4j.gc;

import com.carrotsearch.sizeof.RamUsageEstimator;

import java.util.Arrays;

import static com.carrotsearch.sizeof.RamUsageEstimator.sizeOf;

public class UserDemo {

    public static void main(String[] args) {
        User user1 = new User("Name1", 20);
        User user2 = new User("Name2", 25);
        System.out.printf("size of user1 = %d\n", sizeOf(user1));
        System.out.printf("size of user2 = %d\n", sizeOf(user2));
        long size = RamUsageEstimator.sizeOfAll(Arrays.asList(user1, user2));
        System.out.printf("size all = %d\n", size);

        EmptyUser emptyUser = new EmptyUser();
        System.out.printf("size of emptyUser = %d\n", sizeOf(emptyUser));

        GCDemo.info();
        for (int i = 0; i < 7300; i++) {
            new User("Name" + i, i);
        }
//        System.gc();
        GCDemo.info();
    }
}
