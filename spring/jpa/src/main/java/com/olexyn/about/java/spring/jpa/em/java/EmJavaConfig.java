package com.olexyn.about.java.spring.jpa.em.java;

import com.olexyn.about.java.spring.jpa.ds.DataSourceConfig;
import com.olexyn.about.java.spring.jpa.tx.TxConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.AbstractEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@Import(TxConfig.class)
public class EmJavaConfig {

    @Bean
    @Profile("disabled")
    @Qualifier("emf")
    public LocalEntityManagerFactoryBean entityManagerFactory(
        DataSourceConfig dsConfig
    ) {
        var cemf = new LocalEntityManagerFactoryBean();
        cemf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        cemf.setJpaProperties(additionalProperties(dsConfig));
        return cemf;
    }

    @Bean
    @Qualifier("cemf")
    public LocalContainerEntityManagerFactoryBean containerEntityManagerFactory(
        @Qualifier("txDs") DataSource txDs,
        DataSourceConfig dsConfig
    ) {
        var cemf = new LocalContainerEntityManagerFactoryBean();
        cemf.setDataSource(txDs);
        cemf.setPackagesToScan(new String[]{"com.olexyn.about.java.spring.jpa"});
        cemf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        cemf.setJpaProperties(additionalProperties(dsConfig));

        return cemf;
    }

    /**
     * Out of CONTEXT for now.
     */
    private void cemfMagic(AbstractEntityManagerFactoryBean cemf) {
        var provider = cemf.getPersistenceProvider();
        if (provider != null) {
            var name = cemf.getPersistenceUnitName();
            var map = cemf.getJpaPropertyMap();
            var cemf2 = provider.createEntityManagerFactory(name, map);
            var someEm = cemf2.createEntityManager();
        }
    }

    Properties additionalProperties(DataSourceConfig ds) {
        var properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", ds.ddlAuto);
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        return properties;
    }

//    @Bean
//    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
//        return new PropertySourcesPlaceholderConfigurer();
//    }





    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

}
