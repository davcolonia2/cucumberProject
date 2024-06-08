Feature: page with multiple iframes

  @iframes
  Scenario: user can interact with all elements on the page
    Given user lands on expendtesting page
    When user clicks on video play button
    Then user can see "Your content goes here."
    When user enters the email
    And clicks subscribe button
    Then user can see "You are now subscribed!"