package ru.job4j.collection.mail;

import java.util.*;

public class CheckMail {
    private final Map<String, String> mailMap = new HashMap<>(); // email, user
    private final Map<String, Set<String>> userMap = new HashMap<>(); // user, Set<email>

    public void addUser(User user) {
        String userName = user.getName();
        List<String> mailList = user.getMailList();
        Set<String> mailSet = new HashSet<>();
        for (String email : mailList) {
            String userMapName = mailMap.put(email, userName);
            if (userMapName != null) {
                userName = userMapName;
            }
            mailSet.add(email);
        }
        if (userMap.get(userName) == null) {
            userMap.put(userName, mailSet);
        } else {
            userMap.get(userName).addAll(mailSet);
        }
    }

    public List<User> addAllUsers(List<User> list) {
        List<User> rsl = new ArrayList<>();
        CheckMail checkMail = new CheckMail();
        for (User user : list) {
            checkMail.addUser(user);
        }
        for (String s : checkMail.getUserMap().keySet()) {
            rsl.add(new User(s, new ArrayList<>(checkMail.getUserMap().get(s))));
        }
        return rsl;
    }

    public Map<String, Set<String>> getUserMap() {
        return userMap;
    }
}