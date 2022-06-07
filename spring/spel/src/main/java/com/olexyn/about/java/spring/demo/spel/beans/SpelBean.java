package com.olexyn.about.java.spring.demo.spel.beans;

import org.springframework.beans.factory.annotation.Value;

public class SpelBean {

    @Value("#{123}")
    int a1;

    @Value("#{someBean}")
    SomeBean someBean;

    @Value("#{someBean.value}")
    String someBeanValue;

    @Value("#{someBean?.getValue() + ' world'}")
    String someBeanValue2;



    @Value("#{T(java.lang.Math).random() + 1}")
    double d1;

    @Value("#{null?.getValue() + ' world'}") /* "null world" */
        String test2;

    @Value("#{null?:' world'}") /* " world" */
        String someBeanValue3;

    @Value("#{someBean.values.?[length eq 3]}") /* "aaa" */
        String someBeanValue33;

}
