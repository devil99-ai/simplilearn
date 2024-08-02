package com.simplilearn.RestAssuredAPI.listner;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.LogStatus;

public class ExtentBase {
	@BeforeMethod
	public void beforeMethod(Method method) {
		ExtentTestManager.startTest(method.getName());
		
	}
	@AfterMethod
	protected void afterMethod(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, result.getThrowable());
		}else if(result.getStatus()==ITestResult.SKIP) {
			ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped"+result.getThrowable());
		}else {
			ExtentTestManager.getTest().log(LogStatus.PASS,"Test Passed");
		}
		ExtentTestManager.getReporter().endTest(ExtentTestManager.getTest());
		ExtentManager.getReporter().flush();
	}
	protected String getStackTarce(Throwable e) {
		StringWriter sw=new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		return sw.toString();
	}
	

}
