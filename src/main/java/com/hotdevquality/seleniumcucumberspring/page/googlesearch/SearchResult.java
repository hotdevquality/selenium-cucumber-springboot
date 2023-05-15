package com.hotdevquality.seleniumcucumberspring.page.googlesearch;

import com.hotdevquality.seleniumcucumberspring.brownng.annotation.PageMolecule;
import com.hotdevquality.seleniumcucumberspring.page.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageMolecule
public class SearchResult extends BasePage {

    @FindBy(xpath = "//div[@data-snc]")
    private List<WebElement> results;

    public int getCount() {
        return this.results.size();
    }

    @Override
    public boolean isAt() {
        return wait.until((element) -> !this.results.isEmpty());
    }
}
