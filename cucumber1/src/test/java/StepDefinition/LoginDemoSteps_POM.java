package StepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObject.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

//public class LoginDemoSteps_POM {
//	WebDriver driver;
//	LoginPage login = new LoginPage(driver);
//	@Given("browser is open")
//	public void browser_is_open() {
//	   WebDriverManager.chromedriver().setup();
//	   driver = new ChromeDriver();
//	   driver.get("https://practice.expandtesting.com/login");
//	}
//
//	@And("user is on login page")
//	public void user_is_on_login_page() {
//		
//	    driver.navigate().to("https://practice.expandtesting.com/login");;
//	}
//
//	@When("user enters (.*) and (.*)")
//	public void user_enters_username_and_password(String username, String password) throws InterruptedException {
//		
//		login.enter_username(username);
//		login.enter_password(password);
////	    driver.findElement(By.id("username")).sendKeys(username);
////	    driver.findElement(By.id("passowrd")).sendKeys(password);
//		Thread.sleep(5000);
//	}
//
//	@When("user clicks on login")
//	public void user_clicks_on_login() {
//		login.press_login_button();
//	   // driver.findElement(By.id("submit")).click();
//	}
//
//	@Then("user is navigated to the home page")
//	public void user_is_navigated_to_the_home_page() {
//	  login.logout_now();
//	}




//}
