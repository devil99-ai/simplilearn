Feature: Login Action

  Scenario: Successful Login with Valid Credentials
    Given User is on Home Page
    When User Navigate to LogIn Page
    And User enters UserName and Password
    Then Message displayed DASHBOARD

  Scenario: Successful LogOut
    When user selects iphone12mini
    And clicks on Add To Cart
    Then user go for checkout and fill details
    And submit the order
    Then user click on logout and navigates back to the home page
