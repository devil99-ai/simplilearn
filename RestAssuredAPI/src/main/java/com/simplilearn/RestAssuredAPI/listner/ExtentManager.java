package com.simplilearn.RestAssuredAPI.listner;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	public static ExtentReports extent;
	public synchronized static ExtentReports getReporter() {
		if(extent ==null) {
			String workingDir = System.getProperty("user-dir");
			if (System.getProperty("os.name").toLowerCase().contains("win")) {
				extent = new ExtentReports(workingDir+"\\ExtentReports\\ExtentReportResults.html", true);
				extent.loadConfig(new File(workingDir+"\\extent-cong.xml"));
				
			}
			else if(System.getProperty("os.name").toLowerCase().contains("mac")) {
				extent = new ExtentReports(workingDir+"/ExtentReports/ExtentReportResults.html", true);
				extent.loadConfig(new File(workingDir+"/extent-cong.xml"));
			}
		}
		return extent;
	}

}
