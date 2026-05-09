package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AutoSuggestionDropDownDemo {

    public static void pause(int seconds)
            throws InterruptedException {

        Thread.sleep(seconds * 1000);
    }

    public static void main(String[] args)
            throws InterruptedException {

        System.setProperty("webdriver.chrome.driver",
                "C:\\browser-drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.wikipedia.org/");

        driver.manage().window().maximize();

        pause(2);

        // -------------------------------------------------
        // ENTER SEARCH TEXT
        // -------------------------------------------------

        WebElement searchBox =
                driver.findElement(By.id("searchInput"));

        searchBox.sendKeys("selenium");

        pause(3);

        // -------------------------------------------------
        // CAPTURE AUTO-SUGGESTIONS
        // -------------------------------------------------

        List<WebElement> suggestions =
                driver.findElements(
                        By.xpath("//a[contains(@class,'suggestion-link')]"));

        System.out.println("===== SUGGESTIONS =====");

        for(WebElement suggestion : suggestions) {

            System.out.println(suggestion.getText());
        }

        pause(2);

        // -------------------------------------------------
        // SELECT REQUIRED SUGGESTION
        // -------------------------------------------------

        for(WebElement suggestion : suggestions) {

            if(suggestion.getText()
                    .contains("Selenium")) {

                suggestion.click();

                System.out.println("Suggestion Selected");

                break;
            }
        }

        pause(5);

        driver.quit();
    }
}