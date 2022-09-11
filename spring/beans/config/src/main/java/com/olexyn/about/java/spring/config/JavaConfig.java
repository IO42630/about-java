package com.olexyn.about.java.spring.config;

import com.olexyn.about.java.spring.config.beans.JavaHookBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

    @Bean(destroyMethod = "destroy") /* can specify destroyMethod here, thus could omit @PreDestroy */
    public JavaHookBean someBeanJavaJava() {
        var bean = new JavaHookBean();
        bean.setDescription("Java-Java");
        return bean;
    }

}
