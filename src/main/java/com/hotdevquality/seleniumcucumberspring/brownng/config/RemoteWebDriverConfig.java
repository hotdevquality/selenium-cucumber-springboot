package com.hotdevquality.seleniumcucumberspring.brownng.config;

import com.hotdevquality.seleniumcucumberspring.brownng.annotation.LazyConfiguration;
import com.hotdevquality.seleniumcucumberspring.brownng.annotation.ThreadScopeBean;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;

import java.net.URL;

@Profile("remote")
@LazyConfiguration
public class RemoteWebDriverConfig {

    @Value("${selenium.grid.url}")
    private URL url;

    @ThreadScopeBean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public WebDriver remoteFirefoxDriver() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        return new RemoteWebDriver(this.url, firefoxOptions);
    }

    @ThreadScopeBean
    @ConditionalOnMissingBean
    public WebDriver remoteChromeDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        return new RemoteWebDriver(this.url, chromeOptions);
    }

}
