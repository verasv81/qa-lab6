Feature: Google search functionality

  Scenario: Verify search with different languages
    Given The google page is loaded
    When Search for:
    | name |
    | computer |
    | кошка    |
    | cadou |
    Then Present list of 10 search results

  Scenario: Verify case sensitive
    Given The google page is loaded
    When Search for "computer" and "COMPUTER"
    Then Search Should have same result

  Scenario: Verify weather Google service
    Given The google page is loaded
    When Search for "weather"
    Then Present Weather service

  Scenario: Verify Google converter services then the converter service should be displayed in the top of the search result
    Given The google page is loaded
    When Search for converter value "10$ in euro"
    Then Converter is displayed on the top