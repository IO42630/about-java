package com.olexyn.about.java.spring.beanlife.service;

import com.olexyn.about.java.spring.beanlife.bean.Employee;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class AService implements InitializingBean, DisposableBean {

    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public AService() {
        System.out.println("AService()");
    }


    public void init() {
        System.out.println("AService.init()");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("AService.afterPropertiesSet()");
    }

    @Override
    public void destroy() {
        System.out.println("AService.destroy()");
    }

}
