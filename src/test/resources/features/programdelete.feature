
@tag
Feature: Manage Program - Delete Program
  Background: Admin is on program page after reaching home

  @tag1
  Scenario: Verify delete feature
  #Given Admin is on Program page
  When Admin clicks on delete button on program page
  Then Admin will get confirm deletion popup in program page
    
  @tag2
  Scenario: Verify Admin is able to click Yes 
    Given Admin is on Confirm deletion form of program page
    When Admin clicks on "Yes" button for a program page
    Then Admin can see Successful Program Deleted message in program page
    
   @tag3
  Scenario: Verify Admin is able to click No 
    Given Admin is on Confirm deletion form of program page
    When Admin clicks on "No" button for a program page
    Then Admin can see Confirmation form disappears in program page 
    
    @tag4
  Scenario: Verify Admin is able to click 
    Given 
    When
    Then
    

    
