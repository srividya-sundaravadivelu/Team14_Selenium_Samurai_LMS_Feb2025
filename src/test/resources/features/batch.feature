@Batch
Feature: Batch Page Navigation

  Background: User is on base page
    Given Admin is on login Page
    When Admin enter valid data from excel row "1"

  Scenario: Verify Admin Navigate to Batch page successfully
    Given Admin is on the home Page
    When Admin Clicks on the Batch menu from the header
    Then Admin should be in the Manage Batch Page

  Scenario: Validate "Title" in Batch Page
    Given Admin is on the home Page
    When Admin Clicks on the Batch menu from the header
    Then Admin should see the "LMS-Learning Management System" Title

  Scenario: Validate "heading" in the Batch Page
    Given Admin is on the home Page
    When Admin Clicks on the Batch menu from the header
    Then Admin should see the "Manage Batch" Heading

  Scenario: Validate disabled "Delete Icon" under the header in the Batch Page
    Given Admin is on the home Page
    When Admin Clicks on the Batch menu from the header
    Then Admin should see the disabled "Delete Icon" under the header

  Scenario: Validate pagination in the Batch Page
    Given Admin is on the home Page
    When Admin Clicks on the Batch menu from the header
    Then Admin should see the enabled pagination controls under the data table
    
    Scenario Outline: Validate edit,delete and checkbox icon in each data rows
    Given Admin is on the home Page
    When Admin Clicks on the Batch menu from the header
    Then Admin should see the "<icon>" in each row
    
    Examples:
    |icon|
    |edit icon in each row|
    |delete icon in each row|
    |checkbox in each row|
    |Admin should see the datatable headers Batch name,Batch Description,Batch Status,No Of classes,Program Name,Edit/Delete|
    |checkbox  in the datatable header row|
    |sort icon next to all Datatable headers|
    
   Scenario: Validate all the fields exist in pop up 
   Given Admin is on the Batch Details Pop Up WIndow
   When  Admin checks all the fields are enabled
   Then  The pop up should include the fields Batch Name Number of classes and Description as text box Program Name as drop down Status as radio button
    
    Scenario: Validate batchname prefix selected program name
    Given Admin is on the Batch Details Pop Up WIndow
    When  Admin selects program name present in the dropdown
    Then  Admin should see selected program name in the batch name prefix box
    
    Scenario: Validate batch name suffix box should accept only numbers
    Given  Admin is on the Batch Details Pop Up WIndow
    When   Admin enters alphabets in batch name suffix box
    Then   Admin should get error message below the text box of respective field
    
    Scenario: Validate batch name prefix box is not editable
    Given Admin is on the Batch Details Pop Up WIndow
    When  Admin enters alphabets in batch name prefix box
    Then  Admin should see empty text box
    
    #Scenario: Validate input data only for mandatory fields
    #Given Admin is on the Batch Details Pop Up WIndow
    #When Admin enters the data only to the mandatory fields and clicks save button
    #Then Admin should get a successful message 
