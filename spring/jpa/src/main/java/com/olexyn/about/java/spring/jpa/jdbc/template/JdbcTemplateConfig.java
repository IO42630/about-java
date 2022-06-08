package com.olexyn.about.java.spring.jpa.jdbc.template;

import com.olexyn.about.java.spring.jpa.DataSourceConfig;
import com.olexyn.about.java.spring.jpa.tx.TxConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

@Configuration
@Import({DataSourceConfig.class, TxConfig.class})
public class JdbcTemplateConfig {

    @Bean(name="jdbcTemplate")
    @Primary
    public JdbcTemplate jdbcTemplate(@Qualifier("rawDs") DataSource ds) {
        return new JdbcTemplate(ds);
    }

    @Bean(name="txJdbcTemplate")
    public JdbcTemplate txJdbcTemplate(@Qualifier("txDs") DataSource ds) {
        return new JdbcTemplate(ds);
    }

}
