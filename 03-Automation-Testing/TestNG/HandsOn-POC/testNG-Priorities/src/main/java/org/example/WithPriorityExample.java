package org.example;

import org.testng.annotations.Test;

public class WithPriorityExample {

    @Test(priority = 1)
    void login() {
        System.out.println("Login");
    }

    @Test(priority = 2)
    void searchProduct() {
        System.out.println("Search Product");
    }

    @Test(priority = 3)
    void payment() {
        System.out.println("Payment");
    }
}