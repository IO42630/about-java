package com.olexyn.about.java.spring.demo.profiles;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProfilesDemo {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);
        var someBeanDev = context.getBean(SomeBean.class);
        context.close();
    }

}
