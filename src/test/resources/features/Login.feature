Feature: Login Functionality

  Scenario Outline: Login with valid credentials
    Given user navigates to login screen
    When user enters "<username>" as username
    And user enters "<password>" as password
    And user clicks on login button
    Then user should be on the home page

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
      | error_user              | secret_sauce |
      | visual_user             | secret_sauce |

  Scenario Outline: Login with invalid credentials
    Given user navigates to login screen
    When user enters "<username>" as username
    And user enters "<password>" as password
    And user clicks on login button
    Then user should see an error message on the login screen

    Examples:
      | username        | password     |
      | invalid         | invalid      |
      | locked_out_user | secret_sauce |

  Scenario Outline: User logs out
    Given user navigates to login screen
    When user enters "<username>" as username
    And user enters "<password>" as password
    And user clicks on login button
    And user should be on the home page
    And user clicks on hamburger menu
    And user clicks on logout link
    Then user should be on the login page

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
      | error_user              | secret_sauce |
      | visual_user             | secret_sauce |