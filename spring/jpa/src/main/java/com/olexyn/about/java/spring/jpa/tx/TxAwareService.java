package com.olexyn.about.java.spring.jpa.tx;

import com.olexyn.about.java.spring.jpa.jdbc.template.FruitTemplateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TxAwareService {

    FruitTemplateRepo repo;

    public TxAwareService(FruitTxTemplateRepo repo) {
        this.repo = repo;
    }

    //@Transactional
    public void getFoo() {
        var entity = repo.findAll().get(0);
        entity.setColor("red");
        repo.save(entity);
        throw new RuntimeException();
    }
}
