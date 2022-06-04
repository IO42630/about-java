package com.olexyn.about.java.spring.demo.di.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("cParentBean")
public class CParentBean {

    @Autowired
    private CNestedBean nestedBeanFDI; // Field DI

    private CNestedBean nestedBeanCDI;

    private CNestedBean nestedBeanSDI;

    @Autowired
    public CParentBean(CNestedBean nestedBeanCDI) {
        this.nestedBeanCDI = nestedBeanCDI;
    }

    @Autowired
    public void setNestedBeanSDI(CNestedBean nestedBeanSDI) {
        this.nestedBeanSDI = nestedBeanSDI;
    }

}
