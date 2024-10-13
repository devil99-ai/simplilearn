package StepsDefinations;

import java.time.Duration;

import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;

import com.beust.jcommander.converters.FloatConverter;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinations {
	WebDriver driver;
	WebElement closeBtn;
	@Given("User launch Pizzahut application with {string}")
	public void user_launch_pizzahut_application_with(String string) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(string);
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
	}

	@When("User wait for auto location black pop up screen")
	public void user_wait_for_auto_location_black_pop_up_screen() throws InterruptedException {
		driver.wait(1000);
	    closeBtn = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[7]/div/div/button")));
	}

	@Then("User close the pop up screen")
	public void user_close_the_pop_up_screen() {
	    try{
	    	closeBtn.click();
	    	System.out.println("able to find close button and clicked");
	    }catch (Exception e) {
			System.out.println("black screen not displayed");
		}
	}

	@Then("User see pop up for delivery asking for enter location")
	public void user_see_pop_up_for_delivery_asking_for_enter_location() {
	    try {
	    	Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[4]/div/div/div/div[2]")).isDisplayed());
	    }catch (Exception e) {
		// TODO: handle exception
	    	e.printStackTrace();
	    }
	}

	@Then("User type address as {string}")
	public void user_type_address_as(String string) {
	    try {
	    	driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[4]/div/div/div/div[2]/form/div/div[1]/input")).sendKeys(string);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
	}

	@Then("User select first auto populate drop down option")
	public void user_select_first_auto_populate_drop_down_option() {
	    try {
	    	Thread.sleep(5000);
	    	driver.findElement(By.xpath("//div[text()='Lulu Mall Bengaluru']")).click();
	    	Thread.sleep(5000);
	    	try {
				driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/div[2]/button")).click();
			} catch (Exception e) {
				// TODO: handle exception
			} 
	    	System.out.println("Location added and proceed to next steps successfully ");
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("some error in location adding proceeding to next steps");
		}
	}

	@When("User navigate to deails page")
	public void user_navigate_to_deails_page() throws InterruptedException {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.ScrollBy(0,350)", "");
	    driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[5]/div[2]/a")).click();
	    driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[4]/div/div/div/div[2]/form/div/div[2]/div/button/span")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/div[2]/button")).click();
	}

	@Then("User validate vegetarian radio button flag is off")
	public void user_validate_vegetarian_radio_button_flag_is_off() {
	    Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[1]/div[3]/div[2]/div[1]/div/input")).isEnabled());
	    System.out.println("Radio button is off");
	}

	@Then("User clicks on Pizzas menu bar option")
	public void user_clicks_on_pizzas_menu_bar_option() {
	    driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[1]/div[3]/div[1]/div/a[2]")).click();
	}

	@When("User select add button of any pizza from Recommended")
	public void user_select_add_button_of_any_pizza_from_recommended() {
	    driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[1]/div[3]/div[2]/div[2]/span/div[1]/a[3]/div[3]/div/button")).click();
	}

	@Then("User see that the pizza is getting added under Your Basket")
	public void user_see_that_the_pizza_is_getting_added_under_your_basket() {
	    Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"basket\"]/div[2]")).isDisplayed());
	}

	@Then("User validate pizza price plus Tax is checkout price")
	public void user_validate_pizza_price_plus_tax_is_checkout_price() {
	    Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div/div[2]/div[2]/div/div[3]/span[2]")).isDisplayed());
	}

	@Then("User validate checkout button contains Item count")
	public void user_validate_checkout_button_contains_item_count() {
	    Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div/div[2]/div[3]/div[2]/div/div/button/span[1]/span")).isDisplayed());
	}

	@Then("User validate checkout button contains total price count")
	public void user_validate_checkout_button_contains_total_price_count() {
		String price = driver.findElement(By.xpath("//*[@id=\\\"app\\\"]/div/div[1]/div[2]/div/div[2]/div[3]/div/div/div/a/span[3]/span")).getText();
	    Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div/div[2]/div[3]/div/div/div/a/span[3]/span")).isDisplayed());
	}

	@Then("User clicks on Drinks option")
	public void user_clicks_on_drinks_option() {
		
	    driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[1]/div[3]/div[1]/div/a[7]")).click();
	}

	@Then("User select Pepsi option to add into the Basket")
	public void user_select_pepsi_option_to_add_into_the_basket() {
	    driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[1]/div[3]/div[2]/div[2]/span/div/a[1]/div[3]/div/button")).click();
	}

	@Then("User see {int} items are showing under checkout button")
	public void user_see_items_are_showing_under_checkout_button(Integer int1) {
	    
	}

	@Then("User see total price is now more than before")
	public void user_see_total_price_is_now_more_than_before() {
		String price = driver.findElement(By.xpath("//*[@id=\\\"app\\\"]/div/div[1]/div[2]/div/div[2]/div[3]/div/div/div/a/span[3]/span")).getText();
		float f=Float.parseFloat(price);  
		//Assert.assertTrue(driver.findElement(By.xpath("")))
	}

	@Then("User remove the Pizza item from Basket")
	public void user_remove_the_pizza_item_from_basket() {
	    driver.findElement(By.xpath("//*[@id=\"basket\"]/div[6]/div/div[1]/button[2]")).click();
	}

	@Then("see Price tag got removed from the checkout button")
	public void see_price_tag_got_removed_from_the_checkout_button() {
	    Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\\\"app\\\"]/div/div[1]/div[2]/div/div[2]/div[3]/div/div/div/a/span[3]/span")).isDisplayed(),false);
	}

	@Then("User see {int} item showing in checkout button")
	public void user_see_item_showing_in_checkout_button(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("User Clicks on Checkout button")
	public void user_clicks_on_checkout_button() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div/div[2]/div[3]/div[2]/div/div/button/span[2]")).click();
	}

	@Then("User see minimum order required pop up is getting displayed")
	public void user_see_minimum_order_required_pop_up_is_getting_displayed() {
	    boolean popUp = driver.findElement(By.xpath("/html/body/div[7]/div/div/div")).isDisplayed();
	    Assert.assertTrue(popUp);
	}
	@After
	   public void tearDown(){

	       driver.quit();
	 
	   }





}
