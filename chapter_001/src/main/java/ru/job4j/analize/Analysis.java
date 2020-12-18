package ru.job4j.analize;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Analysis {
    public static Info diff(List<User> previous, List<User> current) {
        int deleted = 0;
        int added;
        int changed = 0;

        Map<Integer, User> diffMap = new HashMap<>();

        for (User currUser : current) {
            diffMap.put(currUser.getId(), currUser);
        }

        for (User prevUser : previous) {
            if (!diffMap.containsKey(prevUser.getId())) {
                deleted++;
            } else if (!diffMap.get(prevUser.getId()).equals(prevUser)) {
                changed++;
            }
        }

        added = current.size() - previous.size() + deleted;
        return new Info(added, changed, deleted);
    }
}