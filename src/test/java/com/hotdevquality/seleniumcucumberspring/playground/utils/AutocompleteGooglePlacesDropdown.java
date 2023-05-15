package com.hotdevquality.seleniumcucumberspring.playground.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

public class AutocompleteGooglePlacesDropdown {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.twoplugs.com");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
        WebElement searchBox = driver.findElement(By.id("autocomplete"));
        searchBox.clear();
        searchBox.sendKeys("Toronto");

        String text;
        do {
            searchBox.sendKeys(Keys.ARROW_DOWN);
            text = searchBox.getAttribute("value");
            if (text.equals("Toronto, OH, USA")) {
                searchBox.sendKeys(Keys.ENTER);
            }
        } while (!text.isEmpty());




    }
}
