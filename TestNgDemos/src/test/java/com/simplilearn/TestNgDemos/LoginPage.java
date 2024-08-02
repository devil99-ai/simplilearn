package com.simplilearn.TestNgDemos;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	private ChromeDriver driver;
	private static final String URL ="https://newsapi.org/login";
	
	private By email;
	private By password;
	private By Login;
	
	public LoginPage(ChromeDriver driver) {
		this.driver = driver;
		this.driver.get(URL);
		initializeWebElements();
	}
	public void initializeWebElements() {
		email = By.xpath("//*[@id=\"Email\"]");
		password = By.xpath("//*[@id=\"Password\"]");
		Login = By.tagName("button");
	}
	
	public boolean loginuser(String loginemail, String loginpassword) {
		driver.findElement(email).sendKeys(loginemail);
		driver.findElement(password).sendKeys(loginpassword);
		driver.findElement(Login).click();
		
		String afterloginurl = "https://newsapi.org/account";
		boolean until = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.urlToBe(afterloginurl));
		return until;
	}

}
