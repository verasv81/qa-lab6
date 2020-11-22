Feature: Poll feature

  Scenario: Community poll Functionality
    Given I am on Womens Page
    When I select "Lower price" option
    Then Notification that user participated in the poll