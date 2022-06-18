package com.olexyn.java.about.spring.boot.jpa;

import com.olexyn.java.about.spring.boot.jpa.model.FruitEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static com.olexyn.java.about.spring.boot.jpa.TestConstants.COLOR;
import static com.olexyn.java.about.spring.boot.jpa.TestConstants.NAME;

/**
 * Requires H2 dependency.
 * `create-drop` because with tests we actually want to re-create the DB schema.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource(properties = {
    "spring.jpa.hibernate.ddl-auto=create-drop"
})
public class FruitRepoTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private FruitRepoJava fruitRepo;

    @Before
    public void before() {
        FruitEntity fruit = new FruitEntity();
        fruit.setName(NAME);
        fruit.setColor(COLOR);
        entityManager.persist(fruit);
        entityManager.flush();
    }

    @Test
    public void test2() {
        Assert.assertEquals(NAME, fruitRepo.findFirstByName(NAME).getName());
    }

}
