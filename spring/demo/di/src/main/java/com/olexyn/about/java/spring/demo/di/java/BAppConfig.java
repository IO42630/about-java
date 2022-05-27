package com.olexyn.about.java.spring.demo.di.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BAppConfig {

    @Bean
    public BParentBean bParentBean() {
        var bean = new BParentBean();
        bean.setNestedBean(bNestedBean());
        return bean;
    }

    @Bean
    public BNestedBean bNestedBean() {
        return new BNestedBean();
    }

}
