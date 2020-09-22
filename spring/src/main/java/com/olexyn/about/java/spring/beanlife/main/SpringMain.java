package com.olexyn.about.java.spring.beanlife.main;

import com.olexyn.about.java.spring.beanlife.service.MyEmployeeService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.olexyn.about.java.spring.beanlife.service.EmployeeService;
import com.olexyn.about.java.spring.beanlife.service.MyEmployeeService;

public class SpringMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

		System.out.println("Spring Context initialized");

		MyEmployeeService service = ctx.getBean("myEmployeeService", MyEmployeeService.class);
		//EmployeeService service = ctx.getBean("employeeService", EmployeeService.class);

		System.out.println("Bean retrieved from Spring Context");

		System.out.println("Employee Name="+service.getEmployee().getName());

		ctx.close();
		System.out.println("Spring Context Closed");
	}

}
