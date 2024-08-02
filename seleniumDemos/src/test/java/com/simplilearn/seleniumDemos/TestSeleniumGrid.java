package com.simplilearn.seleniumDemos;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSeleniumGrid {
	
	@Test
	public void verifySeleniumGridExecution() throws Exception{
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setCapability("browserVersion", 120);
		chromeOptions.setCapability("platform", "WINDOWS");
		
		chromeOptions.setCapability("se:name", "My Simple Test");
		
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.106:5555/"),chromeOptions);
	
		driver.get("https://simplilearn.net/");
		String actualTitle= "Simplilearn | Online Courses - Bootcamp & Certification Platform";
		String expectedTitle = driver.getTitle();
		
		Assert.assertEquals(actualTitle, expectedTitle);
		
		driver.quit();
	}

}
