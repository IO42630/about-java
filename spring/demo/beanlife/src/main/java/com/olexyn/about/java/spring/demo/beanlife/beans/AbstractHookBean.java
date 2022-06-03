package com.olexyn.about.java.spring.demo.beanlife.beans;

public abstract class AbstractHookBean {

    private String description = "NOT INIT";

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    protected void echo() {
        var methodName = new Throwable().getStackTrace()[1].getMethodName();
        System.out.println(description + "." + methodName + "()");
    }

}
