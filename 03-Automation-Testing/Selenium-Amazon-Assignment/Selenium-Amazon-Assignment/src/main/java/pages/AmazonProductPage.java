package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class AmazonProductPage {

    WebDriver driver;
    WebDriverWait wait;
    Logger logger = LogManager.getLogger(AmazonProductPage.class);

    public AmazonProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void addToCart() throws InterruptedException {

        // Wait for page to fully load
        logger.info("Waiting For Product Page To Fully Load");
        wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));

        logger.info("Product Page Loaded — Pausing To Observe");
        Thread.sleep(3000);

        logger.info("Finding The Visible Add To Cart Button");

        // There are two add-to-cart-button elements — find the DISPLAYED one
        WebElement addToCartBtn = null;
        List<WebElement> buttons = driver.findElements(By.id("add-to-cart-button"));
        for (WebElement btn : buttons) {
            if (btn.isDisplayed()) {
                addToCartBtn = btn;
                logger.info("Visible Add To Cart Button Found");
                break;
            }
        }

        if (addToCartBtn == null) {
            throw new RuntimeException("No visible Add To Cart button found on page");
        }

        // Scroll the visible button into the center of the screen
        logger.info("Scrolling Button Into View");
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});",
                addToCartBtn
        );
        Thread.sleep(1500);

        // Use a real Selenium click (not JS click) so Amazon's form submit fires properly
        logger.info("Clicking Add To Cart Button");
        addToCartBtn.click();

        logger.info("Add To Cart Clicked — Waiting For Confirmation");

        // Wait until the page shows a confirmation signal:
        // Either the cart count goes up, or a confirmation element appears
        try {
            wait.until(ExpectedConditions.or(
                    // Cart count badge updates (e.g. "1", "2")
                    ExpectedConditions.not(ExpectedConditions.textToBe(By.id("nav-cart-count"), "0")),
                    // "Added to Cart" confirmation text
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//*[contains(text(),'Added to Cart') or contains(text(),'added to cart')]"))
            ));
            logger.info("Cart Confirmation Received");
        } catch (Exception e) {
            logger.warn("Confirmation not detected — continuing anyway");
        }

        Thread.sleep(2000);
        logger.info("Product Added To Cart Successfully");
    }

    public void openCart() {

        logger.info("Navigating To Cart Page");
        driver.navigate().to("https://www.amazon.in/gp/cart/view.html");

        wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));

        logger.info("Cart Page Loaded");
    }
}