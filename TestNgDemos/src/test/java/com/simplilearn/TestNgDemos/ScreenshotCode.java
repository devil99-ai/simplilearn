package com.simplilearn.TestNgDemos;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotCode {
	@Test

	public void screenShot() throws IOException {
		// TODO Auto-generated method stub
		   WebDriverManager.chromedriver().setup();
		   ChromeDriver driver = new ChromeDriver();
		   driver.get("https://www.facebook.com/");
		   driver.findElement(By.id("email")).sendKeys("Hello");
		   //Used to Take screenshot 
		   TakesScreenshot scr = (TakesScreenshot)driver;
		   
		   // Saving the screenshot in this
		   File src = scr.getScreenshotAs(OutputType.FILE);
		 
		   
		   File dest = new File("C:\\Users\\svksh\\OneDrive\\Desktop\\fb.png");
		   FileUtils.copyFile(src,dest);
		   System.out.println("driver too screenshot");
		    
	}

}