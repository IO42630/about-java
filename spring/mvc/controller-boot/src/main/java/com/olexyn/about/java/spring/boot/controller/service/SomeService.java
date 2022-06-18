package com.olexyn.about.java.spring.boot.controller.service;


import com.olexyn.about.java.spring.boot.controller.model.FruitDto;
import org.springframework.stereotype.Service;

@Service
public class SomeService {

    public FruitDto fetchApple() {
        var dto = new FruitDto();
        dto.setPk(0L);
        dto.setName("apple");
        dto.setColor("green");
        return dto;
    }

}
