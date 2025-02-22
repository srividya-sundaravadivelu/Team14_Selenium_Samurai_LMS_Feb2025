@login
Feature: Login Page Verification
Background: Admin should land on the login page

  Scenario: Verify Admin is able to land on login page
    Given The browser is open
    When Admin gives the correct LMS portal URL
    Then Admin should land on the login page

  Scenario: Verify Admin is able to land on home page with invalid URL
    Given The browser is open
    When Admin enter url from excel row "2"
    Then Admin should receive application error

  Scenario: Verify broken link
    Given The browser is open
    When Admin gives the correct LMS portal URL
    Then HTTP response >= 400. Then the link is broken

  Scenario: Verify the text spelling in the page
    Given Admin gives the correct LMS portal URL
    When Admin should land on the login page
    Then Admin should see correct spellings in all fields

  Scenario: Verify application name
    Given Admin gives the correct LMS portal URL
    When Admin should land on the login page
    Then Admin should see  LMS - Learning Management System

  Scenario: Verify company name
    Given Admin gives the correct LMS portal URL
    When Admin should land on the login page
    Then Admin should see company name below the app name

  Scenario: Validate sign in content
    Given Admin gives the correct LMS portal URL
    When Admin should land on the login page
    Then Admin should see "Please login to LMS application"

  Scenario: Verify text field is present
    Given Admin gives the correct LMS portal URL
    When Admin should land on the login page
    Then Admin should see two text field

  Scenario: Verify text on the first field
    Given Admin gives the correct LMS portal URL
    When Admin should land on the login page
    Then Admin should  see "User" in the first text field

  Scenario: Verify dropdown is present
    Given Admin gives the correct LMS portal URL
    When Admin should land on the login page
    Then Admin should see one dropdown

  Scenario: Verify asterisk next to USER text
    Given Admin gives the correct LMS portal URL
    When Admin should land on the login page
    Then Admin should see asterisk mark symbol next to text for mandatory fields

  Scenario: Verify text on the second field
    Given Admin gives the correct LMS portal URL
    When Admin should land on the login page
    Then Admin should "Password" in the second text field

  Scenario: Verify asterisk mark symbol next to password text
    Given Admin gives the correct LMS portal URL
    When Admin should land on the login page
    Then Admin should see asterisk mark symbol next to password text

  Scenario: Verify placeholder in dropdown to select role
    Given Admin gives the correct LMS portal URL
    When Admin should land on the login page
    Then Admin should see "select the role " placeholder in dropdown

  Scenario: Verify dropdown option to select role
    Given Admin gives the correct LMS portal URL
    When Admin should land on the login page
    Then Admin should see "Admin , staff, student" options in dropdown

  Scenario: Verify the alignment input field for the login
    Given Admin gives the correct LMS portal URL
    When Admin should land on the login page
    Then Admin should see input field on the centre of the page

  Scenario: verify Login button is present
    Given Admin gives the correct LMS portal URL
    When Admin should land on the login page
    Then Admin should see login button

  Scenario: Verify input descriptive text in user field
    Given Admin gives the correct LMS portal URL
    When Admin should land on the login page
    Then Admin should see "user" in "gray" color

  Scenario: Verify input descriptive text in password field
    Given Admin gives the correct LMS portal URL
    When Admin should land on the login page
    Then Admin should see "password" in "gray" color

  Scenario: Validate login with valid data in all field
    Given Admin is on login Page
    When Admin enter data from excel row "1"
    Then Admin should land on home page

  Scenario:  Validate login with invalid data
    Given Admin is on login Page
    When Admin enter data from excel row "3"
    Then Error message "Invalid username and password Please try again"

  Scenario:  Validate login with null user name
    Given Admin is on login Page
    When Admin enter data from excel row "4"
    Then Error message "Please enter your user name"

  Scenario:  Validate login with null password
    Given Admin is on login Page
    When Admin enter data from excel row "5"
    Then Error message "Please enter your password"

  Scenario: verify login button action through keyboard
    Given Admin is on login Page
    When Admin enter data from excel row "1"
    When Admin clicks login button through keyboard
    Then Admin should land on home page

  Scenario: verify login button action through mouse
    Given Admin is on login Page
    When Admin enter data from excel row "1"
    When Admin clicks login button through mouse
    Then Admin should land on home page