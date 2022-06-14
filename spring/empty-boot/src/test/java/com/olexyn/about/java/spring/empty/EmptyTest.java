package com.olexyn.about.java.spring.empty;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class EmptyTest {

    @Test
    public void smoke() {
        var app = SpringApplication.run(EmptyDemo.class);
        var empty = app.getBean(EmptyController.class).getEmpty();
        Assert.assertEquals("EMPTY", empty);
    }

}
