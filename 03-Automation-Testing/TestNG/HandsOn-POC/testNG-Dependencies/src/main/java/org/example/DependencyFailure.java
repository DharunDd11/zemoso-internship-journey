package org.example;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyFailure {

    @Test
    void login() {
        System.out.println("Login Failed");
        Assert.fail();
    }

    @Test(dependsOnMethods = "login")
    void searchProduct() {
        System.out.println("Product Searched");
    }

    @Test(dependsOnMethods = "searchProduct")
    void addToCart() {
        System.out.println("Product Added To Cart");
    }

    @Test(dependsOnMethods = "addToCart")
    void payment() {
        System.out.println("Payment Successful");
    }
    @Test(dependsOnMethods = "payment",alwaysRun = true)
    void close_app(){
        System.out.println("app is closed");
    }
}
