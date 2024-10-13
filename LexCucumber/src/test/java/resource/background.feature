Feature: Test the background feature in AUT
  
 Background: 
  Given User is on EDU Teller Login Page 
  Scenario: 
    When User checks for Add Money
    Then Enter Account number details and Search
    And Closes 
  Scenario: User checks for My Customers
    When The user checks for My Customers link 
    Then All Customer details displayed
    And Closes The Browser
