package com.olexyn.about.java.spring.empty;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmptyDemo {
    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(AppConfig.class);
    }
}
