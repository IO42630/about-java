package com.olexyn.about.java.spring.controller;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
public class SomeControllerTest {

    private SomeController someController;
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext; // TODO

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders
            .standaloneSetup(someController)
            .build();

        MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


}
