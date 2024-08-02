package com.simplilearn.TestNgDemos;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTests {
	ChromeDriver driver;
	@BeforeTest
	public void initDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	@Test
	public void testCase() {
		driver.get("https://simplilearn.net/");
	}
	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
