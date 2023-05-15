package com.hotdevquality.seleniumcucumberspring.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public abstract class BasePage {

    @Autowired
    protected WebDriver driver;

    @Autowired
    protected WebDriverWait wait;

    @FindBy(xpath = "//*[text()='Accept all']")
    private WebElement acceptAllCookie;

    // ensure page is fully loaded
    @PostConstruct
    private void init() {
        PageFactory.initElements(this.driver, this);
    }

    // get current page & ensure is loaded
    public abstract boolean isAt();

    public void checkAcceptCookieDisplay() {
        if (acceptAllCookie.isDisplayed() && acceptAllCookie.isEnabled()) {
            acceptAllCookie.click();
        }
    }

    public void teardown() {
        driver.quit();
    }
}
