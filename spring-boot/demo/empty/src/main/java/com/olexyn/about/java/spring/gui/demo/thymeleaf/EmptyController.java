package com.olexyn.about.java.spring.gui.demo.thymeleaf;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmptyController {

    @GetMapping({"/"})
    public String getFoo(Model model) {
        return "EMPTY";
    }

}
