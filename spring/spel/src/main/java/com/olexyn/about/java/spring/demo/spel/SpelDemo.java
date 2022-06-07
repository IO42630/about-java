package com.olexyn.about.java.spring.demo.spel;

import com.olexyn.about.java.spring.demo.spel.beans.SpelBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpelDemo {
    public static void main(String[] args) {
        var appContext = new AnnotationConfigApplicationContext(AppConfig.class);
        var spelBean = appContext.getBean(SpelBean.class);
        appContext.close();
    }
}
