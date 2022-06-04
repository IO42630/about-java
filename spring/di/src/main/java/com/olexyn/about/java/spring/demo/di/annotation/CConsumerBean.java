package com.olexyn.about.java.spring.demo.di.annotation;

import com.olexyn.about.java.spring.demo.di.java.BParentBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class CConsumerBean {

    /**
     * \@Qualifier matches @Component(qualifier) of CParentBean.
     */
    @Autowired
    @Qualifier("cParentBean")
    CParentBean cParentBean;

    /**
     * This is a special case, it shows how to 'autowire' a 'java' configured bean.
     * \@Qualifier matches the @Bean method name in class with @Configuration.
     * To enable this @Import(BAppConfig) is used in CAppConfig.
     */
    @Autowired
    @Qualifier("bParentBean")
    BParentBean bParentBean;

}
