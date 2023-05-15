package com.hotdevquality.seleniumcucumberspring.page.googleflights;

import com.hotdevquality.seleniumcucumberspring.brownng.annotation.PageObject;
import com.hotdevquality.seleniumcucumberspring.brownng.annotation.TakeScreenshot;
import com.hotdevquality.seleniumcucumberspring.page.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@PageObject
public class FlightPage extends BasePage {

    @FindBy(css = "")
    private List<WebElement> elements;

    public void goTo(final String url) {
        this.driver.get(url);
        this.driver.manage().window().maximize();
    }

    @TakeScreenshot
    public List<String> getLabels() {
        return this.elements
                .stream()
                .map(WebElement::getText)
                .map(String::trim)
                .collect(Collectors.toList());
    }


    @Override
    public boolean isAt() {
        checkAcceptCookieDisplay();
        return this.wait.until((d) -> !this.elements.isEmpty());
    }
}
