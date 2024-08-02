package com.simplilearn.TestNgDemos;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyTestListener implements ITestListener{
	public void onStart(ITestContext context) {
		System.out.println("on start method executed...");
	}
	public void onFinish(ITestContext context) {
		System.out.println("on finish method executed...");
	}
	public void onTestFaliure(ITestResult result) {
		System.out.println("on test faliure method executed... TestCase Name: "+result.getName());
	}
	public void onTestSkipped(ITestResult result) {
		System.out.println("on test skipped method executed...TestCase Name: "+result.getName());
	}
	public void onTestStart(ITestResult result) {
		System.out.println("on test start method executed...TestCase Name: "+result.getName());
	}
	public void onTestSuccess(ITestResult result) {
		System.out.println("on test success method executed...TestCase Name: "+result.getName());
	}
	



}
