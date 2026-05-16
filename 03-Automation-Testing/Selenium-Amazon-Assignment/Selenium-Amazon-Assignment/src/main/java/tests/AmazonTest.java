package tests;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;
import java.util.ArrayList;

public class AmazonTest extends BaseTest {

    Logger logger = LogManager.getLogger(AmazonTest.class);

    @Test
    public void amazonTest() throws InterruptedException {


        AmazonLoginPage login = new AmazonLoginPage(driver);
        login.clickSignIn();
        login.enterEmail("dharundhobba@gmail.com");
        login.clickContinue();
        login.enterPassword("amazon123");
        login.clickLogin();


        AmazonHomePage home = new AmazonHomePage(driver);
        home.searchProduct("Samsung Galaxy S24");


        AmazonSearchResultsPage results = new AmazonSearchResultsPage(driver);
        results.selectSamsungProduct();


        Thread.sleep(2000);

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        if (tabs.size() > 1) {
            logger.info("New Tab Detected — Switching To Product Tab");
            driver.switchTo().window(tabs.get(tabs.size() - 1));
        } else {
            logger.info("Product Opened In Same Tab — No Switch Needed");
        }


        logger.info("Waiting For Product Page To Load");
        WebDriverWait tabWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        tabWait.until(ExpectedConditions.urlContains("amazon.in/"));
        logger.info("Product Page URL Ready: " + driver.getCurrentUrl());


        AmazonProductPage product = new AmazonProductPage(driver);
        product.addToCart();

        product.openCart();

       
        AmazonCartPage cart = new AmazonCartPage(driver);
        cart.verifyProductInCart("Samsung Galaxy S24");
    }
}