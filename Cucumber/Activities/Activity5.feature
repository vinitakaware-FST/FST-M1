@activity5
Feature: Data driven test with Example

  Scenario Outline: Testing with Data from Scenario
    Given User is on Login page5
    When User enters "<Usernames>" & "<Passwords>"
    Then Read page title and confirmation message
    And Close the Browser5

    Examples:
      | Usernames | Passwords |
      | admin     | password  |
      | adminUser | Password  |