@activity2
Feature: Data driven test without Example

  Scenario: Testing with Data from Scenario
    Given User is on Login page one
    When User enter username and password
    Then Read the page title and confirmation messages
    And Close Browser