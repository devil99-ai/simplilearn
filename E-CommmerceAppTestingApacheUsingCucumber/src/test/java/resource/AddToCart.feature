Feature: AddToCartPage
  I want to add a product to my cart
  So that I can purchase it later

  Scenario: Add a product to the cart
    Given user navigates to website
    When user clicks on add to cart
    Then user click on Check Out button
    And user fills billing Address
    Then user clicks on proceed button
