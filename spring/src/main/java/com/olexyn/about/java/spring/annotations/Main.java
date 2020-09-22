package com.olexyn.about.java.spring.annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.olexyn.about.java.spring.annotations.config.AppConfig;
import com.olexyn.about.java.spring.annotations.drivers.DataBaseDriver;
import com.olexyn.about.java.spring.annotations.service.UserService;

public class Main {
	public static void main(String[] args) {
		AbstractApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);

		DataBaseDriver oracle = appContext.getBean("oracleDriver", DataBaseDriver.class);
		DataBaseDriver mysql = appContext.getBean("mysqlDriver", DataBaseDriver.class);

        System.out.println("Oracle driver info:");
        System.out.println(oracle.getInfo());

        System.out.println("MySQL driver info:");
        System.out.println(mysql.getInfo());

        System.out.println("UserService Information");
		UserService userService = appContext.getBean(UserService.class);
		System.out.println(userService.getDriverInfo());

		appContext.close();
	}
}
