package com.olexyn.about.java.spring.demo.di.java;

import org.springframework.context.annotation.Bean;

public class LiteBeanConfig {

    @Bean(name = "liteBean")
    BNestedBean liteBean() {
        return new BNestedBean();
    }

}
