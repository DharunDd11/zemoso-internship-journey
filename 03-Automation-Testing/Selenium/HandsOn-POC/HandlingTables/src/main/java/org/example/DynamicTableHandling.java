package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DynamicTableHandling {

    public static void pause(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver",
                "C:\\browser-drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://coinmarketcap.com/");

        driver.manage().window().maximize();

        pause(5);

        // Capture Rows
        List<WebElement> rows = driver.findElements(
                By.xpath("//table/tbody/tr"));

        System.out.println("Total Rows: " + rows.size());

        pause(2);

        // Traverse Dynamic Table
        for(int i = 1; i <= 10; i++) {

            // Capture Coin Name
            String coinName = driver.findElement(
                            By.xpath("//table/tbody/tr["+i+"]/td[3]"))
                    .getText();

            // Capture Price
            String price = driver.findElement(
                            By.xpath("//table/tbody/tr["+i+"]/td[4]"))
                    .getText();

            System.out.println(coinName + " ---> " + price);

            pause(1);
        }

        pause(5);

        driver.quit();
    }
}