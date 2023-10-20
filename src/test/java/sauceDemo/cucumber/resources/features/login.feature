Feature:  Login to the sauce demo web

  @Regression @Positive
  Scenario: User successfully login using valid credential
    Given user launch website sauce demo
    When user input valid username
    And user input valid password
    And user click login button
    Then user in dashboard page

  @Regression @Negative
  Scenario: User can't login with invalid password
    Given user launch website sauce demo
    When user input valid username
    And user input invalid password
    And user click login button
    Then user get error message