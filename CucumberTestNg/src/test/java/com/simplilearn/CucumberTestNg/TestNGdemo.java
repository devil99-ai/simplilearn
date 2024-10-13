package com.simplilearn.CucumberTestNg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java8.En;


public class TestNGdemo implements En{
	WebDriver driver;
	String url= "https://www.facebook.com/";
	public void mysteps() {
	Given("^The Facebook application is open$", () -> {
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
	});

	When("^Enter the credentials for login$", () -> {
	    driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("svkshrm@gmail.com");
	    driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("Souvik99@");
	    driver.findElement(By.xpath("//*[@id=\"u_0_5_yL\"]")).click();
	});

	Then("^Verify the successful login$", () -> {
	    String title = driver.getTitle();
	    System.out.println(title);
	});

}}
