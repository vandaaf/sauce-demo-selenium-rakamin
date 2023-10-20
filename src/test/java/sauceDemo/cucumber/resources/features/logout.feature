Feature:  Logout from sauce demo web

  @Regression @Positive
  Scenario: User successfully login using valid credential
    Given user already login
    When user click sidebar menu
    And user click logout
    Then user in login page
