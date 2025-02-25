@sortClass
Feature: Sort Class Dteatils

  Background: 
    Given Admin is on login Page
    When Admin enter valid data from excel row "1"
    Then Admin clicks the Class Navigation bar in the Header

  Scenario: Sort Class by Batch name
    Given Admin is on the Manage class page
    When Admin clicks on the Batchname sort icon
    Then Admin should see Class details are sorted by Batch Name

  Scenario: Sort Class by Batch name
    Given Admin is on the Manage class page
    When Admin clicks on the Class topic sort icon
    Then Admin should see Class details are sorted by Class Topic

  Scenario: Sort Class by Class Description
    Given Admin is on the Manage class page
    When Admin clicks on the Class description  sort icon
    Then Admin should see Class details are sorted by Class Description

  Scenario: Sort Class by StatusSD
    Given Admin is on the Manage class page
    When Admin clicks on the Status sort icon
    Then Admin should see Class details are sorted by Status

  Scenario: Sort Class by Class date
    Given Admin is on the Manage class page
    When Admin clicks on the Class Date sort icon
    Then Admin should see Class details are sorted by Class Date

  Scenario: Sort Class by staff name
    Given Admin is on the Manage class page
    When Admin clicks on the Staff Name sort icon
    Then Admin should see Class details are sorted by Staff name
