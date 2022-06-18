package com.olexyn.about.java.spring.boot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.olexyn.about.java.spring.boot.controller.controller.FruitController;
import com.olexyn.about.java.spring.boot.controller.model.FruitDto;
import com.olexyn.about.java.spring.boot.controller.service.MapperService;
import com.olexyn.about.java.spring.boot.controller.service.SomeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@RunWith(SpringRunner.class)
@WebMvcTest(FruitController.class)
public class FruitControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private MapperService mapperService; // required because @Autowired in FruitController

    @MockBean
    private SomeService someService;

    @Test
    public void test3() throws Exception {
        var dto = new FruitDto()
            .setPk(0L)
            .setName("apple")
            .setColor("green");
        given(someService.fetchApple()).willReturn(dto);

        var result = mvc.perform(get("/fruit/fruitNoParam")
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse()
            .getContentAsString();
        var dto2 = new ObjectMapper().readValue(result, FruitDto.class);
        Assert.assertEquals(dto, dto2);
    }
    
}
