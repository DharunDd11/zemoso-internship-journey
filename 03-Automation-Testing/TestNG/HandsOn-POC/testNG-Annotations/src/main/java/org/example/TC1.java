package org.example;

import org.testng.annotations.*;

public class TC1 {

    @BeforeClass
    void launchBrowser() {
        System.out.println("1. Launching Chrome Browser");
    }

    @AfterClass
    void closeBrowser() {
        System.out.println("8. Closing Browser");
    }

    @BeforeMethod
    void loginToApplication() {
        System.out.println("2. Logging into Application");
    }

    @AfterMethod
    void logoutFromApplication() {
        System.out.println("4. Logging out from Application");
    }

    @Test(priority = 1)
    void addProductToCart() {
        System.out.println("3. Adding Product To Cart");
    }

    @Test(priority = 2)
    void removeProductFromCart() {
        System.out.println("5. Removing Product From Cart");
    }

    @BeforeTest
    void connectToDatabase() {
        System.out.println("0. Connecting To Database");
    }

    @AfterTest
    void disconnectDatabase() {
        System.out.println("9. Disconnecting Database");
    }
}