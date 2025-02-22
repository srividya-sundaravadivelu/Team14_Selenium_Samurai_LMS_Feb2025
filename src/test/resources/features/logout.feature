@login
Feature: LogOut Page Verification
  Background: Admin is logged into the application

  Scenario: Validate login with valid data in all field
    Given Admin is on login Page
    When Admin enter data from excel row "1"
    Then Admin should land on home page
    When Admin clicks on the logout in the menu bar
    Then Admin should be redirected to login page

  Scenario: Verify back button function
    Given Admin is on login Page
    When Admin enter data from excel row "1"
    Then Admin should land on home page
    When Admin clicks on the logout in the menu bar
    When Admin clicks  browser back button
    Then Admin should receive error message
