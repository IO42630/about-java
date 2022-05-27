package com.olexyn.about.java.spring.demo.properties.service;

import com.olexyn.about.java.spring.demo.properties.beans.ConfiguredBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BeanConsumerService {

    @Autowired
    @Qualifier("envConfBean")
    private ConfiguredBean envConfBean;

    public String getProperty() {
        return envConfBean.getProperty();
    }

    public String getHiddenProperty() {
        return envConfBean.getHiddenProperty();
    }

}
