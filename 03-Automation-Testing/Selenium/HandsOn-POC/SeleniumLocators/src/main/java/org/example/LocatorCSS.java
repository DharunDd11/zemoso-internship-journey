package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorCSS {

    public static void pause(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\browser-drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();
        pause(2);

        driver.findElement(By.cssSelector("#userName")).sendKeys("Dharun");
        pause(2);

        driver.findElement(By.cssSelector("input[type='email']")).sendKeys("test@mail.com");
        pause(2);

        driver.findElement(By.cssSelector("button#submit")).click();
        pause(3);

        pause(3);
        driver.quit();
    }
}