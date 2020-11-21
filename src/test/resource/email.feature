Feature: Email feature

  Scenario: Email input
    Given I am on Sign up dialog
    When I fill invalid email
    Then input field works properly