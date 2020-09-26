package com.olexyn.about.java.jdbc;

import com.olexyn.about.java.h2.H2Server;

import java.sql.*;

class Main {
    public static void main(String[] args) throws SQLException {

        PrettyPrint prettyPrint = new PrettyPrint();

        Connection connection = new H2Server().getConnection();

        System.out.println(connection);

        Statement statement = connection.createStatement();

        ResultSet rs;
        rs = statement.executeQuery("SELECT * FROM customers");
        prettyPrint.printResult(rs);

        int result;

        result = statement.executeUpdate("insert into customers values(10, 'Maya')");

        rs = statement.executeQuery("SELECT * FROM customers");
        prettyPrint.printResult(rs);

        result = statement.executeUpdate("update customers set name = 'Bob' where name = 'Paul'");

        rs = statement.executeQuery("SELECT * FROM customers");
        prettyPrint.printResult(rs);

        result = statement.executeUpdate("delete from customers where name = 'Peter'");


        rs = statement.executeQuery("SELECT * FROM customers");
        prettyPrint.printResult(rs);
    }


}

