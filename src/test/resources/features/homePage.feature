Feature: Homework

  @admin
  Scenario: User can see all tabs
    Given user navigates to orangeHRM login page
    When user logs in with username "yoll-student" and password "Bootcamp5#"
    Then user is redirected to the homepage
    And user can see the following tabs:
    |Admin       |
    |PIM         |
    |Leave       |
    |Time        |
    |Recruitment |
    |My Info     |
    |Performance |
    |Dashboard   |
    |Directory   |
    |Maintenance |