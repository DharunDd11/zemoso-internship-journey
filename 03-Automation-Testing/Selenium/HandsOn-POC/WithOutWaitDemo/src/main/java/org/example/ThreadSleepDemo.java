package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ThreadSleepDemo {

    public static void pause(int seconds)
            throws InterruptedException {

        Thread.sleep(seconds * 1000);
    }

    public static void main(String[] args)
            throws InterruptedException {

        System.setProperty("webdriver.chrome.driver",
                "C:\\browser-drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/dynamic-properties");

        driver.manage().window().maximize();

        // Fixed wait
        pause(6);

        WebElement button =
                driver.findElement(By.id("enableAfter"));

        button.click();

        System.out.println("Button clicked");

        driver.quit();
    }
}