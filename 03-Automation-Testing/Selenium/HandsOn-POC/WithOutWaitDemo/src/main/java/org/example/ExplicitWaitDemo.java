package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitDemo {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                "C:\\browser-drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/dynamic-properties");

        driver.manage().window().maximize();

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(10));

        // Wait until clickable
        WebElement button = wait.until(
                ExpectedConditions
                        .elementToBeClickable(
                                By.id("enableAfter")));

        button.click();

        System.out.println("Button clicked successfully");

        driver.quit();
    }
}