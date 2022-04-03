package com.olexyn.about.java.databases.h2;

import org.h2.jdbcx.JdbcDataSource;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class H2Server {

    private Connection connection;

    public H2Server() {
        JdbcDataSource jdbcDataSource = new JdbcDataSource();
        jdbcDataSource.setURL("jdbc:h2:mem:db1");
        jdbcDataSource.setUser("user");
        jdbcDataSource.setPassword("password");

        try {
            connection = ((DataSource) jdbcDataSource).getConnection();
        } catch (SQLException ignored) { }

        populate();
    }


    public Connection getConnection() {
        return connection;
    }



    private void populate(){
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate("CREATE TABLE CUSTOMERS (" + "CUSTOMER_ID INTEGER PRIMARY KEY, NAME" + " VARCHAR(255))");
            stmt.executeUpdate("CREATE TABLE ORDERS (ORDERS_ID" + " INTEGER PRIMARY KEY, ITEM" + " VARCHAR(255), " + "CUSTOMER_ID INTEGER )");
            stmt.executeUpdate("INSERT INTO CUSTOMERS VALUES (1, 'Peter')");
            stmt.executeUpdate("INSERT INTO CUSTOMERS VALUES (2, 'Paul')");
            stmt.executeUpdate("INSERT INTO CUSTOMERS VALUES (3, 'Alice')");
            stmt.executeUpdate("INSERT INTO ORDERS VALUES (1, 'Cake', 1)");
            stmt.executeUpdate("INSERT INTO ORDERS VALUES (2, 'Coffee', 3)");
            stmt.executeUpdate("INSERT INTO ORDERS VALUES (3, 'Tea', 4)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
