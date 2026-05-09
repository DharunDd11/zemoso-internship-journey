package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class StaticTableHandling {

    public static void pause(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\browser-drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://testautomationpractice.blogspot.com/");

        driver.manage().window().maximize();

        pause(3);

        // Count Rows
        List<WebElement> rows = driver.findElements(
                By.xpath("//table[@name='BookTable']/tbody/tr"));

        System.out.println("Total Rows: " + rows.size());

        pause(2);

        // Count Columns
        List<WebElement> columns = driver.findElements(
                By.xpath("//table[@name='BookTable']/tbody/tr[1]/th"));

        System.out.println("Total Columns: " + columns.size());

        pause(2);

        // Fetch Specific Cell Data
        String value = driver.findElement(
                        By.xpath("//table[@name='BookTable']/tbody/tr[3]/td[2]"))
                .getText();

        System.out.println("Cell Data: " + value);

        pause(3);

        // Print Entire Table
        for(int i = 2; i <= rows.size(); i++) {

            for(int j = 1; j <= columns.size(); j++) {

                String data = driver.findElement(
                                By.xpath("//table[@name='BookTable']/tbody/tr["+i+"]/td["+j+"]"))
                        .getText();

                System.out.print(data + "   ");
            }

            System.out.println();

            pause(1);
        }

        pause(5);

        driver.quit();
    }
}