package com.olexyn.about.java.spring.boot.controller.endpoint;

import com.olexyn.about.java.spring.boot.controller.FruitRepo;
import com.olexyn.about.java.spring.boot.controller.MapperService;
import com.olexyn.about.java.spring.boot.controller.model.FruitDto;
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
public class FruitEndpoint {

    @Autowired
    FruitRepo globalRepo;

    @Autowired
    MapperService mapperService;

    @GetMapping("/fruitParam")
    public FruitDto getFruit(@RequestParam(value = "name", defaultValue = "orange") String name) {
        return getFruitInternal(name);
    }

    @GetMapping(value = "fruitPathShort/{name}")
    public FruitDto getFruitPathShort(@PathVariable String name) {
        return getFruitInternal(name);
    }

    @GetMapping(value = "fruitNoParam")
    public FruitDto getFruitNoParam(HttpServletRequest request) {
        return getFruitInternal(request.getParameter("name"));
    }

    @RequestMapping(value = "fruitPath/{name}", method = RequestMethod.GET, produces = "application/json")
    public FruitDto getFruitPath(@PathVariable String name) {
        return getFruitInternal(name);
    }




    private FruitDto getFruitInternal(String name) {
        var entities = globalRepo.findByName(name);
        if (entities.isEmpty()) { return new FruitDto(); }
        return mapperService.map(entities.get(0), FruitDto.class);
    }



}
