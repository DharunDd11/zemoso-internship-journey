package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdvancedXPathDemo {

    public static void pause(int seconds)
            throws InterruptedException {

        Thread.sleep(seconds * 1000);
    }

    public static void main(String[] args)
            throws InterruptedException {

        System.setProperty("webdriver.chrome.driver",
                "C:\\browser-drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/text-box");

        driver.manage().window().maximize();

        pause(2);

        // -------------------------------------------------
        // contains()
        // -------------------------------------------------

        WebElement fullName =
                driver.findElement(
                        By.xpath("//input[contains(@id,'userName')]"));

        fullName.sendKeys("Dharun");

        System.out.println("contains() used");

        pause(2);

        // -------------------------------------------------
        // starts-with()
        // -------------------------------------------------

        WebElement email =
                driver.findElement(
                        By.xpath("//input[starts-with(@id,'userEmail')]"));

        email.sendKeys("dharun@test.com");

        System.out.println("starts-with() used");

        pause(2);

        // -------------------------------------------------
        // following axis
        // -------------------------------------------------

        WebElement currentAddress =
                driver.findElement(
                        By.xpath("//label[@id='currentAddress-label']/following::textarea[1]"));

        currentAddress.sendKeys("Hyderabad");

        System.out.println("following axis used");

        pause(2);

        // -------------------------------------------------
        // PERMANENT ADDRESS
        // -------------------------------------------------

        WebElement permanentAddress =
                driver.findElement(
                        By.id("permanentAddress"));

        permanentAddress.sendKeys("Bangalore");

        System.out.println("Permanent address entered");

        pause(2);

        // -------------------------------------------------
        // SCROLL DOWN
        // -------------------------------------------------

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,300)");

        pause(2);

        // -------------------------------------------------
        // text()
        // -------------------------------------------------

        WebElement submitButton =
                driver.findElement(
                        By.xpath("//button[text()='Submit']"));

        submitButton.click();

        System.out.println("text() used");

        pause(5);

        driver.quit();
    }
}