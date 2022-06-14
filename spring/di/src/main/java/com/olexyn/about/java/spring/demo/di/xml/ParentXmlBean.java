package com.olexyn.about.java.spring.demo.di.xml;

import org.springframework.beans.factory.annotation.Required;

public class ParentXmlBean {

    private NestedXmlBean aNestedBeanSDI;
    private NestedXmlBean aNestedBeanCDI;

    /**
     * Constructor Based DI
     */
    ParentXmlBean(NestedXmlBean aNestedBeanCDI) {
        this.aNestedBeanCDI = aNestedBeanCDI;
    }

    /**
     * Setter Based DI
     * method name 'aNestedBeanSDI' must match beans.xml/property/name
     */
    @Required /* must be supplied via xml at configuration time. */
    public void setaNestedBeanSDI(NestedXmlBean aNestedBeanSDI) {
        this.aNestedBeanSDI = aNestedBeanSDI;
    }

}
