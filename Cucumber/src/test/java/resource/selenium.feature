Feature: feature to test with selenium

  Scenario: Validate google search is working
    Given browser is open
    And user is on google search page
    When user enters a text in searchbar
    And hits enter
    Then user is navigated to search result
