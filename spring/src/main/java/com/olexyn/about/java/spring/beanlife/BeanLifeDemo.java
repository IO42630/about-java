package com.olexyn.about.java.spring.beanlife;

import com.olexyn.about.java.spring.beanlife.service.AService;
import com.olexyn.about.java.spring.beanlife.service.BService;
import com.olexyn.about.java.spring.beanlife.service.CService;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * ABOUT:
 * Shows how we can config/init a Service/nested Obj from XML.
 */
public class BeanLifeDemo {

    public static void main(String[] args) {

        var aContext = new ClassPathXmlApplicationContext("a-service.xml");
        var aService = aContext.getBean("aService", AService.class);
        var employee = aService.getEmployee();
        aContext.close();

        var bContext = new ClassPathXmlApplicationContext("b-service.xml");
        var bService = bContext.getBean("bService", BService.class);
        bContext.close();

        var cContext = new ClassPathXmlApplicationContext("c-service.xml");
        var cService = cContext.getBean("cService", CService.class);
        cContext.close();
    }



}
