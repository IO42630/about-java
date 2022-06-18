package com.olexyn.java.about.spring.boot.jpa;

import com.olexyn.java.about.spring.boot.jpa.model.FruitEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static com.olexyn.java.about.spring.boot.jpa.TestConstants.COLOR;
import static com.olexyn.java.about.spring.boot.jpa.TestConstants.NAME;

/**
 * TestConfiguration -> create a context with selected Beans.
 * Autowire them.
 * Mock Persistence.
 * Test.
 */
@RunWith(SpringRunner.class)
public class FruitServiceTest {

    @TestConfiguration
    static class FruitServiceTestConfiguration {

        @Bean
        public FruitService fruitController() {
            return new FruitService();
        }
    }

    @Autowired
    private FruitService fruitService;

    @MockBean
    private FruitRepoJava fruitRepo;

    @Before
    public void before() {
        FruitEntity fruit = new FruitEntity();
        fruit.setName(NAME);
        fruit.setColor(COLOR);
        Mockito.when(fruitRepo.findFirstByName(fruit.getName()))
            .thenReturn(fruit);
    }

    @Test
    public void test1() {
        Assert.assertEquals(NAME, fruitService.findFirstByName(NAME).getName());
    }

}
