package com.olexyn.about.java.spring.empty;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmptyController {

    @GetMapping({"/"})
    public String getEmpty() {
        return "EMPTY";
    }

}
