package com.olexyn.about.java.spring.demo.profiles;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
@ContextConfiguration(classes = {AppConfig.class})
public class ProfilesDemoTest {

    @Test
    public void someTest() {
        // TODO why does this not work?
        var context = new AnnotationConfigApplicationContext(AppConfig.class);
        var someBeanDev = context.getBean(SomeBean.class);
        context.close();
    }
}
