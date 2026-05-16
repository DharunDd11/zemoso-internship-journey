package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ParallelTestingClass1 {

    WebDriver driver;

    @BeforeClass
    void setup()
    {
        driver = new ChromeDriver();



        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test
    void headingTest()
    {
        WebElement heading = driver.findElement(By.xpath("//h1"));

        Assert.assertTrue(heading.isDisplayed());

        System.out.println("Heroku Heading Test : "
                + Thread.currentThread().getId());
    }

    @Test
    void titleTest()
    {
        String title = driver.getTitle();

        Assert.assertEquals(title,
                "The Internet");

        System.out.println("Heroku Title Test : "
                + Thread.currentThread().getId());
    }

    @AfterClass
    void tearDown()
    {
        driver.quit();
    }
}