package com.olexyn.about.java.spring.properties;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@TestPropertySource("classpath:application.properties")
public class SomeTest {

    @MockBean
    private SomeBean someBean;

    @Value("${some.property}")
    private String someProperty;



    @Test
    public void someTest() {
        Assert.assertEquals("value", someProperty);
    }




}
