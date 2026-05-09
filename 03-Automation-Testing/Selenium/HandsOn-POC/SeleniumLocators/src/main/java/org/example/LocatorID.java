package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorID{

    public static void pause(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\browser-drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        pause(2);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        pause(2);

        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        pause(2);

        driver.findElement(By.id("login-button")).click();
        pause(3);

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        pause(3);

        pause(5);
        driver.quit();
    }
}