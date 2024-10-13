package com.simplilearn.LexCucumber;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Test_Steps {
	WebDriver driver;
	@Given("I am on the homepage")
	public void i_am_on_the_homepage() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
	}

	@When("I fill in {string} with:")
	public void i_fill_in_with(String string, String docString) {
		driver.findElement(By.name("q")).sendKeys(docString);
	}

}
