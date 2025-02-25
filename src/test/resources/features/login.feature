@login
Feature: Login Page Verification

  Background: Admin should land on the login page

  @login-01
  Scenario: Verify Admin is able to land on login page
    Given The browser is open
    When Admin gives the correct LMS portal URL
    Then Admin should land on the login page

  @login-02
  Scenario: Verify Admin is able to land on home page with invalid URL
    Given The browser is open
    When Admin enter url from excel row "2"
    Then Admin should receive application error

  @login-03
  Scenario: Verify broken link
    Given The browser is open
    When Admin gives the correct LMS portal URL
    Then HTTP response >= 400. Then the link is broken

  @login-04
  Scenario: Verify the text spelling in the page
    Given Admin gives the correct LMS portal URL
    When Admin should land on the login page
    Then Admin should see correct spellings in all fields

  @login-05
  Scenario: Verify application name
    Given Admin gives the correct LMS portal URL
    When Admin should land on the login page
    Then Admin should see  LMS - Learning Management System

  @login-06
  Scenario: Verify company name
    Given Admin gives the correct LMS portal URL
    When Admin should land on the login page
    Then Admin should see company name below the app name

  @login-07
  Scenario: Validate sign in content
    Given Admin gives the correct LMS portal URL
    When Admin should land on the login page
    Then Admin should see "Please login to LMS application"

  @login-08
  Scenario: Verify text field is present
    Given Admin gives the correct LMS portal URL
    When Admin should land on the login page
    Then Admin should see two text field

  @login-09
  Scenario: Verify text on the first field
    Given Admin gives the correct LMS portal URL
    When Admin should land on the login page
    Then Admin should  see "User" in the first text field

  @login-10
  Scenario: Verify dropdown is present
    Given Admin gives the correct LMS portal URL
    When Admin should land on the login page
    Then Admin should see one dropdown

  @login-11
  Scenario: Verify asterisk next to USER text
    Given Admin gives the correct LMS portal URL
    When Admin should land on the login page
    Then Admin should see asterisk mark symbol next to text for mandatory fields

  @login-12
  Scenario: Verify text on the second field
    Given Admin gives the correct LMS portal URL
    When Admin should land on the login page
    Then Admin should "Password" in the second text field

  @login-13
  Scenario: Verify asterisk mark symbol next to password text
    Given Admin gives the correct LMS portal URL
    When Admin should land on the login page
    Then Admin should see asterisk mark symbol next to password text

  @login-14
  Scenario: Verify placeholder in dropdown to select role
    Given Admin gives the correct LMS portal URL
    When Admin should land on the login page
    Then Admin should see "select the role " placeholder in dropdown

  @login-15
  Scenario: Verify dropdown option to select role
    Given Admin gives the correct LMS portal URL
    When Admin should land on the login page
    Then Admin should see "Admin , staff, student" options in dropdown

  @login-16
  Scenario: Verify the alignment input field for the login
    Given Admin gives the correct LMS portal URL
    When Admin should land on the login page
    Then Admin should see input field on the centre of the page

  @login-17
  Scenario: verify Login button is present
    Given Admin gives the correct LMS portal URL
    When Admin should land on the login page
    Then Admin should see login button

  @login-18
  Scenario: Verify input descriptive text in user field
    Given Admin gives the correct LMS portal URL
    When Admin should land on the login page
    Then Admin should see "user" in "gray" color

  @login-19
  Scenario: Verify input descriptive text in password field
    Given Admin gives the correct LMS portal URL
    When Admin should land on the login page
    Then Admin should see "password" in "gray" color

  @login-20
  Scenario: Validate login with valid data in all field
    Given Admin is on login Page
    When Admin enter valid data from excel row "1"
    Then Admin should land on home page

  @login-21
  Scenario: Validate login with invalid data
    Given Admin is on login Page
    When Admin enter valid data from excel row "3"
    Then Error message "Invalid username and password Please try again"

  @login-22
  Scenario: Validate login with null user name
    Given Admin is on login Page
    When Admin enter valid data from excel row "4"
    Then Error message "Please enter your user name"

  @login-23
  Scenario: Validate login with null password
    Given Admin is on login Page
    When Admin enter valid data from excel row "5"
    Then Error message "Please enter your password"

  @login-24
  Scenario: verify login button action through keyboard
    Given Admin is on login Page
    When Admin enter valid data only from excel row "1"
    When Admin clicks login button through keyboard
    Then Admin should land on home page

  @login-25
  Scenario: verify login button action through mouse
    Given Admin is on login Page
    When Admin enter valid data only from excel row "1"
    When Admin clicks login button through mouse
    Then Admin should land on home page
