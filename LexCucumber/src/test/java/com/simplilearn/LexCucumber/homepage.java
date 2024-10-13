package com.simplilearn.LexCucumber;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class homepage {
	WebDriver driver=null;
	@Given("User navigates to the PackAndGo site")
	public void user_navigates_to_the_pack_and_go_site() {
		driver=new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver.get("https://www.packngo.in/");
	    
	}

	@When("user Enters in the home page")
	public void user_enters_in_the_home_page() {
	    String homepage = driver.getTitle();
	    System.out.println(homepage);
	    Assert.assertEquals(homepage, "Domestic, International Tour Packages | International Holidays Packages, Travel From India, Travel Agents In India - Pack N Go Holiday]s");
	}

	@Then("User get the content of about")
	public void user_get_the_content_of_about() {
	  driver.navigate().to("https://www.packngo.in/about.php");
	  String page=driver.getPageSource();
	  System.out.println(page);
	}

}
