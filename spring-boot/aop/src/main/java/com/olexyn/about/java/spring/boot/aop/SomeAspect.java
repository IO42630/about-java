package com.olexyn.about.java.spring.boot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SomeAspect {

    @Before(value = "execution(* com.olexyn.about.java.spring.boot.aop.SomeService.*(..)) && args(a,b)")
    public void beforeAdvice(JoinPoint joinPoint, String a, String b) {
        System.out.println("before " + a + b);
    }

    @After(value = "execution(* com.olexyn.about.java.spring.boot.aop.SomeService.*(..)) && args(a,b) && anyPublicOperation()")
    public void afterAdvice(JoinPoint joinPoint, String a, String b) {
        System.out.println("after " + a + b);
    }

    @Pointcut("execution(public * *(..))")
    private void anyPublicOperation() { }

}
