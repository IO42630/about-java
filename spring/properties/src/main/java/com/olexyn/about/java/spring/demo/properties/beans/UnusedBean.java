package com.olexyn.about.java.spring.demo.properties.beans;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * It does not matter where @PropertySource is used, as long as it is within @ComponentScan
 */
@Configuration
@PropertySource("classpath:environment_config_bean.properties")
@PropertySource("classpath:value_config_bean.properties")
@PropertySource("classpath:hidden/hidden.properties") /* scan that file for properties - classpath is defined in <resources> of pom.xml */
public class UnusedBean implements ConfiguredBean {

    @Override
    public String getProperty() {
        return null;
    }

    @Override
    public String getHiddenProperty() {
        return null;
    }

}
