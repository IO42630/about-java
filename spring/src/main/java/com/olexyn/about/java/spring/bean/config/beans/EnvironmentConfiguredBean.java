package com.olexyn.about.java.spring.bean.config.beans;

public class EnvironmentConfiguredBean implements ConfiguredBean {

    private String property;
    private String hiddenProperty;

    @Override
    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    @Override
    public String getHiddenProperty() {
        return hiddenProperty;
    }

    public void setHiddenProperty(String hiddenProperty) {
        this.hiddenProperty = hiddenProperty;
    }

}
