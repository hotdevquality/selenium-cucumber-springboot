package com.hotdevquality.seleniumcucumberspring.googletest;

import com.google.common.util.concurrent.Uninterruptibles;
import com.hotdevquality.seleniumcucumberspring.brownng.annotation.LazyAutowired;
import com.hotdevquality.seleniumcucumberspring.brownng.service.ScreenshotService;
import com.hotdevquality.seleniumcucumberspring.page.googlesearch.GooglePage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class Google2Test {

    @LazyAutowired
    private GooglePage googlePage;

    @LazyAutowired
    private ScreenshotService screenshotService;

    @Test
    void googleTest() throws IOException {
        this.googlePage.openApp();
        assertTrue(this.googlePage.isAt());

        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);

        this.googlePage.getSearchComponent().search("selenium");
        assertTrue(this.googlePage.getSearchResult().isAt());
        assertTrue(this.googlePage.getSearchResult().getCount() > 2);
        this.screenshotService.takeTakesScreenshot();
        this.googlePage.teardown();
    }
}
