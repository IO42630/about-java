package com.olexyn.about.java.spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Computer {

    @PostConstruct
    public void turnOn(){
        System.out.println("Load operating system");
    }

    @PreDestroy
    public void turnOff(){
        System.out.println("Close all programs");
    }
}
