package com.olexyn.about.java.spring.beanlife.bean;

public class Employee {

	Employee() {
		System.out.println("Employee()");
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
