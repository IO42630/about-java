package com.olexyn.about.java.spring.demo.empty;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmptyDemo {
    public static void main(String[] args) {
        var appContext = new AnnotationConfigApplicationContext(AppConfig.class);
        appContext.close();
    }
}
