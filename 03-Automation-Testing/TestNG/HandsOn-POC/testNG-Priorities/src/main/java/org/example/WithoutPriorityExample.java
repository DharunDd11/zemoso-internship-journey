package org.example;

import org.testng.annotations.Test;

public class WithoutPriorityExample {

    @Test
    void payment() {
        System.out.println("Payment");
    }

    @Test
    void login() {
        System.out.println("Login");
    }

    @Test
    void searchProduct() {
        System.out.println("Search Product");
    }
}