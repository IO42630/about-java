package com.olexyn.about.java.spring.jpa.em.anno;

import com.olexyn.about.java.spring.jpa.em.java.EmJavaConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;

import javax.persistence.EntityManagerFactory;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class EmAnnoConfig extends EmJavaConfig {

    /**
     * Out of Scope.
     */
    @Bean
    public PersistenceAnnotationBeanPostProcessor persistenceAnnotationBeanPostProcessor(EntityManagerFactory emf) {

        Map<String, String> persistenceUnits = new HashMap<>();
        persistenceUnits.put("System", "pu1");

        PersistenceAnnotationBeanPostProcessor bpp = new PersistenceAnnotationBeanPostProcessor();
        bpp.setPersistenceUnits(persistenceUnits);
        bpp.setDefaultPersistenceUnitName("System");
        bpp.setJndiTemplate(null);

        return bpp;
    }
}
