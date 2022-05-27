package com.olexyn.about.java.spring.demo.di.auto;

import com.olexyn.about.java.spring.demo.di.java.BAppConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.olexyn.about.java.spring.demo.di.auto")
@Import(BAppConfig.class)
public class CAppConfig {

}
