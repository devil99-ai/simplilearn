package com.simplilearn.TestNgDemos;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class LocatorsIdentifiers {
	@Test
	public void testLocatorsIdentifiers() {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("svkshrm@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("Souvik99@");
		//driver.findElement(By.name("login")).click();
		driver.findElement(By.tagName("button")).click();
		//driver.quit();
		
	}
	@Test
	public void testLink() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.findElement(By.className("a-button-input")).click();
		//driver.findElement(By.linkText("Sell")).click();
		driver.findElement(By.partialLinkText("Cust")).click();

		
		
	}

}
