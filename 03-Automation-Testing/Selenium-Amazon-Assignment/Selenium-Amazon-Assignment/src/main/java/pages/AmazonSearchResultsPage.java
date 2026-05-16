package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AmazonSearchResultsPage {

    WebDriver driver;
    WebDriverWait wait;
    Logger logger = LogManager.getLogger(AmazonSearchResultsPage.class);

    public AmazonSearchResultsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void selectSamsungProduct() throws InterruptedException {

        logger.info("Search Results Page Loaded");

        // Pause so you can observe the search results
        Thread.sleep(3000);

        logger.info("Selecting Samsung Galaxy S24 From Results");

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//span[contains(text(),'Samsung Galaxy S24')]/ancestor::a)[1]")
        )).click();

        logger.info("Samsung Galaxy S24 Product Clicked");
    }
}