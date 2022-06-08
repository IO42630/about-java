package com.olexyn.about.java.spring.jpa;

import com.olexyn.about.java.spring.jpa.jdbc.template.JdbcTemplateConfig;
import com.olexyn.about.java.spring.jpa.tx.TxConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Import({DataSourceConfig.class, JdbcTemplateConfig.class, TxConfig.class})
public class AppConfig {
}
