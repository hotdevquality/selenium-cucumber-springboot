package com.hotdevquality.seleniumcucumberspring.googletest;

import com.google.common.util.concurrent.Uninterruptibles;
import com.hotdevquality.seleniumcucumberspring.brownng.annotation.LazyAutowired;
import com.hotdevquality.seleniumcucumberspring.brownng.service.ScreenshotService;
import com.hotdevquality.seleniumcucumberspring.page.googlesearch.GooglePage;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class Google1Test {

    @LazyAutowired
    private GooglePage googlePage;

    @LazyAutowired
    private ScreenshotService screenshotService;

    @Test
    void googleTest() throws IOException {
        this.googlePage.openApp();
        assertTrue(this.googlePage.isAt());

        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);

        this.googlePage.getSearchComponent().search("spring boot");
        assertTrue(this.googlePage.getSearchResult().isAt());
        assertTrue(this.googlePage.getSearchResult().getCount() > 2);
        this.screenshotService.takeTakesScreenshot();
        this.googlePage.teardown();
//        System.out.println("Working Directory = " + System.getProperty("user.dir"));
    }
}
