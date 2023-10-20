Feature:  Cart

  @Regression @Positive
  Scenario: User successfully add products to cart
    Given user already login to sauce demo web
    When user click add to cart
    And user click cart icon
    Then user is on your cart page