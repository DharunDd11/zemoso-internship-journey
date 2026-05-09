package org.example;

import org.testng.annotations.Test;

public class DependencySuccess {

    @Test
    void login() {
        System.out.println("Login Successful");
    }

    @Test(dependsOnMethods = "login")
    void searchProduct() {
        System.out.println("Product Searched");
    }

    @Test(dependsOnMethods = "searchProduct")
    void addToCart() {
        System.out.println("Product Added To Cart");
    }

    @Test(dependsOnMethods = {"login", "addToCart"})
    void payment() {
        System.out.println("Payment Successful");
    }
}