package com.hotdevquality.seleniumcucumberspring.brownng.aop;

import com.hotdevquality.seleniumcucumberspring.brownng.annotation.Window;
import com.hotdevquality.seleniumcucumberspring.brownng.service.WindowSwitchService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WindowAspect {

    @Autowired
    private WindowSwitchService switchService;

    @Before("@target(window) && within(com.hotdevquality.seleniumcucumberspring..*)")
    public void before(Window window) {
        this.switchService.switchByTitle(window.value());
    }

    @After("@target(window) && within(com.hotdevquality.seleniumcucumberspring..*)")
    public void after(Window window) {
        this.switchService.switchByIndex(0);
    }

}
