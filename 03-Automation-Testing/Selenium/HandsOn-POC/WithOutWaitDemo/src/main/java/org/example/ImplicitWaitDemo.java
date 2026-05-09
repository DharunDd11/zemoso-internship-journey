package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ImplicitWaitDemo {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                "C:\\browser-drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        // Global wait
        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demoqa.com/dynamic-properties");

        driver.manage().window().maximize();

        WebElement button =
                driver.findElement(By.id("enableAfter"));

        button.click();

        System.out.println("Button clicked");

        driver.quit();
    }
}