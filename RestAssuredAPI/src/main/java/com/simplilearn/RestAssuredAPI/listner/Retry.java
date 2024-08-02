package com.simplilearn.RestAssuredAPI.listner;

import org.testng.ITestResult;
import org.testng.internal.TestResult;

public class Retry {
	public static int count = 1;
	private static int maxTry=1;
	public boolean retry(TestResult iTestResult) {
		if(!iTestResult.isSuccess()) {
			if(count<maxTry) {
				count ++;
				iTestResult.setStatus(ITestResult.FAILURE);
				return true;
			}
			
		}
		else{
			iTestResult.setStatus(iTestResult.SUCCESS);
		}
		return false;
	}

}
