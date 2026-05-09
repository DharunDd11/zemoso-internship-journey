package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorClassName {

    public static void pause(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\browser-drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        pause(2);

        driver.findElement(By.className("submit-button")).click();
        pause(3);

        pause(4);
        driver.quit();
    }
}