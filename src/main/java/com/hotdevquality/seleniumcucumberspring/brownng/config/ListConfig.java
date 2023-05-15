package com.hotdevquality.seleniumcucumberspring.brownng.config;

import com.hotdevquality.seleniumcucumberspring.brownng.annotation.LazyConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.List;

@LazyConfiguration
public class ListConfig {

    @Bean
    public List<String> list() {
        return List.of("a", "b", "c", "d", "e");
    }
}
