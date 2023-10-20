Feature:  Checkout products

  @Regression @Positive
  Scenario: User successfully to checkout the product
    Given user already login to dashboard
    When user choose the product
    Then user click Add to cart button
    And user click icon cart
    Then user click checkout button
    Given user input identity
    Then user click continue button
    And user click finish button
    Then user click back home button
