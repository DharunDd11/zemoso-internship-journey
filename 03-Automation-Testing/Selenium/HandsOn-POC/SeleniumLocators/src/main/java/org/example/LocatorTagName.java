package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class LocatorTagName {

    public static void pause(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\browser-drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        pause(2);

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Links: " + links.size());
        pause(3);

        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        System.out.println("Inputs: " + inputs.size());
        pause(3);

        pause(4);
        driver.quit();
    }
}