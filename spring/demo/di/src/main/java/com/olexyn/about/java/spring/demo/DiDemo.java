package com.olexyn.about.java.spring.demo;


import com.olexyn.about.java.spring.demo.di.auto.CAppConfig;
import com.olexyn.about.java.spring.demo.di.auto.CConsumerBean;
import com.olexyn.about.java.spring.demo.di.java.BAppConfig;
import com.olexyn.about.java.spring.demo.di.java.BParentBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DiDemo {
    public static void main(String[] args) {
        var aContext = new ClassPathXmlApplicationContext("beans.xml");
        var aBean = aContext.getBean("aParentBean");
        // TODO fix this if time
        aContext.close();


        var bContext = new AnnotationConfigApplicationContext(BAppConfig.class);
        var bBean = bContext.getBean(BParentBean.class);
        bContext.close();

        var cContext = new AnnotationConfigApplicationContext(CAppConfig.class);
        var cConsumerBean = cContext.getBean(CConsumerBean.class);
        cContext.close();
    }
}
