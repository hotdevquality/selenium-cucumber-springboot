package com.hotdevquality.test.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HandleBrowserWindows {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        RemoteWebDriver driver = new ChromeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com");
        driver.manage().window().maximize();

        // getWindowHandle()
        String windowId = driver.getWindowHandle();
        System.out.println(windowId);

        // getWindowHandles
        driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc'")).click(); // opens a browser tab
        Set<String> windowIds = driver.getWindowHandles();

//        // First approach - using
//        Iterator<String> it = windowIds.iterator();
//        String parentWindowId = it.next();
//        String childWindowId = it.next();
//        System.out.println("Parent window ID: " + parentWindowId);
//        System.out.println("Child windows window ID: " + childWindowId);


//        // Second approach - using List/ArrayList
        List<String> windowIdList = new ArrayList<>(windowIds); // converting Set to List
//        String parentWindowId = windowIdList.get(0); // Parent window ID
//        String childWindowId = windowIdList.get(1); // Child window ID
//
//        System.out.println("Parent windows ID: " + parentWindowId);
//        System.out.println("Child windows ID: " + childWindowId);
//
//        // How to use windows ID's for switching
//        driver.switchTo().window(parentWindowId);
//        System.out.println("Parent windows title: " + driver.getTitle());
//
//        driver.switchTo().window(childWindowId);
//        System.out.println("Child windows title: " + driver.getTitle());


        for (String winId : windowIdList) {
            String title = driver.switchTo().window(winId).getTitle();
            System.out.println(title);
        }
    }
}
