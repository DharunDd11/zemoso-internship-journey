package org.example;

import org.testng.annotations.*;

public class TC2 {

    @BeforeClass
    void openBrowser() {
        System.out.println("10. Opening Edge Browser");
    }

    @AfterClass
    void closeBrowser() {
        System.out.println("17. Closing Edge Browser");
    }

    @BeforeMethod
    void login() {
        System.out.println("11. User Login");
    }

    @AfterMethod
    void logout() {
        System.out.println("13. User Logout");
    }

    @Test(priority = 1)
    void searchProduct() {
        System.out.println("12. Searching Product");
    }

    @Test(priority = 2)
    void makePayment() {
        System.out.println("14. Making Payment");
    }

    @BeforeSuite
    void generateReport() {
        System.out.println("1. Generating Extent Report");
    }

    @AfterSuite
    void flushReport() {
        System.out.println("18. Flushing Extent Report");
    }
}