Feature: Login Functionality

  Scenario: Login with valid credentials
    Given user navigates to login screen
    When user enters valid username
    And user enters valid password
    And user clicks on login button
    Then user should be on the home page

  Scenario: Login with invalid credentials
    Given user navigates to login screen
    When user enters a invalid username as "invalid_username"
    And user enters a invalid password as "invalid_password"
    And user clicks on login button
    Then user should should see an error message on the login screen


  Scenario: User logs out
    Given user navigates to login screen
    When user enters valid username
    And user enters valid password
    And user clicks on login button
    And user should be on the home page
    And user clicks on hamburger menu
    And user clicks on logout link
    Then user should be on the login page