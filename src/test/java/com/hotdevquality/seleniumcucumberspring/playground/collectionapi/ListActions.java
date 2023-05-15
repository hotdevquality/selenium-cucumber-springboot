package com.hotdevquality.seleniumcucumberspring.playground.collectionapi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListActions {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        RemoteWebDriver driver = new ChromeDriver();

        driver.get("https://www.twoplugs.com");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[text()='Live Posting']")).click(); // Live Posting
        WebElement dropDownElement = driver.findElement(By.name("category_id"));
        Select dropSelect = new Select(dropDownElement);

        List<WebElement> options = dropSelect.getOptions();
        ArrayList originalList = new ArrayList();
        ArrayList tempList = new ArrayList();

        for (WebElement option : options) {
            originalList.add(option.getText());
            tempList.add(option.getText());
        }

        System.out.println("Original List: " + originalList);
        System.out.println("Original List: " + tempList);

        Collections.sort(tempList);

        if (originalList.equals(tempList)) {
            System.out.println("Dropdown Sorted...");
        } else {
            System.out.println("Dropdown Unsorted...");
        }

    }

    public static void checkListIsSorted(WebElement element) {

    }
}
