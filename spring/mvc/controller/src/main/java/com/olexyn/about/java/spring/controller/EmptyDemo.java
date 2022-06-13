package com.olexyn.about.java.spring.controller;

import com.olexyn.about.java.spring.controller.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmptyDemo {
    public static void main(String[] args) {
        var appContext = new AnnotationConfigApplicationContext(AppConfig.class);
        appContext.close();
    }
}
