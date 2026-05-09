package org.example;

import org.testng.annotations.Test;

public class SamePriorityExample {

    @Test(priority = 1)
    void searchProduct() {
        System.out.println("Search Product");
    }

    @Test(priority = 1)
    void addToCart() {
        System.out.println("Add To Cart");
    }

    @Test(priority = 1)
    void payment() {
        System.out.println("Payment");
    }
}
