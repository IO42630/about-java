package com.olexyn.about.java.spring.demo.profiles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfig {



    @Bean(name = "someBean")
    @Profile("dev")
    SomeBean someBean() {
        return new SomeBean("someBeanDev");
    }



}
