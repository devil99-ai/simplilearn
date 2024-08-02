package com.simplilearn.TestNgDemos;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderDemo {
	ChromeDriver driver;
	LoginPage Page;
	
	@DataProvider(name="login-data-provider")
	public Object[][] loginCredentialsProvider(){
		Object[][] credentials= {
				{"tuser6749@gmil.com", "tuser6749@gmil.com"},
				{"admin@gmail.com","pass1234@"}
		};
		return credentials;
	
	}
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		Page = new LoginPage(driver);
	}
	@Test(dataProvider="login-data-provider")
	public void testLoginWithDataProvider(String email, String password) {
		boolean loginResult = Page.loginuser(email, password);
		Assert.assertTrue(loginResult);
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
