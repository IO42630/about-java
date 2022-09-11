package com.olexyn.about.java.spring.config.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class JavaHookBean extends AbstractHookBean {

    public JavaHookBean() { echo(); }

    @PostConstruct
    public void init() { echo(); }

    @PreDestroy
    public void destroy() { echo(); }

}
