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
  
  
Scenario: Validating the data table headers in the class page
    Given Admin is on the home Page
    When Admin clicks the Class Navigation bar in the Header
    #Then Admin should see the " showing x to y of  z entries" and enabled pagination controls under the data table