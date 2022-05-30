package com.olexyn.about.java.spring.boot.security.login.repository;

import com.hellokoding.tutorials.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
