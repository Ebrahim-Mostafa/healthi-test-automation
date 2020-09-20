Feature: Test the login functionality on healthi test environment

  Scenario Outline: User Registration
  the user should be able to login with correct username and password
    Given user is on the login page
    When user enters correct "<username>"
    And user enters correct  "<password>"
    And user click on signin button
    Then patient search page appears
    Examples:
      | username | password |
      | sa001    | goport!! |
