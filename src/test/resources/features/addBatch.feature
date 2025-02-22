Feature: Add New Batch

  Background: User is on base page
    Given Admin is on login Page
    When Admin enter valid data from excel row "1"
    And Admin Clicks on the Batch menu from the header

  Scenario: Verify sub menu displayed in batch menu bar
    Then Admin should see sub menu in menu bar as Add New Batch

  Scenario: Validate Admin able to click on the Add new Batch Option
    Given Admin is on the batch page
    When Admin clicks on Add New batch under the batch menu bar
    Then Admin should see the Batch Details pop up window

  Scenario: Validate Edit icon feature in any row
    Given Admin is on the batch page
    Then Admin should see the Batch details pop up window

  Scenario: Validate program name  value is disabled to edit
    Given Admin is on the batch page
    Then Admin should see Program name value field is disabled for editing

  Scenario: Validate batch name  value is disabled to edit
    Given Admin is on the batch page
    Then Admin should see batch name value field is disabled for editing

  #Scenario: Validate editing description and No. of classes fields with invalid data in the pop up
    #Given Admin is on the Batch Details Page
    #When Admin Updates any fields with invalid data and click save button
    #Then Admin should get a error message under the respective field 
    #
   
