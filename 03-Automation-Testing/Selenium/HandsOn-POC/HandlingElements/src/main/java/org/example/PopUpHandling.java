package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;

public class PopUpHandling {

    public static void pause(int seconds)
            throws InterruptedException {

        Thread.sleep(seconds * 1000);
    }

    public static void main(String[] args)
            throws InterruptedException {

        System.setProperty("webdriver.chrome.driver",
                "C:\\browser-drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/alerts");

        driver.manage().window().maximize();

        pause(2);

        // -------------------------------------------------
        // SIMPLE ALERT
        // -------------------------------------------------

        driver.findElement(
                        By.id("alertButton"))
                .click();

        Alert alert1 = driver.switchTo().alert();

        System.out.println("Simple Alert Text: "
                + alert1.getText());

        alert1.accept();

        System.out.println("Simple Alert Accepted");

        pause(2);

        // -------------------------------------------------
        // TIMER ALERT
        // -------------------------------------------------

        driver.findElement(
                        By.id("timerAlertButton"))
                .click();

        pause(6);

        Alert alert2 = driver.switchTo().alert();

        System.out.println("Timer Alert Text: "
                + alert2.getText());

        alert2.accept();

        System.out.println("Timer Alert Accepted");

        pause(2);

        // -------------------------------------------------
        // CONFIRMATION ALERT
        // -------------------------------------------------

        driver.findElement(
                        By.id("confirmButton"))
                .click();

        Alert alert3 = driver.switchTo().alert();

        System.out.println("Confirmation Alert Text: "
                + alert3.getText());

        alert3.dismiss();

        System.out.println("Confirmation Alert Dismissed");

        pause(2);

        // -------------------------------------------------
        // PROMPT ALERT
        // -------------------------------------------------

        driver.findElement(
                        By.id("promtButton"))
                .click();

        Alert alert4 = driver.switchTo().alert();

        alert4.sendKeys("Dharun");

        System.out.println("Text entered in prompt");

        pause(2);

        alert4.accept();

        System.out.println("Prompt Alert Accepted");

        pause(5);

        driver.quit();
    }
}