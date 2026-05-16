package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AmazonHomePage {

    WebDriver driver;
    WebDriverWait wait;
    Logger logger = LogManager.getLogger(AmazonHomePage.class);

    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void searchProduct(String product) {
        logger.info("Typing Product Name: " + product);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox"))).sendKeys(product);

        logger.info("Clicking Search Button");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-search-submit-button"))).click();

        logger.info("Search Submitted For: " + product);
    }
}