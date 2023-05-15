package com.hotdevquality.seleniumcucumberspring.brownng.config;

import com.github.javafaker.Faker;
import com.hotdevquality.seleniumcucumberspring.brownng.annotation.LazyConfiguration;
import org.springframework.context.annotation.Bean;

@LazyConfiguration
public class FakerConfig {

    @Bean
    public Faker getFaker() {
        return new Faker();
    }
}
