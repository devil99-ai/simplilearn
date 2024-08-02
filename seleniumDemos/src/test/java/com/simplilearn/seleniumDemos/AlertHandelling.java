package com.simplilearn.seleniumDemos;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class AlertHandelling {
	@Test

	public void Alert() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
		System.out.println("Title is: "+ driver.getTitle());
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("/html/body/button")).click();
		org.openqa.selenium.Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("Alert title is: "+ alertText);
		Thread.sleep(5000);
		alert.accept();
		

}
}