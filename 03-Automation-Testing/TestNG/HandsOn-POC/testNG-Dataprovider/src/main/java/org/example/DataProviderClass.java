package org.example;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "loginData")
    Object[][] data()
    {
        return new Object[][]{

                {"student", "Password123"},
                {"incorrectUser", "Password123"},
                {"student", "wrongPassword"}

        };
    }
}