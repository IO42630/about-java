package com.olexyn.about.java.spring.endpoint;

import com.olexyn.about.java.spring.model.FruitDto;
import com.olexyn.about.java.spring.model.GreetingDto;
import com.olexyn.about.java.spring.repo.FruitRepo;
import com.olexyn.about.java.spring.util.MapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("fruit")
public class FruitEndpoint {

    @Autowired
    FruitRepo globalRepo;

    @Autowired
    MapperService mapperService;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public GreetingDto greeting(@RequestParam(value = "name", defaultValue = "World") String name) {

        var foo = globalRepo.getById(1L);

        var bar = foo.getName();
        return new GreetingDto(counter.incrementAndGet(), String.format(template, name));
    }


    @GetMapping("/fruitParam")
    public FruitDto getFruit(@RequestParam(value = "name", defaultValue = "orange") String name) {
        return getFruitInternal(name);
    }

    @GetMapping(value = "fruitPathShort/{name}")
    public FruitDto getFruitPathShort(@PathVariable String name) {
        return getFruitInternal(name);
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
