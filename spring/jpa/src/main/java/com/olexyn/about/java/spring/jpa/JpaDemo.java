package com.olexyn.about.java.spring.jpa;


import com.olexyn.about.java.spring.jpa.jdbc.template.FruitTemplateRepo;
import com.olexyn.about.java.spring.jpa.tx.FruitTxTemplateRepo;
import com.olexyn.about.java.spring.jpa.tx.TxAwareService;
import com.olexyn.about.java.spring.jpa.tx.TxConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Statement;

public class JpaDemo {
    public static void main(String[] args) throws SQLException {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);
        var dataSource =(DataSource) context.getBean("rawDs");
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
            txConfig.getBean(TxAwareService.class).getFoo();
        } catch (RuntimeException e) {

        }

        context.close();
    }
}
