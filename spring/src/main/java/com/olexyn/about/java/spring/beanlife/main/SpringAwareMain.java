package com.olexyn.about.java.spring.beanlife.main;

import com.olexyn.about.java.spring.beanlife.service.MyAwareService;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringAwareMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-aware.xml");

		ctx.getBean("myAwareService", MyAwareService.class);

		ctx.close();
	}

}
