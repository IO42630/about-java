package com.olexyn.about.java.spring.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.io.File;
import java.io.IOException;

@Configuration
@EnableWebMvc /* enables MVC Java config, requires @Configuration */
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public FreeMarkerViewResolver freemarkerViewResolver() {
        var resolver = new FreeMarkerViewResolver();
        resolver.setCache(true);
        resolver.setSuffix(".ftl");
        return resolver;
    }

    @Bean
    public FreeMarkerConfigurer freemarkerConfig() throws IOException {
        var freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.getConfiguration().setDirectoryForTemplateLoading(new File("classpath:/templates/"));
        return freeMarkerConfigurer;
    }

}
