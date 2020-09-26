package com.olexyn.about.java.databases.jdbc;

import com.olexyn.about.java.databases.h2.H2Server;


import java.sql.*;
import java.util.HashMap;
import java.util.Map;

class Main {
    public static void main(String[] args) throws SQLException {

        Helpers helpers = new Helpers();

        Connection conn = new H2Server().getConnection();

        System.out.println(conn);

        Statement stmt = conn.createStatement();

        ResultSet rs;
        rs = stmt.executeQuery("SELECT * FROM customers");
        helpers.printResult(rs);

        rs = stmt.executeQuery("SELECT * FROM orders");
        helpers.printResult(rs);

        int result;

        result = stmt.executeUpdate("insert into customers values(10, 'Maya')");

        rs = stmt.executeQuery("SELECT * FROM customers");
        helpers.printResult(rs);

        result = stmt.executeUpdate("update customers set name = 'Bob' where name = 'Paul'");

        rs = stmt.executeQuery("SELECT * FROM customers");
        helpers.printResult(rs);

        result = stmt.executeUpdate("delete from customers where name = 'Peter'");


        rs = stmt.executeQuery("SELECT * FROM customers");
        helpers.printResult(rs);
    }


}

