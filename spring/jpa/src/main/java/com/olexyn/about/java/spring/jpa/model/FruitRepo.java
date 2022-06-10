package com.olexyn.about.java.spring.jpa.model;

import java.util.List;

public interface FruitRepo {

    FruitEntity save(FruitEntity entity);

    List<FruitEntity> findAll();

    FruitEntity getById(int id);

    FruitEntity update(FruitEntity entity);

    boolean deleteById(int id);

}


