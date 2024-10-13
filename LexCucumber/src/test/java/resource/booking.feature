Feature: Booking test in packandgo site
  
 Background: 
  Given User is on packandgo login page 
  Scenario: 
    When User Login user go for booking ticket
    Then User fill all the details
    And proceed for booking
  Scenario: Successfull Booking
    When User clicks on proceed 
    Then User goes for payment 
    And After successfull payment user got booking confirmed message
