package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ParallelTestingMethods {

    WebDriver driver;

    @BeforeClass
    void setup()
    {
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test(priority = 1)
    void headingTest()
    {
        WebElement heading = driver.findElement(By.xpath("//h1"));

        Assert.assertTrue(heading.isDisplayed(),
                "Heading is not displayed");

        System.out.println("Heading Test Executed : "
                + Thread.currentThread().getId());
    }

    @Test(priority = 2)
    void titleTest()
    {
        String title = driver.getTitle();

        Assert.assertEquals(title,
                "The Internet",
                "Title is not matched");

        System.out.println("Title Test Executed : "
                + Thread.currentThread().getId());
    }

    @AfterClass
    void tearDown()
    {
        driver.quit();
    }
}