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
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@Import({DataSourceConfig.class, FruitTemplateRepo.class})
@EnableTransactionManagement
public class TxConfig {

    private final DataSource ds;

    public TxConfig(@Qualifier("rawDs") DataSource ds) {
        this.ds = ds;
    }

    @Bean
    public PlatformTransactionManager txManager() {
        return new DataSourceTransactionManager(ds);
    }

    @Bean(name = "txDs")
    public DataSource txAwareDs() {
        return new TransactionAwareDataSourceProxy(ds);
    }

}
