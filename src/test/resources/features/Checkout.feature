Feature: Checkout Functionality

  Scenario: User can checkout an item
    Given user navigates to login screen
    When user enters valid username
    And user enters valid password
    And user clicks on login button
    And user clicks on the backpack item
    And user clicks on the add to cart button
    And user clicks on the cart button
    And user clicks on the checkout button
    And user fills first name in checkout process
    And user fills last name in checkout process
    And user fills zip code in checkout process
    And user clicks on checkout continue button
    And user clicks on finish button
    Then user should be on the checkout complete page