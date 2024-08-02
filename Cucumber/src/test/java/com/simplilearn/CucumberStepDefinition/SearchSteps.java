package com.simplilearn.CucumberStepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps {
		@Given("I have a search field n the flipkart page")
		public void iHvaeASearchFieldOnFilpkartPage() {
			System.out.println("Step1. I am on search page...");
			
		}
		@When("I search for a product named {string}")
		public void searchForProduct(String productName) {
			System.out.println("Step2: search the product with name:"+productName);
		}
		@And("I entered the price as {string}")
		public void enterPrice(String price) {
			System.out.println("Step3: Entered the price as: "+price);
		}
		@Then("Product with name {string} should be displayed")
		public void productWithNameShouldBeDisplayed(String productName) {
			System.out.println("Step4: product "+productName+" is displayed");
		}
		

	

}
