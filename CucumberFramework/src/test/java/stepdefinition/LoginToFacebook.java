package stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import helper.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginToFacebook {
	@Given("user navigated to facebook.com")
	public void user_navigated_to_facebook() {
		TestBase.driver.get("https://www.facebook.com/");
	}
	@When("user enters Username as {String} and Password as {String}")
	public void user_enters_Username_and_Password(String args1, String args2) {
		TestBase.driver.findElement(By.id("email")).sendKeys(args1);
		TestBase.driver.findElement(By.id("pass")).sendKeys(args2);
		
	}
	
	@When("user clicks on login button")
	public void  user_clicks_on_login_button() {
		WebElement ele = TestBase.driver.findElement(By.name("login"));
		JavascriptExecutor jsx = (JavascriptExecutor)TestBase.driver;
		jsx.executeScript("arguments[0].click", ele);
	}
	@Then("login should be successful")
	public void login_should_be_successful() {
		System.out.println("");
		
	}

}
