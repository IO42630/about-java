package com.olexyn.about.java.spring.gui.demo.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BazController {

    // Usually this would be done via 'session'. This is a demo quickfix.
    private static final List<String> MESSAGES = new ArrayList<>();


    @GetMapping({"/foo"})
    public String getFoo(Model model) {
        model.addAttribute("messages", MESSAGES); // 'attributes' are the properties that can be referenced within the template
        return "foo-template"; // returns the ' file name' of the template.html
    }

    @PostMapping("/foo-post")
    public String postFooRedirect(@RequestParam("message") String message) {
        MESSAGES.add(message);
        return "redirect:/foo"; // POST request usually redirect, instead of returning a template.
    }



    @GetMapping({"/bar"})
    public String getBar() {
        return "bar-template";
    }

}
