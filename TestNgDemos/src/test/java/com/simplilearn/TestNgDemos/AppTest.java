package com.simplilearn.TestNgDemos;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest {
	
	ChromeDriver driver;
	@BeforeTest
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://simplilearn.com");
		
	}
	@Test
	public void verifyHomePageTitile() {
		String expectedTitle = "Simplilearn | Online Courses - Bootcamp & Certification Platform";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		
		System.out.println("Test: vrifyHomePage");
	}
   @AfterTest
   public void closeBrowser() {
	   driver.close();
	   System.out.println("AfterTest: closeBrowser");
   }
}
