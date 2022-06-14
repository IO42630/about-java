package com.olexyn.about.java.spring.boot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
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
    public void afterAdvice(ProceedingJoinPoint joinPoint, String a, String b) {
        System.out.println("after " + a + b);
    }

    @Pointcut("execution(* *(..))")
    private void minWildcards() { }

    @Pointcut("execution(String foo(..))")
    private void minNoWildcards() { }

    @Pointcut("execution(public * *(..) throws *)")
    private void allWildcards() { }

    @Pointcut("execution(public String com.olexyn.*foo(..) throws Exception)")
    private void allNoWildcards() { }

    @Pointcut("execution(public * *(..))")
    private void anyPublicOperation() { }

    @Pointcut("execution(@java.lang.Override * *(..))")
    private void anyOverridingMethod() { }

    @Pointcut("@annotation(Override)")
    public void anyOverridingMethod2() { }

    @Pointcut("execution( * read*(..))") /* The package path is optional. */
    private void anyMethodStartingWithRead() { }

    @Pointcut("within(com.olexyn.about.java.spring.boot.aop.SomeController)")
    public void anyOverridingMethod323() { }

    @Pointcut("this(SomeBean)")
    public void anyInstanceOfSomeBean() { }

    @Pointcut("bean(SomeBean)")
    public void anyMethodWithArgsFromUtil2() { }

    @Pointcut("args(int, int)")
    public void anyMethodWithIntIntArgs() { }

    @Pointcut("args(java.util.*)")
    public void anyMethodWithArgsFromUtil() { }

}
