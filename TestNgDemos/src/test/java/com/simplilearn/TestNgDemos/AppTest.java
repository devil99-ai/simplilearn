package com.simplilearn.TestNgDemos;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest {
	DesiredCapabilities dc;
	WebDriver driver;
	@BeforeTest
	public void launchBrowser() {
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.WIN11);
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		try {
			driver = new RemoteWebDriver(new URL("http://192.168.0.206:4444"),dc);
			driver.get("https://simplilearn.com");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
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
