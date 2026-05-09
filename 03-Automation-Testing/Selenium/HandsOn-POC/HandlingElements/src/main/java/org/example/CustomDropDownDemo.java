package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CustomDropDownDemo {

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

        pause(2);

        // -------------------------------------------------
        // CLICK CUSTOM DROPDOWN
        // -------------------------------------------------

        WebElement dropdown =
                driver.findElement(
                        By.id("withOptGroup"));

        dropdown.click();

        pause(2);

        // -------------------------------------------------
        // CAPTURE OPTIONS
        // -------------------------------------------------

        List<WebElement> options =
                driver.findElements(
                        By.xpath("//div[contains(@class,'option')]"));

        System.out.println("===== OPTIONS =====");

        for(WebElement option : options) {

            String text = option.getText();

            System.out.println(text);
        }

        pause(2);

        // -------------------------------------------------
        // SELECT REQUIRED OPTION
        // -------------------------------------------------

        for(WebElement option : options) {

            if(option.getText()
                    .equals("Group 1, option 1")) {

                option.click();

                System.out.println("Option Selected");

                break;
            }
        }

        pause(3);

        driver.quit();
    }
}