package ru.job4j.collection.mail;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String name;
    private final List<String> mailList;

    public User(String name) {
        this.name = name;
        this.mailList = new ArrayList<>();
    }

    public User(String name, List<String> mailList) {
        this.name = name;
        this.mailList = mailList;
    }

    public String getName() {
        return name;
    }

    public void addMail(String mail) {
        if (mail != null) {
            mailList.add(mail);
        }
    }

    public List<String> getMailList() {
        return mailList;
    }
}