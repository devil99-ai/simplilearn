package com.simplilearn.RestAssuredAPI.listner;

import java.util.HashMap;
import java.util.Map;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentTestManager {
	static Map extentTestMap = new HashMap();
	static ExtentReports extent = ExtentManager.getReporter();
	
	public static synchronized ExtentTest getTest() {
		return (ExtentTest) extentTestMap.get((int) (Thread.currentThread().getId()));
	}
	public static synchronized void endTest() {
		extent.endTest((ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId())));

	}
	public static synchronized ExtentTest startTest(String testname) {
		return startTest(testname);
	}

}
