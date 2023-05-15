package com.hotdevquality.seleniumcucumberspring.prop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.util.Properties;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class propTest {

    @Autowired
    private ResourceLoader loader;

    @Test
    void propSampleTest() throws IOException {
        Properties properties = PropertiesLoaderUtils.loadProperties(loader.getResource("sample.properties"));
        System.out.println(properties);
        System.out.println(properties.get("username"));
    }
}
