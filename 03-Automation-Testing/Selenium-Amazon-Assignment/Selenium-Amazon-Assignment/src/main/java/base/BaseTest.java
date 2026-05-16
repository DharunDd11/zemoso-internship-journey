package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public WebDriver driver;

    Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeTest
    public void setUp() {

        logger.info("Setting Up Chrome Driver");

        // Selenium 4.6+ handles driver management automatically
        // No need for WebDriverManager dependency
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);

        logger.info("Opening Amazon");
        driver.get("https://www.amazon.in");
        logger.info("Amazon Home Page Opened");
    }

    @AfterTest
    public void tearDown() {
        logger.info("Closing Browser");
        driver.quit();
    }
}