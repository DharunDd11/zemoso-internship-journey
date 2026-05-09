package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WithoutExceptionHandling {

    public static void pause(int seconds) {

        try {

            Thread.sleep(seconds * 1000);

        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                "C:\\browser-drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        // =====================================================
        // VALID STEP 1
        // =====================================================

        driver.get("https://www.saucedemo.com");

        pause(2);

        System.out.println("Website Opened Successfully");

        // =====================================================
        // VALID STEP 2
        // =====================================================

        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");

        pause(2);

        System.out.println("Username Entered");

        // =====================================================
        // EXCEPTION : NoSuchElementException
        // =====================================================

        System.out.println("Now trying to enter password");

        pause(3);

        driver.findElement(By.id("wrong-password"))
                .sendKeys("secret_sauce");

        // PROGRAM WILL STOP HERE



        driver.findElement(By.id("login-button"))
                .click();

        System.out.println("Login Successful");

        pause(2);



        String title = driver.getTitle();

        System.out.println("Page Title: " + title);

        pause(2);

        driver.quit();

        System.out.println("Execution Completed");
    }
}