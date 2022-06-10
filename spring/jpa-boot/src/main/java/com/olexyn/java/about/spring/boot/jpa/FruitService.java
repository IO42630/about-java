package com.olexyn.java.about.spring.boot.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FruitService {

    @Autowired
    FruitRepoJava fruitRepo;

    @Transactional
    public void foo() {
        var entity = fruitRepo.findAll().get(0);
        entity.setColor("red");
        fruitRepo.save(entity);
        throw new RuntimeException();
    }
}
