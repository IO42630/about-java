package com.olexyn.java.about.spring.boot.jpa;

import com.olexyn.java.about.spring.boot.jpa.model.FruitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FruitRepoJava extends JpaRepository<FruitEntity, Long> {



    List<FruitEntity> findByName(String name);

    /**
     * Native SQL
     */
    @Query(value = "select * from fruit x", nativeQuery = true)
    List<FruitEntity> findAllQueryNative();

    /**
     * JPQL
     */
    @Query("select x from FruitEntity x")
    List<FruitEntity> findAllQueryJpql();

    FruitEntity findFirstByName(String name);

}
