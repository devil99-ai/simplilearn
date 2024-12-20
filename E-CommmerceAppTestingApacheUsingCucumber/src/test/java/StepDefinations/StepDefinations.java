package StepDefinations;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinations {
	WebDriver driver=null;
	@Given("user navigates to website")
	public void user_navigates_to_website() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("http://127.0.0.1/ATE_PEP2_Testing_Using_TestNG/");
		
	}
	@When("user clicks on add to cart")
	public void user_clicks_on_add_to_cart() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"essenceCartBtn\"]")).click();
		Thread.sleep(1000);
	}
	@Then("user click on Check Out button")
	public void user_click_on_check_out_button() {
	   driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/a")).click();
	}

	@Then("user fills billing Address")
	public void user_fills_billing_address() {
	    driver.findElement(By.xpath("//*[@id=\"first_name\"]")).sendKeys("Souvik");
	    driver.findElement(By.xpath("//*[@id=\"last_name\"]")).sendKeys("Sharma");
	    driver.findElement(By.xpath("//*[@id=\"company\"]")).sendKeys("Simplilearn Ltd");
	    driver.findElement(By.xpath("/html/body/div[4]/div/div/div[1]/div/form/div/div[4]/div/span")).click();
	    driver.findElement(By.xpath("/html/body/div[4]/div/div/div[1]/div/form/div/div[4]/div/ul/li[5]")).click();
	    driver.findElement(By.xpath("//*[@id=\"street_address\"]")).sendKeys("NALANDA 53/1 C, Manoj Arcade");
	    driver.findElement(By.xpath("//*[@id=\"street_address2\"]")).sendKeys("24th Main Rd, Sector 2, HSR Layout");
	    driver.findElement(By.xpath("//*[@id=\"postcode\"]")).sendKeys("560102");
	    driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys("Bengaluru");
	    driver.findElement(By.xpath("//*[@id=\"state\"]")).sendKeys("Karnataka");
	    driver.findElement(By.xpath("//*[@id=\"phone_number\"]")).sendKeys("1800-212-7688");
	    driver.findElement(By.xpath("//*[@id=\"email_address\"]")).sendKeys("svkshrm@gmail.com");
	    
	}

	@Then("user clicks on proceed button")
	public void user_clicks_on_proceed_button() {
	    driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div/a")).click();
	}



}
