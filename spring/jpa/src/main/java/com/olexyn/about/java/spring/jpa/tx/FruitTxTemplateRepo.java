package com.olexyn.about.java.spring.jpa.tx;

import com.olexyn.about.java.spring.jpa.jdbc.template.FruitTemplateRepo;
import com.olexyn.about.java.spring.jpa.model.FruitEntity;
import com.olexyn.about.java.spring.jpa.model.FruitRepo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class FruitTxTemplateRepo extends FruitTemplateRepo implements FruitRepo {

    public FruitTxTemplateRepo(@Qualifier("txJdbcTemplate") JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    @Transactional
    public FruitEntity save(FruitEntity entity) {
        entity = super.save(entity);
        if (true) { throw new RuntimeException(); }
        return entity;
    }

    @Override
    @Transactional
    public FruitEntity update(FruitEntity entity) {
        entity = super.update(entity);
        if (true) { throw new RuntimeException(); }
        return entity;
    }

}
