@programdelete
Feature: Manage Program - Delete Program

  Background: 
    Given Admin is on login Page
    When Admin enter valid data from excel row "1"
    Then Admin clicks on Program page

  @tag1
  Scenario: Verify delete feature
    When Admin clicks on delete button on program page
    Then Admin will get confirm deletion "popup" in program page


  @tag2
  Scenario: Verify Admin is able to click Yes
    Given Admin is on Confirm deletion form of program page
    When Admin clicks on Yes button for a program page
    Then Admin can see Successful Program Deleted message in program page

  @tag3
  Scenario: Verify Admin is able to click No
    Given Admin is on Confirm deletion form of program page
    When Admin clicks on No button for a program page
    Then Admin can see Confirmation form disappears in program page

  @tag4
  Scenario: Verify Admin is able to check multiple programs for delete
    When Admin clicks on multiple programs for delete in program page
    Then Admin will get confirm deletion popup in program page for multiple deletes


  @tag5
  Scenario: Verify Admin is able to click Yes for multiple delete
    Given Admin clicks on multiple programs for delete in program page
    When Admin clicks on Yes button for multiple delete of program page 
    Then Admin can see Successful Program Deleted message in program page for multiple 
   
  @tag6
  Scenario: Verify Admin is able to close the window with "X"
    Given Admin clicks on multiple programs for delete in program page
    When Admin Click on X button for delete of program page
    Then Admin can see Confirm Deletion form disappear from program page
