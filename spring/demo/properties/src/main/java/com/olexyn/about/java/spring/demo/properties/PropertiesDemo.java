package com.olexyn.about.java.spring.demo.properties;

import com.olexyn.about.java.spring.demo.properties.beans.ConfiguredBean;
import com.olexyn.about.java.spring.demo.properties.service.BeanConsumerService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PropertiesDemo {
    public static void main(String[] args) {
        var appContext = new AnnotationConfigApplicationContext(AppConfig.class);

        var envConfBean = appContext.getBean("envConfBean", ConfiguredBean.class); // seems to match method name in AppConfig
        var valueConfBean = appContext.getBean("valueConfBean", ConfiguredBean.class);

        System.out.println(envConfBean.getProperty() + " " + envConfBean.getHiddenProperty());
        System.out.println(valueConfBean.getProperty() + " " + valueConfBean.getHiddenProperty());

        var service = appContext.getBean(BeanConsumerService.class);
        System.out.println(service.getProperty() + " " + service.getHiddenProperty());

        appContext.close();
    }
}
