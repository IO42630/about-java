package com.olexyn.about.java.spring.demo.beanlife.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Arrays;

public class CService implements ApplicationContextAware,
    ApplicationEventPublisherAware, BeanClassLoaderAware, BeanFactoryAware,
    BeanNameAware, EnvironmentAware, ImportAware, ResourceLoaderAware {

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        System.out.println("CService.setApplicationContext() " + Arrays.toString(ctx.getBeanDefinitionNames()));
    }

    @Override
    public void setBeanName(@NotNull String beanName) {
        System.out.println("CService.setBeanName() " + beanName);
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("CService.setBeanClassLoader() " + classLoader.getClass().getName());
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println("CService.setResourceLoader() " + resourceLoader.getResource("classpath:spring.xml").getFilename());
    }

    @Override
    public void setImportMetadata(@NotNull AnnotationMetadata annotationMetadata) {
        System.out.println("setImportMetadata called");
    }

    @Override
    public void setEnvironment(@NotNull Environment env) {
        System.out.println("setEnvironment called");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory called");
        System.out.println("setBeanFactory:: employee bean singleton="
            + beanFactory.isSingleton("employee"));
    }

    @Override
    public void setApplicationEventPublisher(@NotNull ApplicationEventPublisher applicationEventPublisher) {
        System.out.println("setApplicationEventPublisher called");
    }

}
