package com.simplilearn.TestNgDemos;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCaseDemo {
	ChromeDriver driver;
	String url;
	
	@BeforeMethod
	public void init() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		url = "https://newsapi.org/";
	}
	@Test
	public void TestCase() {
		driver.get(url);
		String actualTitle = driver.getTitle();
		String expectedTitle = "News API – Search News and Blog Articles on the Web";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	@AfterMethod
	void destroy() {
		driver.close();
		System.out.println("After Method");
		
	}

}
