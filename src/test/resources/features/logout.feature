@logout
Feature: LogOut Page Verification
  Background: Admin is logged into the application
  @logout-01
  Scenario: Validate login with valid data in all field
    Given Admin is on login Page
    When Admin enter valid data from excel row "1"
    Then Admin should land on home page
    When Admin clicks on the logout in the menu bar
    Then Admin should be redirected to login page
  @logout-02
  Scenario: Verify back button function
    Given Admin is on login Page
    When Admin enter valid data from excel row "1"
    Then Admin should land on home page
    When Admin clicks on the logout in the menu bar
    When Admin clicks  browser back button
    Then Admin should receive error message
