package com.olexyn.about.java.spring.jpa.jdbc.template;

import com.olexyn.about.java.spring.jpa.ds.DataSourceConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@Import({DataSourceConfig.class})
public class TemplateConfig {

    @Bean(name = "jdbcTemplate")
    @Primary
    public JdbcTemplate jdbcTemplate(@Qualifier("rawDs") DataSource ds) {
        return new JdbcTemplate(ds);
    }

}
