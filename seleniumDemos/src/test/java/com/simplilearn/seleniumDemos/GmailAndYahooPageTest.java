package com.simplilearn.seleniumDemos;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GmailAndYahooPageTest {
	@Test
	public void GamiTesting() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://mail.google.com/");
		driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("svkshrm@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();
		driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("Sdfghjk13");
		driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/div[3]")).click();
	}
		@Test
	public void YahooTest() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://in.mail.yahoo.com/");
		driver.findElement(By.xpath("//*[@id=\"signin-main\"]/div[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"login-username\"]")).sendKeys("svkshrm@gamil.com");
		driver.findElement(By.xpath("//*[@id=\"login-signin\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"arkose-submit\"]")).click();
		
	}

}
