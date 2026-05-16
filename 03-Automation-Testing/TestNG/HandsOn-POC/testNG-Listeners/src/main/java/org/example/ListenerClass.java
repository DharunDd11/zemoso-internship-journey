package org.example;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass implements ITestListener {

    @Override
    public void onStart(ITestContext context)
    {
        System.out.println("Started execution");
    }

    @Override
    public void onFinish(ITestContext context)
    {
        System.out.println("Finished execution");
    }

    @Override
    public void onTestStart(ITestResult result)
    {
        System.out.println("Test Started");
    }

    @Override
    public void onTestSuccess(ITestResult result)
    {
        System.out.println("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        System.out.println("Test Failed");
    }

    @Override
    public void onTestSkipped(ITestResult result)
    {
        System.out.println("Test Skipped");
    }
}