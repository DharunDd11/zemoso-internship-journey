package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ParallelTestingClass2 {

    WebDriver driver;

    @BeforeClass
    void setup()
    {

        System.setProperty("webdriver.edge.driver",
                "C:\\browser-drivers\\msedgedriver.exe");

        driver = new EdgeDriver();



        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    @Test
    void loginPageTitleTest()
    {
        String title = driver.getTitle();

        Assert.assertTrue(title.contains("Test Login"));

        System.out.println("Login Page Title Test : "
                + Thread.currentThread().getId());
    }

    @Test
    void loginTest()
    {
        driver.findElement(By.id("username"))
                .sendKeys("student");

        driver.findElement(By.id("password"))
                .sendKeys("Password123");

        driver.findElement(By.id("submit")).click();

        WebElement successMessage =
                driver.findElement(By.xpath("//h1"));

        Assert.assertTrue(successMessage.isDisplayed());

        System.out.println("Login Test : "
                + Thread.currentThread().getId());
    }

    @AfterClass
    void tearDown()
    {
        driver.quit();
    }
}