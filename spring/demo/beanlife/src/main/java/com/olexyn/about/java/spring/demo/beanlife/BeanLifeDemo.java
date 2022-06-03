package com.olexyn.about.java.spring.demo.beanlife;


import com.olexyn.about.java.spring.demo.beanlife.beans.AnnotationHookBean;
import com.olexyn.about.java.spring.demo.beanlife.beans.JavaHookBean;
import com.olexyn.about.java.spring.demo.beanlife.beans.XmlHookBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * ABOUT:
 * Shows how we can config/init a Service/nested Obj from XML.
 */
public class BeanLifeDemo {

    public static void main(String[] args) {

        var xmlXmlContext = new ClassPathXmlApplicationContext("a-service.xml");
        xmlXmlContext.getBean("someBeanXmlXml", XmlHookBean.class);
        xmlXmlContext.close();

        var xmlJavaContext = new ClassPathXmlApplicationContext("b-service.xml");
        xmlJavaContext.getBean("someBeanXmlJava", JavaHookBean.class);
        xmlJavaContext.close();

        var javaJavaContext = new AnnotationConfigApplicationContext(JavaConfig.class);
        javaJavaContext.getBean("someBeanJavaJava", JavaHookBean.class);
        javaJavaContext.close();

        var xmlAnnotationContext = new ClassPathXmlApplicationContext("c-service.xml");
        xmlAnnotationContext.getBean("someBeanXmlAnnotation", AnnotationHookBean.class);
        xmlAnnotationContext.close();
    }



}
