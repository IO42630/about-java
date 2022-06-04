package com.olexyn.about.java.spring.demo.beanlife;

import com.olexyn.about.java.spring.demo.beanlife.beans.JavaHookBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

    @Bean
    public JavaHookBean someBeanJavaJava() {
        var bean = new JavaHookBean();
        bean.setDescription("Java-Java");
        return bean;
    }

}
