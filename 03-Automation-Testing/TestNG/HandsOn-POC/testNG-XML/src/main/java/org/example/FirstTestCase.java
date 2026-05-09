package org.example;

import org.testng.annotations.Test;

public class FirstTestCase {

    @Test(priority = 1)
    void setup() {
        System.out.println("Setup");
    }

    @Test(priority = 2)
    void login() {
        System.out.println("Login");
    }

    @Test(priority = 3)
    void teardown() {
        System.out.println("Teardown");
    }
}