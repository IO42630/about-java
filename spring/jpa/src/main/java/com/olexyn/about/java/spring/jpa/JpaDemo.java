package com.olexyn.about.java.spring.jpa;


import com.olexyn.about.java.spring.jpa.jdbc.template.FruitTemplateRepo;
import com.olexyn.about.java.spring.jpa.tx.TxConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Statement;

public class JpaDemo {
    public static void main(String[] args) throws SQLException {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);
        var dataSource = context.getBean(DataSource.class);
        var connection = dataSource.getConnection();
        try (Statement stmt = connection.createStatement()) {
            var resultSet = stmt.executeQuery("SELECT * FROM fruit");
            int br = 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }




        var templateRepo = context.getBean(FruitTemplateRepo.class);
        var boo = templateRepo.findAll();

        var txConfig = new AnnotationConfigApplicationContext(TxConfig.class);
        try {
            txConfig.getBean(TxConfig.class).getFoo();
        } catch (RuntimeException e) {

        }

        context.close();
    }
}
