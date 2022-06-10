package com.olexyn.java.about.spring.boot.jpa;

import com.olexyn.java.about.spring.boot.jpa.model.FruitEntity;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

@RepositoryDefinition(domainClass = FruitEntity.class, idClass = Long.class)
public interface FruitRepoAnno {

    List<FruitEntity> findByName(String name);

}
