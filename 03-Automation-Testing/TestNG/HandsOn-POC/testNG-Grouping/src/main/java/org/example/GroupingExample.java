package org.example;


import org.testng.annotations.Test;

public class GroupingExample {

    @Test(groups = {"smoke"})
    void login() {
        System.out.println("Login Test");
    }

    @Test(groups = {"smoke", "regression"})
    void searchProduct() {
        System.out.println("Search Product Test");
    }

    @Test(groups = {"regression"})
    void addToCart() {
        System.out.println("Add To Cart Test");
    }

    @Test(groups = {"regression"})
    void payment() {
        System.out.println("Payment Test");
    }

    @Test(groups = {"sanity"})
    void logout() {
        System.out.println("Logout Test");
    }
}