package org.example;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SecondTestCase {

    @Test(priority = 1)
    void setup() {
        System.out.println("Setup");
    }

    @Test(priority = 2)
    void addCustomer() {
        System.out.println("Add Customer");
        Assert.assertEquals(1, 1);
    }

    @Test(priority = 3)
    void searchCustomer() {
        System.out.println("Search Customer");
    }

    @Test(priority = 4)
    void teardown() {
        System.out.println("teardown");
    }
}