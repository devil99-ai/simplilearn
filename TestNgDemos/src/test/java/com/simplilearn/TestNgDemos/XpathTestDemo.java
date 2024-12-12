package com.simplilearn.TestNgDemos;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathTestDemo {
	@Test
	public void testCheckBoxByXPath() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("https://test.qatechhub.com/form-elements/");
		//driver.findElement(By.xpath("//*[@id=\"wpforms-49-field_3_2\"]")).click();
		driver.get("https://amazon.com/");
		driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[3]")).click();
		String expectedUrl = "https://www.amazon.com/registries?ref_=nav_cs_registry&ref_=nav_cs_registry";
		String currentUrl = driver.getCurrentUrl();
		AssertJUnit.assertEquals(currentUrl, expectedUrl);
		
	}

}
