package com.olexyn.about.java.spring.demo.jpa;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Statement;

public class JpaDemo {
    public static void main(String[] args) throws SQLException {
        var context = new AnnotationConfigApplicationContext(JpaAppConfig.class);
        var dataSource = context.getBean(DataSource.class);
        var connection = dataSource.getConnection();
        try (Statement stmt = connection.createStatement()) {
            var resultSet = stmt.executeQuery("SELECT * FROM fruit");
            int br = 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        context.close();
    }
}
