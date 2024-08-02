package com.simplilearn.seleniumDemos;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CssSelectorMethod {

	@Test
	public void testCssSelectorMethod() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://test.qatechhub.com/form-elements/");
		driver.findElement(By.cssSelector("input[value=Female]")).click();
	}
	@Test
	public void testCssSelectorMethod1() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.facebook.com/");
		//driver.findElement(By.cssSelector("#email")).sendKeys("svkshrm@gmail.com");
		driver.findElement(By.cssSelector(".inputtext _55r1 _6luy")).sendKeys("svkshrm@gmail.com");
		driver.manage().timeouts(). implicitlyWait(Duration.ofSeconds(50));
	}

	
}
