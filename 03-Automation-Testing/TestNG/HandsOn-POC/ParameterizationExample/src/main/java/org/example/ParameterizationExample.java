package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizationExample {

    WebDriver driver;

    @BeforeClass
    @Parameters({"browser","url"})

    void setup(String browser, String url)
    {
        if(browser.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver",
                    "C:\\browser-drivers\\chromedriver.exe");

            driver = new ChromeDriver();
        }

        else if(browser.equalsIgnoreCase("edge"))
        {
            System.setProperty("webdriver.edge.driver",
                    "C:\\browser-drivers\\msedgedriver.exe");

            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();

        driver.get(url);
    }

    @Test(priority = 1)
    void headingTest()
    {
        WebElement heading = driver.findElement(
                By.xpath("//h1"));

        Assert.assertTrue(heading.isDisplayed(),
                "Heading is not displayed");
    }

    @Test(priority = 2)
    void homePageTitle()
    {
        String title = driver.getTitle();

        Assert.assertEquals(title,
                "The Internet",
                "Title is not matched");
    }

    @AfterClass
    void tearDown()
    {
        driver.quit();
    }
}