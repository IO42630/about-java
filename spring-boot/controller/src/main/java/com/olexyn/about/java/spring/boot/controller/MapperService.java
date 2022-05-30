package com.olexyn.about.java.spring.boot.controller;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

@Service
public class MapperService {

    private final DozerBeanMapper mapper = new DozerBeanMapper();

    public <T> T map(Object source, Class<T> dest) {
        return mapper.map(source, dest);
    }

}
