package com.simplilearn.E_CommerceAppTestingApache;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HomePage extends BaseTest{
	@Test
	public void HomePageTest() {
		Actions action = new Actions(driver);
		WebElement pages = driver.findElement(By.xpath("//*[@id=\"essenceNav\"]/div[2]/div[2]/ul/li[2]/a"));
		action.moveToElement(pages).perform();
		driver.findElement(By.xpath("//*[@id=\"essenceNav\"]/div[2]/div[2]/ul/li[2]/ul/li[8]/a")).click();
		try{
			driver.switchTo().alert().accept();
		}catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

}
