package com.olexyn.about.java.databases.jdbc;

import com.olexyn.about.java.databases.h2.H2PocketServer;
import com.olexyn.about.java.databases.h2.H2PocketServerDemo;


import java.sql.*;

class Main {
    public static void main(String[] args) throws SQLException, InterruptedException {

        Helpers helpers = new Helpers();

        Connection conn = new H2PocketServerDemo().getConnection();

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

        while (true){
            Thread.sleep(500);
        }
    }


}

