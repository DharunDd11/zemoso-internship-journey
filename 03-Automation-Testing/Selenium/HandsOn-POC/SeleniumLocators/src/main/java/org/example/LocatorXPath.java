package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorXPath {

    public static void pause(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\browser-drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/buttons");
        driver.manage().window().maximize();
        pause(2);

        driver.findElement(By.xpath("//button[text()='Click Me']")).click();
        pause(3);

        driver.findElement(By.xpath("//button[contains(@class,'btn')]")).click();
        pause(3);

        pause(3);
        driver.quit();
    }
}