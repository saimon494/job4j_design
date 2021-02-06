package ru.job4j.collection.mail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class CheckMailTest {
    private final User user1 = new User("user1");
    private final User user2 = new User("user2");
    private final User user3 = new User("user3");
    private final User user4 = new User("user4");
    private final User user5 = new User("user5");
    private final List<User> userList = new ArrayList<>();

    @Before
    public void createUsers() {
        user1.addMail("xxx@ya.ru");
        user1.addMail("foo@gmail.com");
        user1.addMail("lol@mail.ru");
        user2.addMail("foo@gmail.com");
        user2.addMail("ups@pisem.net");
        user3.addMail("xyz@pisem.net");
        user3.addMail("vasya@pupkin.com");
        user4.addMail("ups@pisem.net");
        user4.addMail("aaa@bbb.ru");
        user5.addMail("xyz@pisem.net");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
    }

    @Test
    public void addUser() {
        CheckMail checkMail = new CheckMail();
        checkMail.addUser(user1);
        checkMail.addUser(user2);
        checkMail.addUser(user3);
        checkMail.addUser(user4);
        checkMail.addUser(user5);
        Assert.assertEquals(2, checkMail.getUserMap().size());
    }

    @Test
    public void addAllUsers() {
        CheckMail checkMail = new CheckMail();
        List<User> list = checkMail.addAllUsers(userList);
        Assert.assertTrue(list.get(0).getMailList().contains("aaa@bbb.ru"));
        Assert.assertTrue(list.get(0).getMailList().contains("ups@pisem.net"));
        Assert.assertTrue(list.get(0).getMailList().contains("lol@mail.ru"));
        Assert.assertTrue(list.get(0).getMailList().contains("xxx@ya.ru"));
        Assert.assertTrue(list.get(0).getMailList().contains("foo@gmail.com"));
        Assert.assertTrue(list.get(1).getMailList().contains("vasya@pupkin.com"));
        Assert.assertTrue(list.get(1).getMailList().contains("xyz@pisem.net"));
    }

    @Test
    public void userMap() {
        CheckMail checkMail = new CheckMail();
        checkMail.addUser(user1);
        checkMail.addUser(user2);
        checkMail.addUser(user3);
        checkMail.addUser(user4);
        checkMail.addUser(user5);
        System.out.println(checkMail.getUserMap());
    }
}