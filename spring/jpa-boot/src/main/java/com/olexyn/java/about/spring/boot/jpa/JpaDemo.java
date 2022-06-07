package com.olexyn.java.about.spring.boot.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class JpaDemo {



    public static void main(String... args) {
        var ctx = SpringApplication.run(JpaDemo.class, args);
        var result = ctx.getBean(FruitRepo.class).findAll();
        int br = 0;
        ctx.getBean(FruitService.class).foo();
        ctx.close();
    }

}
