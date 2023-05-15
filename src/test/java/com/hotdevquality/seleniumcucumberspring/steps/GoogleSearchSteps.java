package com.hotdevquality.seleniumcucumberspring.steps;

import com.hotdevquality.seleniumcucumberspring.brownng.annotation.LazyAutowired;
import com.hotdevquality.seleniumcucumberspring.page.googlesearch.GooglePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@CucumberContextConfiguration
@SpringBootTest
public class GoogleSearchSteps {

    @LazyAutowired
    private GooglePage googlePage;

    @Given("I am on the google site")
    public void navigateToSite() {
        this.googlePage.openApp();
    }

    @When("I enter {string} as a keyword")
    public void searchKeyword(String keyword) {
        this.googlePage.getSearchComponent().search(keyword);
    }

    @And("I click on the search button")
    public void clickSearch() {
//        Just for space holder
        assertTrue(this.googlePage.isAt());
    }

    @Then("I should see at least {int} results")
    public void verifyResult(int count) {
        assertTrue(this.googlePage.getSearchResult().getCount() >= count);
    }
}
