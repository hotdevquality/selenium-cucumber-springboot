package com.hotdevquality.seleniumcucumberspring.playground.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

public class CheckBoxes {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        RemoteWebDriver driver = new ChromeDriver();

        driver.get("https:itera-qa.azurewebsites.net/home/automation");
        List<WebElement> dayCheckboxes = driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id, 'day')]"));
        System.out.println("Total no of checkboxes: " + dayCheckboxes.size());

//        // option 1
//        for (int i=0; i<dayCheckboxes.size(); i++) {
//            dayCheckboxes.get(i).click();
//        }

//        // option 2
//        for (WebElement dayCheckbox : dayCheckboxes) {
//            dayCheckbox.click();
//        }

//        // option 3 - select multiple check boxes by choice
//        for (WebElement dayCheckbox : dayCheckboxes) {
//            String checkName = dayCheckbox.getAttribute("id");
//            if (checkName.equalsIgnoreCase("monday") || checkName.equalsIgnoreCase("monday"))
//            dayCheckbox.click();
//        }

//        // option 4 - select last 2 check boxes
        int total = dayCheckboxes.size();
        for (int i=total-2; i<total; i++) {
            dayCheckboxes.get(i).click();
        }

        // option 5 - select first 2 check boxes
//        int total = dayCheckboxes.size();
//        for (int i=total-2; i<total; i++) {
//            if (i < 2) {
//                dayCheckboxes.get(i).click();
//            }
//        }
        driver.quit();
    }


}
