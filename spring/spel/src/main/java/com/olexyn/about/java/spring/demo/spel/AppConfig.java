package com.olexyn.about.java.spring.demo.spel;

import com.olexyn.about.java.spring.demo.spel.beans.SomeBean;
import com.olexyn.about.java.spring.demo.spel.beans.SpelBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    SomeBean someBean() {
        return new SomeBean();
    }

    @Bean
    SpelBean spelBean() {
        return new SpelBean();
    }

}
