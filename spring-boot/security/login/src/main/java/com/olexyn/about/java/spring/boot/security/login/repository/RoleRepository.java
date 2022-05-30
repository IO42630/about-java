package com.olexyn.about.java.spring.boot.security.login.repository;

import com.hellokoding.tutorials.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
