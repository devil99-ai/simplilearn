Feature: Search for a line in google page
  Background: 
    Given I am on the homepage
  
  @regression
  Scenario: Fill in search form
   
    When I fill in "search" with:
    """
     Test Automation using selenium and cucumber
      """
