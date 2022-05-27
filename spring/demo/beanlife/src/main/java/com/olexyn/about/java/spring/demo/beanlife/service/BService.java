package com.olexyn.about.java.spring.demo.beanlife.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class BService {

    @PostConstruct
    public void init() {
        System.out.println("BService.init()");
    }

    public BService() {
        System.out.println("BService()");
    }

    @PreDestroy
    public void destory() {
        System.out.println("BService.destroy()");
    }

}
