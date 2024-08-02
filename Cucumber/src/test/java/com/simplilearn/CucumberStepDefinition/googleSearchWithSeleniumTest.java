package com.simplilearn.CucumberStepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class googleSearchWithSeleniumTest {
	
	WebDriver driver;
	
	@Given("browser is open")
	public void browser_is_open() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
	   
	}

	@And("user is on google search page")
	public void user_is_on_google_search_page() {
		driver.get("https://www.google.co.in/");
	   
	}

	@When("user enters a text in searchbar")
	public void user_enters_a_text_in_searchbar() {
		driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys("Atomation step by step");
		
	    
	}

	@And("hits enter")
	public void hits_enter() {
	    driver.findElement(By.xpath("//*[@id=\\\"APjFqb\\\"]")).submit();
	    driver.findElement(By.xpath("//*[@id=\\\"APjFqb\\\"]")).sendKeys(Keys.ENTER);
	}

	@Then("user is navigated to search result")
	public void user_is_navigated_to_search_result() {
		driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/table/tbody/tr[2]/td/div/div/div/div/h3/a"));
		driver.getPageSource().contains("Online Course");
		driver.close();
		driver.quit();
	  
	}


}
