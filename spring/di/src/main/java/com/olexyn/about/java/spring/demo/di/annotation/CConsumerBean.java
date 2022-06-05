package com.olexyn.about.java.spring.demo.di.annotation;

import com.olexyn.about.java.spring.demo.di.java.BNestedBean;
import com.olexyn.about.java.spring.demo.di.java.BParentBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class CConsumerBean {

    /**
     * @Qualifier("name") matches @Component("name") of CParentBean.
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

    @Autowired(required = false)
    MissingBean missingBean;

    /* 2nd way to handle missing beans */
    @Autowired
    Optional<MissingBean> missingBean2;

    @Autowired
    @Qualifier("bNestedBean3x")
    BNestedBean bNestedBean3;

}
