package com.olexyn.about.java.spring.demo.di.java;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppJavaConfig {

    @Bean
    public ParentJavaBean parentJavaBean() {
        var bean = new ParentJavaBean();
        bean.setNestedBean(nestedJavaBean());
        // better to call constructor, since nestedJavaBean() can only be resolved within the same @Configuration file.
        bean.setNestedBean(new NestedJavaBean());
        return bean;
    }

    /**
     * Spring will intercept calls to this method and return a bean (same bean if singleton)
     */
    @Bean
    @Primary /* default BNestedBean to be called */
    public NestedJavaBean nestedJavaBean() {
        return new NestedJavaBean("BNestedBean_PAYLOAD_PRIMARY");
    }

    @Bean(name = "nestedJavaBean2x") /* might override `name` like this */
    public NestedJavaBean nestedJavaBean2() {
        return new NestedJavaBean("BNestedBean_PAYLOAD_2X");
    }

    @Bean(name = {"foo", "bar"}) /* may define multiple names*/
    @Qualifier("nestedJavaBean3x")
    /* cannot be used with bContext.getBean("nestedJavaBean3x")
     * for @Autowire usage from CConsumerBean only. */
    public NestedJavaBean nestedJavaBean3() {
        return new NestedJavaBean("BNestedBean_PAYLOAD_3X");
    }

}
