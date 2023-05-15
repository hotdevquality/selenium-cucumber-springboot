package com.hotdevquality.test.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class HandleAlerts {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        RemoteWebDriver driver = new ChromeDriver();

//        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

//        // accept alert
//        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
////        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
//        Thread.sleep(2000);
//        driver.switchTo().alert().accept();
//        Thread.sleep(2000);

//        // accept/cancel alert
//        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
//        Thread.sleep(2000);
////        driver.switchTo().alert().accept();
//        driver.switchTo().alert().dismiss();
//        Thread.sleep(2000);

//        // alert with input-box
//        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();
//        Thread.sleep(2000);
//        Alert alert = driver.switchTo().alert();
//        System.out.println("Alert message: " + alert.getText());
//        alert.sendKeys("some info");
//        alert.accept();
//        Thread.sleep(2000);


//        // Authentication pop-up
////        driver.get("https://the-internet.herokuapp.com/basic_auth");
////        https://user:password@URL
//        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
//        Thread.sleep(3000);











        driver.quit();

    }
}
