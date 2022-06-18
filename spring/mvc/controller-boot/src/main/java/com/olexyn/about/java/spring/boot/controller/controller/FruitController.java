package com.olexyn.about.java.spring.boot.controller.controller;

import com.olexyn.about.java.spring.boot.controller.model.FruitDto;
import com.olexyn.about.java.spring.boot.controller.model.FruitEntity;
import com.olexyn.about.java.spring.boot.controller.service.MapperService;
import com.olexyn.about.java.spring.boot.controller.service.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("fruit")
public class FruitController {

    @Autowired
    MapperService mapperService;

    @Autowired
    SomeService someService;

    @GetMapping("/fruitParam")
    public FruitDto getFruit(@RequestParam(value = "name", defaultValue = "orange") String name) {
        return map(name);
    }

    @GetMapping(value = "fruitPathShort/{name}")
    public FruitDto getFruitPathShort(@PathVariable String name) {
        return map(name);
    }

    @GetMapping(value = "fruitNoParam")
    public FruitDto getFruitNoParam(HttpServletRequest request) {
        return someService.fetchApple();
    }

    @RequestMapping(value = "fruitPath/{name}", method = RequestMethod.GET, produces = "application/json")
    public FruitDto getFruitPath(@PathVariable String name) {
        return map(name);
    }



    private FruitDto map(String name) {
        var entity = new FruitEntity();
        entity.setPk(0L);
        entity.setName("apple");
        entity.setColor("green");
        return mapperService.map(entity, FruitDto.class);
    }

}
