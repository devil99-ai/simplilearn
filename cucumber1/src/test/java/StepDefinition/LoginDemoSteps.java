//package StepDefinition;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class LoginDemoSteps {
//	WebDriver driver;
//	@Given("browser is open")
//	public void browser_is_open() {
//	   WebDriverManager.chromedriver().setup();
//	   driver = new ChromeDriver();
//	   driver.get("https://practicetestautomation.com/practice-test-login/");
//	}
//
//	@And("user is on login page")
//	public void user_is_on_login_page() {
//	    driver.navigate().to("https://practicetestautomation.com/practice-test-login/");;
//	}
//
//	@When("user enters (.*) and (.*)")
//	public void user_enters_souvik_and_password(String username, String password) {
//	    driver.findElement(By.id("username")).sendKeys(username);
//	    driver.findElement(By.id("passowrd")).sendKeys(password);
//	}
//
//	@When("user clicks on login")
//	public void user_clicks_on_login() {
//	    driver.findElement(By.id("submit")).click();
//	}
//
//	@Then("user is navigated to the home page")
//	public void user_is_navigated_to_the_home_page() {
//	  driver.navigate().to("https://practicetestautomation.com/logged-in-successfully/");
//	}
//
//
//
//
//}
