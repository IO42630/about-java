package com.olexyn.about.java.spring.demo.properties;

import com.olexyn.about.java.spring.demo.properties.beans.ConfiguredBean;
import com.olexyn.about.java.spring.demo.properties.beans.EnvironmentConfiguredBean;
import com.olexyn.about.java.spring.demo.properties.beans.ValueConfiguredBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration /* this is a config file */
@ComponentScan("com.olexyn.about.java.spring.demo.properties") /* scan there for components. */
public class AppConfig {

    @Autowired
    Environment environment;

    @Bean
    ConfiguredBean envConfBean() {
        var bean = new EnvironmentConfiguredBean();
        bean.setProperty(environment.getProperty("some.environment.config.property"));
        bean.setHiddenProperty(environment.getProperty("hidden.property"));
        return bean;
    }

    @Bean
    ConfiguredBean valueConfBean() {
        return new ValueConfiguredBean();
    }

}
