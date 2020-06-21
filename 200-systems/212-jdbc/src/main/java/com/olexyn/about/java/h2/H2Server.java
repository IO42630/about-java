package com.olexyn.about.java.h2;

import org.h2.jdbcx.JdbcDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class H2Server {

    private Connection connection;

    public H2Server() {
        JdbcDataSource ds = new JdbcDataSource();
        ds.setURL("jdbc:h2:mem:db1");
        ds.setUser("user");
        ds.setPassword("password");
        try {
            connection = ds.getConnection();
        } catch (SQLException ignored) { }

        populate();
    }


    public Connection getConnection() {
        return connection;
    }



    private void populate(){
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate("CREATE TABLE customers (" + "customer_id INTEGER PRIMARY KEY, " + "name VARCHAR(255))");
            stmt.executeUpdate("CREATE TABLE orders (" + "order_id INTEGER PRIMARY KEY, " + "item VARCHAR(255), " + "customer_id INTEGER )");
            stmt.executeUpdate("INSERT INTO customers VALUES (1, 'Peter')");
            stmt.executeUpdate("INSERT INTO customers VALUES (2, 'Paul')");
            stmt.executeUpdate("INSERT INTO customers VALUES (3, 'Alice')");
            stmt.executeUpdate("INSERT INTO orders VALUES (1, 'Cake', 1)");
            stmt.executeUpdate("INSERT INTO orders VALUES (2, 'Coffee', 3)");
            stmt.executeUpdate("INSERT INTO orders VALUES (3, 'Tea', 4)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
