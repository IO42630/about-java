package com.olexyn.about.java.spring.demo.properties.beans;

import org.springframework.beans.factory.annotation.Value;

public class ValueConfiguredBean implements ConfiguredBean {

    @Value("${some.value.config.property}")
    private String property;

    @Value("${hidden.property}")
    private String hiddenProperty;

    @Value("${SESSIONNAME}")
    String sessionName; /* this is an systemProperty */

    @Override
    public String getProperty() {
        return property;
    }

    @Override
    public String getHiddenProperty() {
        return hiddenProperty;
    }

}
