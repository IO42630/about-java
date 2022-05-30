package com.olexyn.about.java.spring.boot.security.login.service;

public interface SecurityService {
    boolean isAuthenticated();
    void autoLogin(String username, String password);
}
