@class
Feature: Class Page Validation

  Background: User is on base page
    Given Admin is on login Page
    When Admin enter valid data from excel row "1"

  Scenario: Validating the class manage page
    Given Admin is on the home Page
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should land on the Manage class page

  Scenario: Validating the Title in the Manage class page
    Given Admin is on the home Page
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see the "LMS - Learning Management System" Title

  Scenario: Validating the Header in the Manage class page
    Given Admin is on the home Page
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see the "Manage Class" Header

  Scenario: Validating Search bar in class page
    Given Admin is on the home Page
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see the Search Bar in Manage class page

  Scenario: Validating the data table headers in the class page
    Given Admin is on the home Page
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see the dataTable heading like "Batch Name, Class Topic, Class Description, Status, Class Date, Staff Name, Edit / Delete"

  Scenario: Validating the text and pagination icon in the classpage
    Given Admin is on the home Page
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see the showing x to y of  z entries and enabled pagination controls under the data table

  Scenario: Validating the text and pagination icon in the classpage
    Given Admin is on the home Page
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see the showing x to y of  z entries and enabled pagination controls under the data table

  Scenario: Validate the sort icon of all the field in datatable
    Given Admin is on the home Page
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see the Sort icon of all the field in the datatable.

  Scenario: Validate the Delete button under the Manage class
    Given Admin is on the home Page
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see the Delete button under the Manage class page header.

  Scenario: Validate the total no of classes in manage class page
    Given Admin is on the home Page
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see Total no of classes in below of the data table.
