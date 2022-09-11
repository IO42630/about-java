package com.olexyn.about.java.spring.boot.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true) /* true ~ false CGLIB proxy, false ~ use JDK proxy if iface exists. */
/* optional in Boot, unless param  desired. */
public class AopDemo {

    public static void main(String[] args) {
        SpringApplication.run(AopDemo.class, args);
    }

}
