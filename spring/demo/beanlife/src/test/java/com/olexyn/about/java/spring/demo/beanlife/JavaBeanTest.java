package com.olexyn.about.java.spring.demo.beanlife;

import com.olexyn.about.java.spring.demo.beanlife.beans.JavaHookBean;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Test for java bean config.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {JavaConfig.class})
public class JavaBeanTest {

    @Test
    public void someTest() {
        var javaJavaContext = new AnnotationConfigApplicationContext(JavaConfig.class);
        var bean = javaJavaContext.getBean("someBeanJavaJava", JavaHookBean.class);
        javaJavaContext.close();
        Assert.assertEquals(bean.getDescription(), "Java-Java");
    }

}
