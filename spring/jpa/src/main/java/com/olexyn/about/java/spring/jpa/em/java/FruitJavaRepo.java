package com.olexyn.about.java.spring.jpa.em.java;

import com.olexyn.about.java.spring.jpa.model.FruitEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Repository
public class FruitJavaRepo {

    private final EntityManager em;

    @Autowired
    public FruitJavaRepo(@Qualifier("cemf") EntityManagerFactory cemf) {
        this.em = cemf.createEntityManager();
    }

    public FruitEntity save(FruitEntity entity) {
        em.persist(entity);
        return em.find(FruitEntity.class, entity.getPk());
    }

}
