Feature: Pop up practice
 @modal
  Scenario: Handle modal pop up
    Given user lands on Entry Ad page
    When a pop-up appears
    Then user is able to see "THIS IS A MODAL WINDOW"
    And user can close the pop-up