package com.olexyn.about.java.spring.demo.di.java;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BAppConfig {

    @Bean
    public BParentBean bParentBean() {
        var bean = new BParentBean();
        bean.setNestedBean(bNestedBean());
        // better to call constructor, since bNestedBean() can only be resolved within the same @Configuration file.
        bean.setNestedBean(new BNestedBean());
        return bean;
    }

    /**
     * Spring will intercept calls to this method and return a bean (same bean if singleton)
     */
    @Bean
    @Primary /* default BNestedBean to be called */
    public BNestedBean bNestedBean() {
        return new BNestedBean("BNestedBean_PAYLOAD_PRIMARY");
    }

    @Bean(name = "bNestedBean2x") /* might override `name` like this */
    public BNestedBean bNestedBean2() {
        return new BNestedBean("BNestedBean_PAYLOAD_2X");
    }

    @Bean
    @Qualifier("bNestedBean3x")
    /* cannot be used with bContext.getBean("bNestedBean3x")
     * for @Autowire usage from CConsumerBean only. */
    public BNestedBean bNestedBean3() {
        return new BNestedBean("BNestedBean_PAYLOAD_3X");
    }

}
