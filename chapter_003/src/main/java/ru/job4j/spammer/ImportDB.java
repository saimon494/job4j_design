package ru.job4j.spammer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@SuppressWarnings("checkstyle:LineLength")
public class ImportDB {
    private final Properties cfg;
    private final String dump;

    public ImportDB(Properties cfg, String dump) {
        this.cfg = cfg;
        this.dump = dump;
    }

    private static class User {
        private final String name;
        private final String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }

    public List<User> load() throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader rd = new BufferedReader(new FileReader(dump))) {
            rd.lines()
                    .forEach(s -> {
                        String[] line = s.split(";");
                        if (line.length == 2) {
                            users.add(new User(
                                    line[0],
                                    line[1]
                            ));
                        }
                     });
        }
        return users;
    }

    public void save(List<User> users) throws ClassNotFoundException, SQLException {
        Class.forName(cfg.getProperty("jdbc.driver"));
        try (Connection cn = DriverManager.getConnection(
                cfg.getProperty("jdbc.url"),
                cfg.getProperty("jdbc.username"),
                cfg.getProperty("jdbc.password")
        )) {
            for (User user : users) {
                try (PreparedStatement statement = cn.prepareStatement(
                        "insert into users(name, email) values (?, ?)")) {
                        statement.setString(1, user.name);
                    statement.setString(2, user.email);
                    statement.execute();
                }
            }
        }
    }

    public static void main(String[] args)
            throws IOException, SQLException, ClassNotFoundException {
        Properties cfg = new Properties();
        cfg.load(new FileReader("./chapter_003/src/main/resources/spammer.properties"));
        ImportDB importDB = new ImportDB(cfg, "./chapter_003/src/main/resources/dump.txt");
        importDB.save(importDB.load());
    }
}