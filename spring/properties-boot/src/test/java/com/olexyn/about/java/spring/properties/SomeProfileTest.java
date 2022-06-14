package com.olexyn.about.java.spring.properties;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@TestPropertySource("classpath:application-some-profile.properties") /* afaik there is no wildcard for this, it is just canonical. */
@ActiveProfiles("some-profile")
public class SomeProfileTest {

    @Value("${some.property}")
    private String someProperty;

    @Test
    public void someTest2() {
        Assert.assertEquals("valueProfile", someProperty);
    }

}
