package com.hotdevquality.test.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownSelection {

    // for boostrap option - which you need to click parent element first
    public static void selectOptionFromDropDown(List<WebElement> options, String value) {
        for (WebElement option : options) {
            if (option.getText().equals(value)) {
                option.click();
                break;
            }
        }
    }

    public static void selectOptionFromDropDown(WebElement element, String value) {
        Select dropDown = new Select(element);
        List<WebElement> allOptions = dropDown.getOptions();

        for ( WebElement option : allOptions ) {
            if (option.getText().equals(value)) {
                option.click();
                break;
            }

        }
    }

    public static void selectChoiceValues(WebDriver driver, By by, String... values ) {
        List<WebElement> choiceList = driver.findElements(by);
        if (!values[0].equalsIgnoreCase("all")) {
            for (WebElement item : choiceList) {
                String text = item.getText();
                for (String value : values) {
                    if (text.equals(value)) {
                        item.click();
                        break;
                    }
                }
            }
        } else {
            try {
                for (WebElement item : choiceList) {
                    item.click();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void selectChoiceValues(WebDriver driver, List<WebElement> elements, String... values ) {
        List<WebElement> choiceList = elements;
        if (!values[0].equalsIgnoreCase("all")) {
            for (WebElement item : choiceList) {
                String text = item.getText();
                for (String value : values) {
                    if (text.equals(value)) {
                        item.click();
                        break;
                    }
                }
            }
        } else {
            for (WebElement item : choiceList) {
                item.click();
            }
        }
    }
}
