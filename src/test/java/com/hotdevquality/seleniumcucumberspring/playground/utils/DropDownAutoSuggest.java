package com.hotdevquality.test.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;
import java.util.List;

public class DropDownAutoSuggest {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.bing.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("sb_form_q")).sendKeys("selenium");
        List<WebElement> list = driver.findElements(By.xpath("//li[@class='sa_sg']//span"));

        System.out.println("Size of Auto Suggestion: " + list.size());
        for (WebElement item : list) {
            if (item.getText().equals("selenium")) {
                item.click();
                break;
            }
        }
    }
}
