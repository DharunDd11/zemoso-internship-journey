package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingExceptions {


    // PAUSE METHOD

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

        try {

            driver.get("https://www.saucedemo.com");

            pause(2);

            System.out.println("Website Opened Successfully");

            // VALID STEP 2
            driver.findElement(By.id("user-name"))
                    .sendKeys("standard_user");

            pause(2);

            System.out.println("Username Entered");

            // VALID STEP 3

            driver.findElement(By.id("password"))
                    .sendKeys("secret_sauce");

            pause(2);

            System.out.println("Password Entered");



            try {

                driver.findElement(By.id("wrong-login-button"))
                        .click();

            } catch (NoSuchElementException e) {

                System.out.println("NoSuchElementException Handled");
                System.out.println("Login Button Locator Wrong");
            }

            pause(2);

            // VALID STEP 4

            driver.findElement(By.id("login-button"))
                    .click();

            pause(3);

            System.out.println("Login Successful");

            // VALID STEP 5
            String title = driver.getTitle();

            System.out.println("Page Title: " + title);

            pause(2);


            try {

                driver.findElement(
                        By.xpath("//div[@class='inventory_item']]"));

            } catch (InvalidSelectorException e) {

                System.out.println("InvalidSelectorException Handled");
                System.out.println("XPath Syntax Incorrect");
            }

            pause(2);

            // VALID STEP 6

            driver.findElement(By.id("react-burger-menu-btn"))
                    .click();

            pause(2);

            System.out.println("Menu Opened");



            try {

                driver.switchTo().window("INVALID_WINDOW");

            } catch (NoSuchWindowException e) {

                System.out.println("NoSuchWindowException Handled");
                System.out.println("Invalid Window");
            }

            pause(2);

            // VALID STEP 7

            driver.findElement(By.id("logout_sidebar_link"))
                    .click();

            pause(2);

            System.out.println("Logout Successful");




            try {

                driver.switchTo().alert().accept();

            } catch (NoAlertPresentException e) {

                System.out.println("NoAlertPresentException Handled");
                System.out.println("No Alert Available");
            }

            pause(2);

            // VALID STEP 8
            System.out.println("Framework Execution Continued");

        }

        catch (Exception e) {

            System.out.println("Unexpected Exception Occurred");
        }

        finally {

            System.out.println("Framework Cleanup Completed");

            pause(3);

            try {

                driver.quit();

            } catch (Exception e) {

                System.out.println("Driver Already Closed");
            }
        }
    }
}