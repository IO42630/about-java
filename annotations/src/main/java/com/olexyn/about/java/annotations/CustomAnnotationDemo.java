package com.olexyn.about.java.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface CustomClassAnnotation {

}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface CustomFieldAnnotation {
    public String someField() default "";
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CustomMethodAnnotation {

}

@CustomClassAnnotation
public class CustomAnnotationDemo {

    @CustomFieldAnnotation
    String foo;

    @CustomMethodAnnotation
    void bar() {}

}
