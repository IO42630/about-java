package com.olexyn.java.about.spring.boot.jpa;

import com.olexyn.java.about.spring.boot.jpa.model.FruitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FruitRepo extends JpaRepository<FruitEntity, Long> {



    List<FruitEntity> findByName(String name);
}
