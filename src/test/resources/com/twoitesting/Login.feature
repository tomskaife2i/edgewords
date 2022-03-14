Feature: Secure logins for the edgewords site

  Scenario: Login with valid username and password
    Given I am on the login page
    When I use the username "edgewords" and the password "edgewords123"
    Then I am logged in


  Scenario: Attempt login with invalid credentials
    Given I am on the login page
    When I use the username "blah" and the password "blah"
    Then I fail to log in


  Scenario Outline: Multiple logins
    Given I am on the login page
    When I use the username "<Username>" and the password "<Password>"
    Then I am logged in
    Examples:
      | Username  | Password     |
      | edgewords | edgewords123 |
      | webdriver | edgewords123 |