package com.olexyn.about.java.spring.demo.war;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WarController {

    @GetMapping({"/"})
    public String getFoo() {
        return "EMPTY";
    }

}
