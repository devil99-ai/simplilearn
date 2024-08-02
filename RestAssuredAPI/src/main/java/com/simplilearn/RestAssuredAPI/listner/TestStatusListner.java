package com.simplilearn.RestAssuredAPI.listner;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestStatusListner implements ITestListener{
	
	private static String grtTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}
	public void onStart(ITestContext iTestContext) {
		System.out.println("initializing test cases "+iTestContext.getName());
	}
	public void onFinish(ITestContext iTestContext) {
		System.out.println("Finishing Test Cases "+iTestContext.getName());
		ExtentTestManager.endTest();
		ExtentManager.getReporter().flush();
	public void onTestStart(ITestContext iTestContext) {
		System.out.println("Starting test cases "+getTestMethodName(iTestResult)+ "start");		
		
		
	}
	public void onTestSuccess(ITestResult iTestResult) {
		System.out.println("test method "+getTestMethodName(iTestResult)+ "sccess");
		ExtentTestManager.getTest().log(logStatus.PASS, "Test Passed");
	}
	public void onTestFaliure(ITestResult iTestResult) {
		System.out.println("test method "+getTestMethodName(iTestResult)+ "failed");
		Object testClass = iTestResult.getInstance();
		ExtentTestManager.getTest().log(logStatus.FAIL, "Test failed");
		
	}
	public void onTestSkipped(ITestResult iTestResult) {
		System.out.println("test method "+getTestMethodName(iTestResult)+ "skipped");
		ExtentTestManager.getTest().log(logStatus.SKIP, "Test Skipped");
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		System.out.println("Test failed but with some sucess ratio" + getTestMethodName(iTestResult));
	}

}
