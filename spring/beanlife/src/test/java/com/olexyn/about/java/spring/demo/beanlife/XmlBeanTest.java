package com.olexyn.about.java.spring.demo.beanlife;

import com.olexyn.about.java.spring.demo.beanlife.beans.AnnotationHookBean;
import com.olexyn.about.java.spring.demo.beanlife.beans.JavaHookBean;
import com.olexyn.about.java.spring.demo.beanlife.beans.XmlHookBean;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Tests for xml bean config.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"/a-service.xml"})
public class XmlBeanTest {

    @Test
    public void xmlXmlTest() {
        var xmlXmlContext = new ClassPathXmlApplicationContext("a-service.xml");
        var bean = xmlXmlContext.getBean("someBeanXmlXml", XmlHookBean.class);
        xmlXmlContext.close();
        Assert.assertEquals(bean.getDescription(), "XML-XML");
    }

    @Test
    public void xmlJavaTest() {
        var xmlJavaContext = new ClassPathXmlApplicationContext("b-service.xml");
        var bean = xmlJavaContext.getBean("someBeanXmlJava", JavaHookBean.class);
        xmlJavaContext.close();
        Assert.assertEquals(bean.getDescription(), "XML-Java");
    }

    @Test
    public void xmlAnnotationTest() {
        var xmlAnnotationContext = new ClassPathXmlApplicationContext("c-service.xml");
        var bean = xmlAnnotationContext.getBean("someBeanXmlAnnotation", AnnotationHookBean.class);
        xmlAnnotationContext.close();
        Assert.assertEquals(bean.getDescription(), "XML-Annotation");
    }

}
