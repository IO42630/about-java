package com.olexyn.about.java.jdbc;

import com.olexyn.about.java.h2.H2Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

class Main {
    public static void main(String[] args) throws Exception {

        Connection conn = new H2Server().getConnection();


    }
}

