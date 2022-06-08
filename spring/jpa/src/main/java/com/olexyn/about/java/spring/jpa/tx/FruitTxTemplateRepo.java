package com.olexyn.about.java.spring.jpa.tx;

import com.olexyn.about.java.spring.jpa.jdbc.template.FruitTemplateRepo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FruitTxTemplateRepo extends FruitTemplateRepo {

    public FruitTxTemplateRepo( @Qualifier("txJdbcTemplate") JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

}
