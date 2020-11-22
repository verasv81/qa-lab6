Feature: Cart feature

  Scenario: Cart Functionality
    Given I am on Womens Page
    When I add to cart a product and edit quantity
    Then Quantity allows only integer values