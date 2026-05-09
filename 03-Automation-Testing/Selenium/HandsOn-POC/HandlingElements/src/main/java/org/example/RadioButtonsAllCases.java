package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

 class RadioButtonAllCases {

    public static void pause(int seconds)
            throws InterruptedException {

        Thread.sleep(seconds * 1000);
    }

    public static void main(String[] args)
            throws InterruptedException {

        System.setProperty("webdriver.chrome.driver",
                "C:\\browser-drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/radio-button");

        driver.manage().window().maximize();

        // Locate radio buttons
        WebElement yesRadio =
                driver.findElement(By.xpath("//label[@for='yesRadio']"));

        WebElement impressiveRadio =
                driver.findElement(By.xpath("//label[@for='impressiveRadio']"));

        // -------------------------------------------------
        // SELECT YES RADIO BUTTON
        // -------------------------------------------------

        yesRadio.click();

        System.out.println("YES radio selected");

        pause(2);

        // Verify selected text
        String result1 =
                driver.findElement(By.className("text-success"))
                        .getText();

        System.out.println("Selected Option: " + result1);

        pause(2);

        // -------------------------------------------------
        // SELECT IMPRESSIVE RADIO BUTTON
        // -------------------------------------------------

        impressiveRadio.click();

        System.out.println("IMPRESSIVE radio selected");

        pause(2);

        // Verify updated selection
        String result2 =
                driver.findElement(By.className("text-success"))
                        .getText();

        System.out.println("Selected Option: " + result2);

        pause(2);

        // -------------------------------------------------
        // VERIFY ONLY ONE RADIO BUTTON ACTIVE
        // -------------------------------------------------

        WebElement yesInput =
                driver.findElement(By.id("yesRadio"));

        WebElement impressiveInput =
                driver.findElement(By.id("impressiveRadio"));

        System.out.println("Yes Selected: "
                + yesInput.isSelected());

        System.out.println("Impressive Selected: "
                + impressiveInput.isSelected());

        pause(3);

        driver.quit();
    }
}