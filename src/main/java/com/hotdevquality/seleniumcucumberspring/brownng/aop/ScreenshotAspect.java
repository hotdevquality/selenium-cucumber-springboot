package com.hotdevquality.seleniumcucumberspring.brownng.aop;


import com.hotdevquality.seleniumcucumberspring.brownng.annotation.TakeScreenshot;
import com.hotdevquality.seleniumcucumberspring.brownng.service.ScreenshotService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Aspect
@Component
public class ScreenshotAspect {

    @Autowired
    private ScreenshotService screenshotService;


    @After("@annotation(takeScreenshot)")
    public void after(TakeScreenshot takeScreenshot) throws IOException {
        this.screenshotService.takeTakesScreenshot();
    }

}
