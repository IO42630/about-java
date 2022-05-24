package com.olexyn.about.java.spring.repo;

import com.olexyn.about.java.spring.model.FruitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FruitRepo extends JpaRepository<FruitEntity, Long> {
}
