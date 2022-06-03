package com.olexyn.about.java.spring.demo.beanlife.beans;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
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

public class AnnotationHookBean extends AbstractHookBean implements ApplicationContextAware,
    ApplicationEventPublisherAware, BeanClassLoaderAware, BeanFactoryAware,
    BeanNameAware, EnvironmentAware, ImportAware, ResourceLoaderAware, InitializingBean, DisposableBean, BeanPostProcessor {


    @Override
    public void setBeanName(@NotNull String beanName) { echo(); }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException { echo(); }

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException { echo(); }



    @Override
    public void setBeanClassLoader(ClassLoader classLoader) { echo(); }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) { echo(); }

    @Override
    public void setImportMetadata(@NotNull AnnotationMetadata annotationMetadata) { echo(); }

    @Override
    public void setEnvironment(@NotNull Environment env) { echo(); }



    @Override
    public void setApplicationEventPublisher(@NotNull ApplicationEventPublisher applicationEventPublisher) { echo(); }

    @Override
    public void afterPropertiesSet() { echo(); }

    @Override
    public void destroy() { echo(); }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        echo();
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        echo();
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

}