package com.hotdevquality.seleniumcucumberspring.page.googlesearch;

import com.hotdevquality.seleniumcucumberspring.brownng.annotation.PageMolecule;
import com.hotdevquality.seleniumcucumberspring.page.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageMolecule
public class SearchComponent extends BasePage {

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(name = "btnK")
    private List<WebElement> searchBtn;

    public void search(final String keyword) {
        checkAcceptCookieDisplay();
        this.searchBox.sendKeys(keyword);
        this.searchBox.sendKeys(Keys.ESCAPE);
        this.searchBtn
                .stream()
                .filter(element -> element.isDisplayed() && element.isEnabled())
                .findFirst()
                .ifPresent(WebElement::click);

    }


    @Override
    public boolean isAt() {
//        wait.until(webDriver -> (this.searchBox.isDisplayed()));
        return wait.until((webDriver) -> this.searchBox.isDisplayed());
    }
}
