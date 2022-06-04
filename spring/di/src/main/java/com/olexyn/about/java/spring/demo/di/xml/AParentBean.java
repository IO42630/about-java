package com.olexyn.about.java.spring.demo.di.xml;

import org.springframework.beans.factory.annotation.Required;

public class AParentBean {

    private ANestedBean aNestedBeanSDI;
    private ANestedBean aNestedBeanCDI;

    /**
     * Constructor Based DI
     */
    AParentBean(ANestedBean aNestedBeanCDI) {
        this.aNestedBeanCDI = aNestedBeanCDI;
    }

    /**
     * Setter Based DI
     * method name 'aNestedBeanSDI' must match beans.xml/property/name
     */
    @Required
    public void setaNestedBeanSDI(ANestedBean aNestedBeanSDI) {
        this.aNestedBeanSDI = aNestedBeanSDI;
    }

}
