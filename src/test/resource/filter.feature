Feature: Filter feature

  Scenario: Filter Functionality
    Given I am on Womens Page
    When I change filter range from "0" to "260"
    Then Products are filtered within price range