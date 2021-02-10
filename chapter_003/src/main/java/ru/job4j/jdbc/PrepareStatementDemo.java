package ru.job4j.jdbc;

import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PrepareStatementDemo implements AutoCloseable {
    private Connection connection;
    private final Properties properties;

    public PrepareStatementDemo(Properties properties) throws ClassNotFoundException, SQLException {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url = properties.getProperty("url");
        String login = properties.getProperty("login");
        String password = properties.getProperty("password");
        connection = DriverManager.getConnection(url, login, password);
    }

    public void insert(City city) {
        try (PreparedStatement preparedStatement =
                connection.prepareStatement("insert into cities(name, population) values (?, ?)",
                        Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, city.getName());
            preparedStatement.setInt(2, city.getPopulation());
            preparedStatement.execute();
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    city.setId(generatedKeys.getInt(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean update(City city) {
        boolean result = false;
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(
                             "update cities set name = ?, population = ? where id = ?")) {
            preparedStatement.setString(1, city.getName());
            preparedStatement.setInt(2, city.getPopulation());
            preparedStatement.setInt(3, city.getId());
            result = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean delete(City city) {
        boolean result = false;
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement("delete from cities where id = ?")) {
            preparedStatement.setInt(1, city.getId());
            result = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<City> findAll() {
        List<City> cities = new ArrayList<>();
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement("select * from cities")) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    cities.add(new City(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getInt("population")
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cities;
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        final Properties properties = new Properties();
        properties.load(new FileReader("./chapter_003/src/main/resources/app.properties"));
        try (PrepareStatementDemo demo = new PrepareStatementDemo(properties)) {
            City city1 = new City(1, "Moscow", 15);
            City city2 = new City(2, "New York", 9);
            City city3 = new City(2, "Pariss", 2);
            demo.insert(city1);
            demo.insert(city2);
            demo.insert(city3);
            city1.setPopulation(12);
            System.out.println(demo.update(city1));
            city3.setName("Paris");
            System.out.println(demo.update(city3));
            List<City> cities = demo.findAll();
            for (City city : cities) {
                System.out.println(city.toString());
            }
            System.out.println(city3.getId());
            System.out.println(demo.delete(city3));
            cities = demo.findAll();
            for (City city : cities) {
                System.out.println(city.toString());
            }
        }
    }
}
