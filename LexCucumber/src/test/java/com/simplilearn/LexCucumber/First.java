package com.simplilearn.LexCucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class First {
	static WebDriver driver;
	static String url="http://vjeemys-19:3333/EDUBank/ ";
@Given("^User navigates to the Home Page$")
public void user_navigates_to_the_Home_Page() throws Exception {
    // Write code here that turns the phrase above into concrete actions
   // throw new PendingException();
	driver=new ChromeDriver();
	driver.get(url);
}
@When("^user Enters the Signup Details$")
public void user_Enters_the_Signup_Details() throws Exception {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
	driver.findElement(By.name("loginName")).sendKeys("Steven");
	driver.findElement(By.name("password")).sendKeys("Steven!123");
	driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/form/button")).click();
}
@Then("^User Logged In to EDU$")
public void user_Logged_In_to_EDU() throws Exception {
    // Write code here that turns the phrase above into concrete actions
  //  throw new PendingException();
	System.out.println(driver.getTitle());
	driver.quit();
}


}
