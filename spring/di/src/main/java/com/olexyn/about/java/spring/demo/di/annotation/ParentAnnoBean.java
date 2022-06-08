package com.olexyn.about.java.spring.demo.di.annotation;

import com.olexyn.about.java.spring.demo.di.java.NestedJavaBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("cParentBean") /* name opt, since no conflict */
public class ParentAnnoBean {

    @Autowired /* Field DI */
    @Qualifier("nestedAnnoBean") /* matches @Component("name") of NestedAnnoBean. */
    private NestedAnnoBean nestedBeanFDI;

    private NestedAnnoBean nestedBeanCDI;

    private NestedAnnoBean nestedBeanSDI;

    @Autowired /* @Autowired opt, since only 1 constructor */
    public ParentAnnoBean(NestedAnnoBean nestedBeanCDI) {
        this.nestedBeanCDI = nestedBeanCDI;
    }

    @Autowired
    public void setNestedBeanSDI(NestedAnnoBean nestedBeanSDI) {
        this.nestedBeanSDI = nestedBeanSDI;
    }

    @Autowired(required = false)
    MissingBean missingBean;

    @Autowired /* 2nd way to handle missing beans */
        Optional<MissingBean> missingBean2;

    /**
     * @Autowire an @Bean.
     * @Qualifier matches @Bean method name.
     * Requires @Import(AppJavaConfig.class).
     */
    @Autowired
    @Qualifier("nestedJavaBean")
    NestedJavaBean nestedJavaBean;

    @Autowired
    @Qualifier("nestedJavaBean3x")
    NestedJavaBean nestedJavaBean3;

}
