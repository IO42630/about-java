package com.olexyn.about.java.spring.demo.beanlife.beans;

public class Employee {

    public Employee() {
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
