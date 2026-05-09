package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MultiSelectDropDownDemo {

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

        // Locate multi-select dropdown
        WebElement multiDropdown =
                driver.findElement(By.id("cars"));

        // Create Select object
        Select select = new Select(multiDropdown);

        // -------------------------------------------------
        // CHECK WHETHER MULTI-SELECT
        // -------------------------------------------------

        System.out.println("Is Multiple: "
                + select.isMultiple());

        pause(2);

        // -------------------------------------------------
        // SELECT MULTIPLE OPTIONS
        // -------------------------------------------------

        select.selectByVisibleText("Volvo");
        pause(1);

        select.selectByVisibleText("Saab");
        pause(1);

        select.selectByVisibleText("Opel");
        pause(1);

        System.out.println("Multiple options selected");

        pause(2);

        // -------------------------------------------------
        // PRINT SELECTED OPTIONS
        // -------------------------------------------------

        List<WebElement> selectedOptions =
                select.getAllSelectedOptions();

        System.out.println("===== SELECTED OPTIONS =====");

        for(WebElement option : selectedOptions) {

            System.out.println(option.getText());
        }

        pause(2);

        // -------------------------------------------------
        // DESELECT ONE OPTION
        // -------------------------------------------------

        select.deselectByVisibleText("Saab");

        System.out.println("Saab deselected");

        pause(2);

        // -------------------------------------------------
        // PRINT UPDATED SELECTED OPTIONS
        // -------------------------------------------------

        selectedOptions = select.getAllSelectedOptions();

        System.out.println("===== UPDATED OPTIONS =====");

        for(WebElement option : selectedOptions) {

            System.out.println(option.getText());
        }

        pause(2);

        // -------------------------------------------------
        // DESELECT ALL
        // -------------------------------------------------

        select.deselectAll();

        System.out.println("All options deselected");

        pause(3);

        driver.quit();
    }
}