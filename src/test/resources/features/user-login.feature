Feature: Login Functionality

#  Scenario: User can login with valid credentials
#    Given user navigates to orangeHRM login page
#    When user logs in with valid username and password
#    Then user is redirected to the homepage
#    * quit the driver
#
#    Scenario: User cannot login with invalid login
#      Given user navigates to orangeHRM login page
#      When user logs in with invalid username and password
#      Then user is given error
#      *  quit the driver
#
Scenario Outline: User cannot login with invalid credentials <"test case">
  When user logs in with username "<username>" and password "<password>"
  And user clicks login button
  Then user can see an error message "<errorMessage>"
  Examples:
    | username | password | errorMessage |
    | invalid | invalid | Invalid credentials |
    |  | invalid | Username cannot be empty |
    | invalid | invalid | Invalid credentials |
    | invalid |  | Password cannot be empty |

