//package com.simplilearn.PizzaHutJunitAndCucumberTest.Features;
//
//import java.time.Duration;
//import java.util.NoSuchElementException;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Wait;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class StepDefinition {
//	WebDriver driver;
//	@Given("User launch Pizzahut application with {string}")
//	public void user_launch_pizzahut_application_with(String string) {
//	   WebDriverManager.chromedriver().setup();
//	   driver=new ChromeDriver();
//	   driver.get(string);
//	   //driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[7]/div/div/div/div/div/button")).click();
//	}
//
//	@When("User wait for auto location black pop up screen")
//	public void user_wait_for_auto_location_black_pop_up_screen() throws InterruptedException {
//		
//		driver.manage().deleteAllCookies();
//		driver.manage().window().maximize();
////	    try{
////	    	driver.findElement(By.id("location-pop-up-close")).isDisplayed();
////	    }catch (NoSuchElementException e) {
////            // Pop-up not found, continue with the test
////            System.out.println("Pop-up not found, continuing with the test.");
////        }
//	}
//
//	@Then("User close the pop up screen")
//	public void user_close_the_pop_up_screen() {
////	    try {
////	    	driver.findElement(By.id("location-pop-up-close")).click();
////	    }catch (NoSuchElementException e) {
////            // Pop-up not found, continue with the test
////            System.out.println("Pop-up not found, continuing with the test.");
////        }
//	}
//
//	@Then("User see pop up for delivery asking for enter location")
//	public void user_see_pop_up_for_delivery_asking_for_enter_location() {
//	    try {
//	    	driver.findElement(By.xpath("/html/body/div[8]/div/div/button")).click();
//	    }catch (Exception e) {
//	    	e.printStackTrace();
//	    }
//	}
//
//	@Then("User type address as {string}")
//	public void user_type_address_as(String string) throws InterruptedException {
//		driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/div[2]/button/span")).click();
//		Thread.sleep(5000);
//	    driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[4]/div/div/div/div[2]/form/div/div[1]/input")).sendKeys(string);
//	    
//	}
//
//	@Then("User select first auto populate drop down option")
//	public void user_select_first_auto_populate_drop_down_option() throws InterruptedException {
//		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[4]/div/div/div/div[2]/form/div/div[2]/div")).click();
//        Thread.sleep(5000);
//       
//    }
//	
//
//	@When("User navigate to deails page")
//	public void user_navigate_to_deails_page() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("User validate vegetarian radio button flag is off")
//	public void user_validate_vegetarian_radio_button_flag_is_off() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("User clicks on Pizzas menu bar option")
//	public void user_clicks_on_pizzas_menu_bar_option() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@When("User select add button of any pizza from Recommended")
//	public void user_select_add_button_of_any_pizza_from_recommended() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("User see that the pizza is getting added under Your Basket")
//	public void user_see_that_the_pizza_is_getting_added_under_your_basket() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("User validate pizza price plus Tax is checkout price")
//	public void user_validate_pizza_price_plus_tax_is_checkout_price() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("User validate checkout button contains Item count")
//	public void user_validate_checkout_button_contains_item_count() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("User validate checkout button contains total price count")
//	public void user_validate_checkout_button_contains_total_price_count() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("User clicks on Drinks option")
//	public void user_clicks_on_drinks_option() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("User select Pepsi option to add into the Basket")
//	public void user_select_pepsi_option_to_add_into_the_basket() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("User see {int} items are showing under checkout button")
//	public void user_see_items_are_showing_under_checkout_button(Integer int1) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("User see total price is now more than before")
//	public void user_see_total_price_is_now_more_than_before() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("User remove the Pizza item from Basket")
//	public void user_remove_the_pizza_item_from_basket() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("see Price tag got removed from the checkout button")
//	public void see_price_tag_got_removed_from_the_checkout_button() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("User see {int} item showing in checkout button")
//	public void user_see_item_showing_in_checkout_button(Integer int1) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("User Clicks on Checkout button")
//	public void user_clicks_on_checkout_button() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("User see minimum order required pop up is getting displayed")
//	public void user_see_minimum_order_required_pop_up_is_getting_displayed() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//
//
//
//}
