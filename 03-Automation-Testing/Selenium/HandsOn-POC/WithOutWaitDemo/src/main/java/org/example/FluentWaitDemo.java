package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class FluentWaitDemo {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                "C:\\browser-drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/dynamic-properties");

        driver.manage().window().maximize();

        Wait<WebDriver> wait =
                new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(15))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);

        WebElement button = wait.until(driver1 -> {

            WebElement element =
                    driver1.findElement(By.id("enableAfter"));

            if (element.isEnabled()) {
                return element;
            }

            return null;
        });

        button.click();

        System.out.println("Button clicked using Fluent Wait");

        driver.quit();
    }
}