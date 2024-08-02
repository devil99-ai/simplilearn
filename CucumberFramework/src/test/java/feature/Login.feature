Feature: Login to facebook
  keywords summary: This test will verify login related scenarios to facebook.com

  Scenario: Login with invalid credentials
    Given: user navigated to facebook.com

    When user enters Username as "user1" and Password as "PASSWORD"
    And user clicks on login button
    Then login should be successful
