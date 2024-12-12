package com.simplilearn.TestNgDemos;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestScreenshot {
	@Test
	
	public void runScenarioAndTakeScreenshot() throws Exception{
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://simplilearn.net/");
		
		ScreenShotControl control = new ScreenShotControl(driver);
		control.captureAndSaveScreenshot("C:\\Users\\svksh\\OneDrive\\Desktop\\screenshot.png");
		
		driver.close();
	
	
	
	}

}
