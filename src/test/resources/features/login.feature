@login
Feature: Login Page Verification

  @TC_login1
  Scenario: Verify Admin is able to land on login page
    Given The browser is open
    When Admin gives the correct LMS portal URL    
    Then Admin should land on the login page 