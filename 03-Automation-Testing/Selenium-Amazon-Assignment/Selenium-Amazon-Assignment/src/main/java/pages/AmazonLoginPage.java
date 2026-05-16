package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AmazonLoginPage {

    WebDriver driver;
    WebDriverWait wait;
    Logger logger = LogManager.getLogger(AmazonLoginPage.class);

    public AmazonLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void clickSignIn() {
        logger.info("Clicking Sign In Button");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-accountList"))).click();

        // Wait for the login page to fully load before proceeding
        logger.info("Waiting For Login Page To Load");
        wait.until(ExpectedConditions.urlContains("signin"));
    }

    public void enterEmail(String email) {
        logger.info("Entering Email: " + email);


        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@type='email' or @id='ap_email' or @name='email']")
        )).sendKeys(email);
    }

    public void clickContinue() {
        logger.info("Clicking Continue");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("continue"))).click();
    }

    public void enterPassword(String password) {
        logger.info("Entering Password");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_password"))).sendKeys(password);
    }

    public void clickLogin() {
        logger.info("Clicking Login Button");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("signInSubmit"))).click();
        logger.info("Login Submitted Successfully");
    }
}