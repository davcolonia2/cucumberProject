Feature: Search Functionality

  @search
  Scenario Outline: User can search for a product
    Given user navigates to best buy
    When user enters "<productName>" in search box
    Examples:
    |productName        |
    |iPhone Pro 15      |
    |Samsung Galaxy 24  |
    |Blackberry 2024    |
