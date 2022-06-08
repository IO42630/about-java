package com.olexyn.about.java.spring.jpa;

import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

public class EmbeddedDbConfig {

    void foo() {
        var bar = new EmbeddedDatabaseBuilder().build();
    }
}
