package com.olexyn.java.about.spring.boot.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaDemo {



    public static void main(String... args) {
        var ctx = SpringApplication.run(JpaDemo.class, args);
        var result = ctx.getBean(FruitRepo.class).findAll();
        int br = 0;
    }

}
