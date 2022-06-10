package com.olexyn.about.java.spring.jpa;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan({"com.olexyn.about.java.spring.jpa", "com.olexyn.about.java.spring.jpa.tx"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {
}
