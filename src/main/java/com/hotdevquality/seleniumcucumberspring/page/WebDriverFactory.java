package com.hotdevquality.seleniumcucumberspring.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class WebDriverFactory {

    public WebDriver getDriver(String browser) {
        if (browser.equalsIgnoreCase("firefox")) {
            return new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            return new EdgeDriver();
        } else if (browser.equalsIgnoreCase("safari")) {
            return new SafariDriver();
        } else {
            return new ChromeDriver();
        }
    }

}
