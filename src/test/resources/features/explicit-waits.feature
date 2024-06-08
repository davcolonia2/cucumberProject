@heroku_app
  Feature: Practice for explicit waits

    Scenario: Utilize explicit waits with a condition heroku-app
      Given user is on heroku dynamic loading page
      When user clicks on example one link
      And user clicks on the start button
      Then user can see a "Hello World" message