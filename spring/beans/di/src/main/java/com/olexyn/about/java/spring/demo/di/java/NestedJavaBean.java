package com.olexyn.about.java.spring.demo.di.java;

/**
 * @Qualifier("name") on Bean class does nothing.
 * Must use @Component("name") && Annotation style config.
 */
public class NestedJavaBean {

    public NestedJavaBean() { }

    public NestedJavaBean(String payload) {
        this.payload = payload;
    }

    public String payload = "BNestedBean_PAYLOAD";

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

}


