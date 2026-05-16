package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.List;

public class AmazonCartPage {

    WebDriver driver;
    WebDriverWait wait;
    Logger logger = LogManager.getLogger(AmazonCartPage.class);

    public AmazonCartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void verifyProductInCart(String productName) {

        logger.info("Verifying Cart Contents");

        // Wait for cart page to settle
        // Try the item title span — Amazon uses different classes on different cart layouts
        By cartItemLocator = By.xpath(
                "//div[@data-name='Active Items']//span[@class='a-truncate-cut'] " +
                        "| //div[contains(@class,'sc-list-item')]//span[@class='a-truncate-cut'] " +
                        "| //span[@class='a-truncate-cut']"
        );

        // Check if cart is empty first
        List<WebElement> emptyMsg = driver.findElements(
                By.xpath("//*[contains(text(),'Your Amazon Cart is empty') or contains(text(),'cart is empty')]")
        );

        if (!emptyMsg.isEmpty()) {
            logger.error("Cart Is Empty — Product Was NOT Added");
            Assert.fail("Cart is empty. The add-to-cart action did not work.");
        }

        // Wait for items
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartItemLocator));

        // Get all item names
        List<WebElement> allItems = driver.findElements(cartItemLocator);
        logger.info("Total Items In Cart: " + allItems.size());

        boolean found = false;
        for (WebElement item : allItems) {
            String itemText = item.getText().trim();
            logger.info("Cart Item: " + itemText);
            if (itemText.toLowerCase().contains(productName.toLowerCase())) {
                found = true;
                logger.info(" Product Found In Cart: " + itemText);
                break;
            }
        }

        Assert.assertTrue(found,
                "'" + productName + "' was NOT found in cart. Items present: " + allItems.size());

        logger.info(" Cart Verification Passed — " + productName + " Is In Cart");
    }
}