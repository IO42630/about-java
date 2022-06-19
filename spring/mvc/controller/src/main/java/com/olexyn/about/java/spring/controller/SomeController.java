package com.olexyn.about.java.spring.controller;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class SomeController implements ServletContextAware {

    private ServletContext servletContext;

    @GetMapping("/empty")
    @ResponseBody
    public String getFruit() {
        return "EMPTY";
    }

    @GetMapping("/")
    public String getFruitd() {
        return "index";
    }

    @GetMapping(value = "/show")
    public ModelAndView show() {

        var mav = new ModelAndView();

        var now = LocalDateTime.now();
        var formatter = DateTimeFormatter.ISO_DATE_TIME;
        var dateTimeFormatted = formatter.format(now);

        mav.addObject("now", dateTimeFormatted);
        mav.setViewName("show");

        return mav;
    }

    @Override
    public void setServletContext(@NotNull ServletContext servletContext) {
        this.servletContext = servletContext;
    }

}
