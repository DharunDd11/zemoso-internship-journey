package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {

    WebDriver driver;

    @BeforeClass
    void setup()
    {
        driver = new ChromeDriver();

        driver.manage().window().maximize();
    }

    @Test(dataProvider = "loginData",dataProviderClass =DataProviderClass.class)
    void loginTest(String username, String password)
    {
        driver.get("https://practicetestautomation.com/practice-test-login/");

        WebElement user = driver.findElement(By.id("username"));
        user.clear();
        user.sendKeys(username);

        WebElement pass = driver.findElement(By.id("password"));
        pass.clear();
        pass.sendKeys(password);

        driver.findElement(By.id("submit")).click();

        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains("Logged In Successfully"),
                "Login Failed");
    }



    @AfterClass
    void tearDown()
    {
        driver.quit();
    }
}