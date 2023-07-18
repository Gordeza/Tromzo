package com.example.tromzo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {
    /**
    * Defines a bean for the ObjectManager.
    * @return An instance of ObjectManager initialized with a capacity of 10.
    */
    @Bean
    public ObjectManager getObjectManager() {
        return new ObjectManager(10);
    }
}
