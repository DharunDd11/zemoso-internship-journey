package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class StaticDropDownDemo {

    public static void pause(int seconds)
            throws InterruptedException {

        Thread.sleep(seconds * 1000);
    }

    public static void main(String[] args)
            throws InterruptedException {

        System.setProperty("webdriver.chrome.driver",
                "C:\\browser-drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/select-menu");

        driver.manage().window().maximize();

        // Locate old style dropdown
        WebElement dropdown =
                driver.findElement(By.id("oldSelectMenu"));

        // Create Select object
        Select select = new Select(dropdown);

        // -------------------------------------------------
        // SELECT BY VISIBLE TEXT
        // -------------------------------------------------

        select.selectByVisibleText("Blue");

        System.out.println("Selected using visible text");

        pause(2);

        // -------------------------------------------------
        // SELECT BY VALUE
        // -------------------------------------------------

        select.selectByValue("4");

        System.out.println("Selected using value");

        pause(2);

        // -------------------------------------------------
        // SELECT BY INDEX
        // -------------------------------------------------

        select.selectByIndex(2);

        System.out.println("Selected using index");

        pause(2);

        // -------------------------------------------------
        // PRINT CURRENT SELECTED OPTION
        // -------------------------------------------------

        String selectedOption =
                select.getFirstSelectedOption().getText();

        System.out.println("Current Selected: "
                + selectedOption);

        pause(2);

        // -------------------------------------------------
        // PRINT ALL OPTIONS
        // -------------------------------------------------

        List<WebElement> options =
                select.getOptions();

        System.out.println("===== DROPDOWN OPTIONS =====");

        for(WebElement option : options) {

            System.out.println(option.getText());
        }

        pause(3);

        driver.quit();
    }
}