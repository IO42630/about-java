package com.olexyn.about.java.spring.jpa.jdbc.template;

import com.olexyn.about.java.spring.jpa.DataSourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@Import(DataSourceConfig.class)
public class JdbcTemplateConfig {

    @Autowired
    @Qualifier("myDataSource")
    DataSource dataSource;

    @Bean
    public JdbcTemplate applicationDataConnection() {
        return new JdbcTemplate(dataSource);
    }

}
