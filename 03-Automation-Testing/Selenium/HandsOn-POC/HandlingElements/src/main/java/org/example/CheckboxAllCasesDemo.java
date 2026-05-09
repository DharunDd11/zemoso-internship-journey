package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckboxAllCasesDemo {

    public static void pause(int seconds)
            throws InterruptedException {

        Thread.sleep(seconds * 1000);
    }
    public static void main(String[] args)
            throws InterruptedException {

        System.setProperty("webdriver.chrome.driver",
                "C:\\browser-drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/checkboxes");

        driver.manage().window().maximize();

        // Locate checkboxes
        WebElement checkbox1 =
                driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));

        WebElement checkbox2 =
                driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        // -------------------------------------------------
        // PRINT INITIAL STATES
        // -------------------------------------------------

        System.out.println("===== INITIAL STATES =====");

        System.out.println("Checkbox1: "
                + checkbox1.isSelected());

        System.out.println("Checkbox2: "
                + checkbox2.isSelected());

        pause(2);

        // -------------------------------------------------
        // SELECT FIRST CHECKBOX
        // -------------------------------------------------

        if(!checkbox1.isSelected()) {

            checkbox1.click();

            System.out.println("Checkbox1 selected");
        }

        pause(2);

        // -------------------------------------------------
        // UNSELECT SECOND CHECKBOX
        // -------------------------------------------------

        if(checkbox2.isSelected()) {

            checkbox2.click();

            System.out.println("Checkbox2 unselected");
        }

        pause(2);

        // -------------------------------------------------
        // PRINT STATES AFTER OPERATIONS
        // -------------------------------------------------

        System.out.println("===== AFTER OPERATIONS =====");

        System.out.println("Checkbox1: "
                + checkbox1.isSelected());

        System.out.println("Checkbox2: "
                + checkbox2.isSelected());

        pause(2);

        // -------------------------------------------------
        // SELECT ALL CHECKBOXES USING LOOP
        // -------------------------------------------------

        List<WebElement> checkboxes =
                driver.findElements(By.xpath("//input[@type='checkbox']"));

        for(WebElement cb : checkboxes) {

            if(!cb.isSelected()) {

                cb.click();

                System.out.println("Checkbox selected using loop");
            }
        }

        pause(2);

        // -------------------------------------------------
        // PRINT FINAL STATES
        // -------------------------------------------------

        System.out.println("===== FINAL STATES =====");

        for(int i = 0; i < checkboxes.size(); i++) {

            System.out.println("Checkbox "
                    + (i + 1)
                    + ": "
                    + checkboxes.get(i).isSelected());
        }

        pause(3);

        driver.quit();
    }
}