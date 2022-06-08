package com.olexyn.about.java.spring.demo.di;


import com.olexyn.about.java.spring.demo.di.annotation.AppAnnoConfig;
import com.olexyn.about.java.spring.demo.di.annotation.ParentAnnoBean;
import com.olexyn.about.java.spring.demo.di.java.AppJavaConfig;
import com.olexyn.about.java.spring.demo.di.java.LiteBeanConfig;
import com.olexyn.about.java.spring.demo.di.java.NestedJavaBean;
import com.olexyn.about.java.spring.demo.di.java.ParentJavaBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DiDemo {
    public static void main(String[] args) {
        // var xContext = new FileSystemXmlApplicationContext("C:\\Users\\user\\home\\ws\\about-java\\spring\\demo\\di\\src\\main\\resources\\beans.xml");
        // equiv
        var aContext = new ClassPathXmlApplicationContext("beans.xml");
        var aBean = aContext.getBean("aParentBean");
        aContext.close();


        var bContext = new AnnotationConfigApplicationContext(AppJavaConfig.class);
        var bBean = bContext.getBean(ParentJavaBean.class);
        var nestedJavaBeanPrimary = bContext.getBean(NestedJavaBean.class);
        var nestedJavaBean2x = bContext.getBean("nestedJavaBean2x");
        bContext.close();

        var liteContext = new AnnotationConfigApplicationContext(LiteBeanConfig.class);
        var liteBean = liteContext.getBean("liteBean");
        liteContext.close();

        var annoCtx = new AnnotationConfigApplicationContext(AppAnnoConfig.class);
        var annoParent = annoCtx.getBean(ParentAnnoBean.class);
        annoCtx.close();
    }
}
