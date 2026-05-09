package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class MyntraFlow {

    public static void pause(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\browser-drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.myntra.com/");
        driver.manage().window().maximize();

        pause(5);

        // Search for shoes
        driver.findElement(By.cssSelector("input[placeholder='Search for products, brands and more']"))
                .sendKeys("shoes");
        pause(2);

        driver.findElement(By.cssSelector("a.desktop-submit")).click();
        pause(5);

        // Apply filter (Men)
        driver.findElement(By.xpath("//label[contains(text(),'Men')]")).click();
        pause(5);

        // Click first product
        driver.findElement(By.xpath("(//li[contains(@class,'product-base')])[1]")).click();
        pause(5);

        // Switch to new tab
        Set<String> windows = driver.getWindowHandles();
        for(String win : windows){
            driver.switchTo().window(win);
        }

        pause(5);

        // Get product title
        String title = driver.findElement(By.xpath("//h1")).getText();
        System.out.println("Product Title: " + title);

        pause(5);

        driver.quit();
    }
}