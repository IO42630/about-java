package com.olexyn.about.java.spring.demo.di.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("cParentBean") /* name opt, since no conflict */
public class CParentBean {

    @Autowired /* Field DI */
    private CNestedBean nestedBeanFDI;

    private CNestedBean nestedBeanCDI;

    private CNestedBean nestedBeanSDI;

    @Autowired /* @Autowired opt, since only 1 constructor */
    public CParentBean(CNestedBean nestedBeanCDI) {
        this.nestedBeanCDI = nestedBeanCDI;
    }

    @Autowired
    public void setNestedBeanSDI(CNestedBean nestedBeanSDI) {
        this.nestedBeanSDI = nestedBeanSDI;
    }

}
