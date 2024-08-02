package com.simplilearn.ProjectSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class seleniumAutomation {
	@Test
	public void testWebpage(){
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.udio.com/");
		driver.findElement(By.xpath("/html/body/section/div[1]/div[2]/div[1]/div/div[2]/button[1]")).click();
		try {
			driver.wait(1000);

			driver.findElement(By.xpath("//*[@id=\"radix-:rc1:\"]/div[2]/div[4]/button[2]")).click();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
