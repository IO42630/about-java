package com.olexyn.about.java.spring.demo.di.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BAppConfig {

    @Bean
    public BParentBean bParentBean() {
        var bean = new BParentBean();
        // bean.setNestedBean(bNestedBean());
        bean.setNestedBean(new BNestedBean()); // better to call constructor, since bNestedBean() can only be resolved in in same @Configuration file.
        return bean;
    }

    /**
     * Might override `name` like this.
     * Spring will intercept calls to this method and return a bean (same bean if singleton)
     */
    @Bean(name = "bNestedBean")
    public BNestedBean bNestedBean() {
        return new BNestedBean();
    }

}
