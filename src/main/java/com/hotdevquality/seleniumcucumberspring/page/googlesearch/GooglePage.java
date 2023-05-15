package com.hotdevquality.seleniumcucumberspring.page.googlesearch;

import com.hotdevquality.seleniumcucumberspring.brownng.annotation.PageObject;
import com.hotdevquality.seleniumcucumberspring.page.BasePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@PageObject
public class GooglePage extends BasePage {

    @Autowired
    private SearchComponent searchComponent;

    @Autowired
    private SearchResult searchResult;

    @Value("${application.url}")
    private String url;

    public void openApp() {
        this.driver.get(url);
    }

    public SearchComponent getSearchComponent() {
        return searchComponent;
    }

    public SearchResult getSearchResult() {
        return searchResult;
    }

    @Override
    public boolean isAt() {
        return this.searchComponent.isAt();
    }
}
