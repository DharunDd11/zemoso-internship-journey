package org.example;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WithHandling {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver",
                "C:\\browser-drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://www.hyrtutorials.com/p/frames-practice.html");

        driver.findElement(By.id("name")).sendKeys("Hello");

        driver.switchTo().frame(driver.findElement(By.id("frm1")));

        Select courseDD = new Select(driver.findElement(By.id("course")));

        courseDD.selectByVisibleText("Java");

        Thread.sleep(3000);

        driver.switchTo().defaultContent();

        driver.findElement(By.id("name")).sendKeys("World");
    }
}