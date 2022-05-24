package com.olexyn.about.java.spring.endpoint;

import com.olexyn.about.java.spring.model.GreetingDto;
import com.olexyn.about.java.spring.repo.FruitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingEndpoint {

    @Autowired
    FruitRepo globalRepo;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public GreetingDto greeting(@RequestParam(value = "name", defaultValue = "World") String name) {

        var foo = globalRepo.getById(1L);
        var bar = foo.getName();
        return new GreetingDto(counter.incrementAndGet(), String.format(template, name));
    }
}
