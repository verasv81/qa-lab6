Feature: Search feature

  Scenario: Search Functionality
    Given I am on Womens Page
    When I search for "Skirt"
    Then the result should be list of products matching search