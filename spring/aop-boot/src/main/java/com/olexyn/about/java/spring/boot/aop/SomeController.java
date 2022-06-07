package com.olexyn.about.java.spring.boot.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SomeController {

	@Autowired
	private SomeService employeeService;

	@RequestMapping(value = "/concat", method = RequestMethod.GET)
	public String addEmployee() {

		return employeeService.concat("HELLO", "WORLD");

	}


}
