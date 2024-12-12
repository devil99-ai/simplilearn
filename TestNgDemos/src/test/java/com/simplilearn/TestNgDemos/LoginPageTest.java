package com.simplilearn.TestNgDemos;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageTest {
	
	ChromeDriver driver;
	LoginPage Page;
	@BeforeTest
	public void Setup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		Page = new LoginPage(driver);
		
	}
	@Test
	public void TestLogin() {
		boolean loginResult = Page.loginuser("tushar6749@gmail.com", "tushar6749@gmail.com");
		AssertJUnit.assertTrue(loginResult);
	}
	
	@AfterMethod
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
