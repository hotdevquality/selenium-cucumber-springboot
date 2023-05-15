package com.hotdevquality.test.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class HandleLinks {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        RemoteWebDriver driver = new ChromeDriver();

//        driver.get("https://www.amazon.co.uk");
        driver.get("http://www.deadlinkcity.com/");
        driver.manage().window().maximize();

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println("Available links: " + allLinks.size());

//        for (int i=0; i<allLinks.size(); i++) {
//            System.out.println(allLinks.get(i).getText());
//            System.out.println(allLinks.get(i).getAttribute("href"));
//        }

//        for (WebElement link : allLinks) {
//            System.out.println(link.getText());
//            System.out.println(link.getAttribute("href"));
//        }
        int brokenLink = 0;
        for (WebElement link : allLinks) {
            String url = link.getAttribute("href");
            if (url==null || url.isEmpty()) {
                System.out.println("URL is empty");
                continue;
            }
            URL urlLink = new URL(url);
            try {
                HttpURLConnection httpURLCon = (HttpURLConnection) urlLink.openConnection();
                httpURLCon.connect();

                if (httpURLCon.getResponseCode() >= 400) {
                    System.out.println(httpURLCon.getResponseCode() +" is Broken link");
                    brokenLink++;
                } else {
                    System.out.println(httpURLCon.getResponseCode() + url + " is Valid link");
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

        }
        System.out.println("Number of broken links is " + brokenLink);
        driver.quit();
    }
}
