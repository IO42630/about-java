package com.olexyn.about.java.persistence.h2;

import org.h2.jdbcx.JdbcDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class H2PocketServer {

    private Connection connection;

    protected H2PocketServer() {
        var jdbcDataSource = new JdbcDataSource();
        jdbcDataSource.setURL("jdbc:h2:mem:db1");
        jdbcDataSource.setUser("user");
        jdbcDataSource.setPassword("password");

        try {
            connection = ((DataSource) jdbcDataSource).getConnection();
        } catch (SQLException ignored) { /* ignore */ }
    }


    public Connection getConnection() {
        return connection;
    }

    protected abstract void init();

}
