package com.hotdevquality.seleniumcucumberspring;


import com.hotdevquality.seleniumcucumberspring.brownng.annotation.LazyAutowired;
import com.hotdevquality.seleniumcucumberspring.brownng.service.ScreenshotService;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

/**
 *
 * Cucumber hooks are essential to do operations before or after the steps.
 * Here I defined these operations by using Cucumber Hooks: https://cucumber.io/docs/cucumber/api/?lang=java#hooks.
 *
 */

public class CucumberHooks {

    @LazyAutowired
    private ScreenshotService screenshotService;

    @LazyAutowired
    private ApplicationContext applicationContext;

    @AfterStep
    public void afterStep(Scenario scenario) throws IOException {
        if(scenario.isFailed()){
            scenario.attach(this.screenshotService.getScreenshot(), "image/png", scenario.getName());
        }
    }

    @After
    public void afterScenario(){
        this.applicationContext.getBean(WebDriver.class).quit();
    }

}
