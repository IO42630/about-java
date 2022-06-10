package com.olexyn.about.java.spring.jpa.tx;

import com.olexyn.about.java.spring.jpa.ds.DataSourceConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@Import({DataSourceConfig.class})
@EnableTransactionManagement
public class TxConfig {

    private final DataSource ds;

    public TxConfig(@Qualifier("rawDs") DataSource ds) {
        this.ds = ds;
    }

    @Bean
    public PlatformTransactionManager txManager() {
        return new DataSourceTransactionManager(ds);
        // could also
        // var tm = new JpaTransactionManager();
        // tm.setEntityManagerFactory(cemf.getObject());
        // return tm;
        // but this would require to inverse the dependency (know cemf prior to tx)
    }

    @Bean(name = "txJdbcTemplate")
    public JdbcTemplate txJdbcTemplate(@Qualifier("txDs") DataSource ds) {
        return new JdbcTemplate(ds);
    }

    @Bean(name = "txDs")
    public DataSource txAwareDs() {
        return new TransactionAwareDataSourceProxy(ds);
    }

}
