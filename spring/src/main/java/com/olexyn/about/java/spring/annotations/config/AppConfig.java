package com.olexyn.about.java.spring.annotations.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.olexyn.about.java.spring.annotations.drivers.DataBaseDriver;
import com.olexyn.about.java.spring.annotations.drivers.MySqlDriver;
import com.olexyn.about.java.spring.annotations.drivers.OracleDriver;

/*
WHAT IT DOES
@Configuration : this is a config file.
@ComponentScan : scan there for components.
@PropertySource : scan that file for properties - classpath is defined in <resources> of pom.xml
@Autowired : get Environment from IoCC - this probably polls the above - thus we can call .getProperty("foo") through it.
setDriver : the setters are standard as part of a SpringBean (special JavaBean).
 */

@Configuration
@ComponentScan("com.olexyn.about.java.spring.annotations")
@PropertySource("classpath:oracledatabase.properties")
public class AppConfig {

	@Autowired
    Environment environment;

	@Bean
	DataBaseDriver oracleDriver() {
		OracleDriver oracleDriver = new OracleDriver();
		oracleDriver.setDriver(environment.getProperty("db.driver"));
        oracleDriver.setUrl(environment.getProperty("db.url"));
        oracleDriver.setPort(Integer.parseInt(environment.getProperty("db.port")));
        oracleDriver.setUser(environment.getProperty("db.user"));
        oracleDriver.setPassword(environment.getProperty("db.password"));

        return oracleDriver;

	}

	@Bean
	DataBaseDriver mysqlDriver() {
		return new MySqlDriver();
	}
}
