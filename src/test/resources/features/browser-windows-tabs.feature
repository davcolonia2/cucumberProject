Feature: Browser Windows and Tabs Handling
  @window
  Example: Get unique identifier of the main window
    Given I land on Demo QA Browser Windows Page
    Then I can retrieve the unique identifier of the main window
    When I click on "NEW TAB" button
#    Then a new window is created
#    And I can see the content of new tab is "This is a sample page"
#    When I close the new tab or window
#    Then I switch to main window
#    And I can see the url of the window is endpoint with "/browser-windows#google_vignette"