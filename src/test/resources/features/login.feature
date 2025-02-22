@login
Feature: Login Page Verification
Background: User is on base page

  Scenario: Verify Admin is able to land on login page
    Given The browser is open
    When Admin gives the correct LMS portal URL    
    Then Admin should land on the login page

  Scenario Outline: Validate login with valid data in all field
    Given Admin is on login Page
    When Admin enter valid data from excel row "<row_index>"
    Then Admin should land on home page

      Examples:
        | row_index |
        |         2 |