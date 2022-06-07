package com.olexyn.about.java.spring.demo.empty;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    SomeBean envConfBean() {
        return new SomeBean();
    }

}
