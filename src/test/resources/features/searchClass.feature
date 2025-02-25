@searchClass

Feature: Search Functionality in Manage Class Page

  Background:
		Given Admin is on login Page
		When Admin enter valid data from excel row "1"
		And Admin clicks "Class" on the navigation bar

  Scenario: Search class by Batch Name
    Given Admin is on the Manage class page
    When Admin enter the Batch Name in search textbox
    Then Admin should see Class details are searched by Batch Name

  Scenario: Search class by Class Topic
    Given Admin is on the Manage class page
    When Admin enter the Class topic in search textbox
    Then Admin should see Class details are searched by Class topic

  Scenario: Search class by Staff Name
    Given Admin is on the Manage class page
    When Admin enter the Staff Name in search textbox
    Then Admin should see Class details are searched by Staff name
