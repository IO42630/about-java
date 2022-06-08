package com.olexyn.about.java.spring.jpa.tx;

import com.olexyn.about.java.spring.jpa.DataSourceConfig;
import com.olexyn.about.java.spring.jpa.jdbc.template.FruitTemplateRepo;
import com.olexyn.about.java.spring.jpa.jdbc.template.JdbcTemplateConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@Import({DataSourceConfig.class, JdbcTemplateConfig.class, FruitTemplateRepo.class})
@EnableTransactionManagement
public class TxConfig {

    @Autowired
    @Qualifier("myDataSource")
    DataSource dataSource;

    @Autowired
    FruitTemplateRepo fruitTemplateRepo;


    //@Transactional
    public void getFoo() {
        var entity = fruitTemplateRepo.findAll().get(0);
        entity.setColor("red");
        fruitTemplateRepo.save(entity);
        throw new RuntimeException();
    }

    @Bean
    public PlatformTransactionManager txManager() {
        return new DataSourceTransactionManager(dataSource);
    }



}
