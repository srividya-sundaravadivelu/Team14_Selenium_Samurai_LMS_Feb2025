@AddNewClass
Feature: Add new class

  Background: User is on base page
    Given Admin is on login Page
    When Admin enter valid data from excel row "2"
    And Admin clicks the Class Navigation bar in the Header
    
    #################### Navigation From Manage Class ####################
    
         Scenario: Class link on navigation bar
    Given Admin is on the Manage class page
    When Admin clicks on Class link on Manage Class page
    Then Admin is redirected to class page
    
    Scenario: Navigation to Program page from Manage Class page
    Given Admin is on the Manage class page
    When Admin clicks on Program link on Manage Class page
    Then Admin is redirected to program page from class page 
    
    Scenario: Navigation to Batch page from Manage Class page
    Given Admin is on the Manage class page
    When Admin clicks on Batch link on Manage Class page
    Then Admin is redirected to batch page from class page 
    
    Scenario: Navigation to Home page from Manage Class page
    Given Admin is on the Manage class page
    When Admin clicks on Home link on Manage Class page
    Then Admin is redirected to home page from class page 
    
    Scenario: Navigation to Home page from Manage Class page
    Given Admin is on the Manage class page
    When Admin clicks on Logout link on Manage Class page
    Then Admin is redirected to login page from class page 
    
    ###################################################################################
   
  Scenario: Validate Class Details Popup window
    Given Admin is on the Manage class page
    When Admin clicks a add new class under the class menu bar
    Then Admin should see a popup open for class details along with SAVE and CANCEL button and Close(X) Icon

  Scenario: Validate input fields and their text boxes in Class details form
    Given Admin is on the Manage class page
    When Admin clicks a add new class under the class menu bar
    Then Admin should see few input fields and their respective text boxes in the class details window

    #############################         Edit Class           ####################################
    
     Scenario: Validate row level edit icon
    Given Admin is on the Manage class page
    When Admin clicks on the class edit icon 
    Then A new pop up with class details appears
    
       Scenario: Check disabled  batch name
    Given Admin is on the Manage class page
    When Admin clicks on the class edit icon 
    Then Admin should see batch name field is disabled in the class details window
    
        Scenario: Check disabled  class topic
    Given Admin is on the Manage class page
    When Admin clicks on the class edit icon 
    Then Admin should see class topic field is disabled
    
    Scenario: Check if the fields are updated with valid data
    Given Admin is on the Edit Class Popup window
    When Admin updates the fields with valid data from excel row "4" and clicks on save button in the class details window
    Then Admin gets message "class details updated Successfully " and see the updated values in data table in the class details window
    
    Scenario: Check if the fields are updated with invalid values
    Given Admin is on the Edit Class Popup window
    When Admin updates the fields with invalid data from excel row "2" and clicks on save button in the class details window
    Then Admin should get Error message in the class details window 
    
    Scenario: Check if the optional fields are updated with valid data
    Given Admin is on the Edit Class Popup window
    When Update the optional fields with valid values and click save from excel row "4" and clicks on save button in the class details window
    Then Admin gets message "Class details updated Successfully " and see the updated values in data table in the class details window
   
     Scenario: Validate Cancel button on Edit popup
    Given Admin is on the Edit Class Popup window
    When Admin clicks Cancel button on edit popup in the class details window
    Then Admin can see the class details popup disappears and can see nothing changed for particular Class
    
    