package com.olexyn.about.java.spring.demo.jpa;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import javax.sql.DataSource;
import java.sql.SQLException;

@ComponentScan("com.olexyn.about.java.spring.demo.jpa")
public class JpaDemo {
    public static void main(String[] args) throws SQLException {
        var context = new AnnotationConfigApplicationContext(JpaAppConfig.class);
        var dataSource = context.getBean(DataSource.class);
        var connection = dataSource.getConnection();
        context.close();
    }
}
