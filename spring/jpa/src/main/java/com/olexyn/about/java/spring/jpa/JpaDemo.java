package com.olexyn.about.java.spring.jpa;


import com.olexyn.about.java.spring.jpa.jdbc.template.FruitTemplateRepo;
import com.olexyn.about.java.spring.jpa.tx.FruitTxTemplateRepo;
import com.olexyn.about.java.spring.jpa.util.Helpers;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

public class JpaDemo {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        testDs(ctx);
        testTemplate(ctx);
        testTx(ctx);
        testEmJava(ctx);
        testEmAnno(ctx);
        ctx.close();
    }

    public static void testDs(ApplicationContext ctx) {
        var ds = (DataSource) ctx.getBean("rawDs");
        try {
            var rs = ds.getConnection().createStatement().executeQuery("SELECT * FROM fruit");
            new Helpers().resultSetToTable(rs);
        } catch (SQLException ignored) { }
    }

    public static void testTemplate(ApplicationContext ctx) {
        var result = ctx.getBean(FruitTemplateRepo.class).findAll();
    }

    public static void testTx(ApplicationContext ctx) {
        var repo = ctx.getBean(FruitTxTemplateRepo.class);
        var entity = repo.findAll().get(0);
        try {
            entity.setName("ROLLED BACK");
            repo.update(entity);
        } catch (RuntimeException e) {
            repo.findAll().get(0);
        }
    }

    public static void testEmJava(ApplicationContext ctx) {

    }

    public static void testEmAnno(ApplicationContext ctx) {

    }

}
