package com.hotdevquality.seleniumcucumberspring.resourcesTest;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ResourceTest {

    @Value("classpath:data/testdata.csv")
    private Resource resourceClassPath;

    @Value("file:/Users/hotquality/SpringFramework/selenium-cucumber-spring/src/test/resources/data/testdata.csv")
    private Resource resourceExternalPath;

    @Value("https://samplefilehub.com/docs/txt-sample-file-download/samplefilehub.txt")
    private Resource resourceExternalLink;

    @Value("${screenshot.path}")
    private Path path;

    @Autowired
    private ResourceLoader resourceLoader;

    @Test
    void classPathResourceTest() throws IOException {
        Files.readAllLines(resourceClassPath.getFile().toPath())
                .forEach(System.out::println);
    }

    @Test
    void externalResourceTest() throws IOException {
        Files.readAllLines(resourceExternalPath.getFile().toPath())
                .forEach(System.out::println);
    }

    @Test
    void externalLinkResourceTest() throws IOException {
//        System.out.println(
//                new String(resourceExternalLink.getInputStream().readAllBytes())
//        );
        FileCopyUtils.copy(resourceExternalLink.getInputStream(), Files.newOutputStream(path));
    }


//    For TestNG - DataProvider is used
//    @Test(DataProvider = "getData")
    @ParameterizedTest
    @CsvFileSource(resources = "/data/testdata.csv", delimiter = ',', numLinesToSkip = 1)
    void dynamicSourceTest(String url, String saveAs) throws IOException {
        FileCopyUtils.copy(
                resourceLoader.getResource(url).getInputStream(),
                Files.newOutputStream(path.resolve(saveAs))
        );
    }

//    @DataProvider
//    public Object[][] getData() throws IOException {
//        return Files.readAllLines(resourceExternalPath.getFile().toPath())
//                .stream()
//                .map(s -> s.split(","))
//                .toArray(Object[][]::new);
//    }

}
