@AddNewClass
Feature: Add new class

  Background: User is on base page
    Given Admin is on login Page
    When Admin enter valid data from excel row "2"
    And Admin clicks the Class Navigation bar in the Header

  #Scenario: Validate Class Details Popup window
    #Given Admin is on the Manage class page
    #When Admin clicks a add new class under the class menu bar
    #Then Admin should see a popup open for class details along with SAVE and CANCEL button and Close(X) Icon
#
  #Scenario: Validate input fields and their text boxes in Class details form
    #Given Admin is on the Manage class page
    #When Admin clicks a add new class under the class menu bar
    #Then Admin should see few input fields and their respective text boxes in the class details window

    #############################         Edit Class           ####################################
    
     #Scenario: Validate row level edit icon
    #Given Admin is on the Manage class page
    #When Admin clicks on the class edit icon 
    #Then A new pop up with class details appears
    
       #Scenario: Check disabled  batch name
    #Given Admin is on the Manage class page
    #When Admin clicks on the class edit icon 
    #Then Admin should see batch name field is disabled
    
        #Scenario: Check disabled  batch name
    #Given Admin is on the Manage class page
    #When Admin clicks on the class edit icon 
    #Then Admin should see class topic field is disabled
    
    Scenario: Check if the fields are updated with valid data
    Given Admin is on the Edit Class Popup window
    When Admin updates the fields with valid data from excel row "4" and clicks on save button
    Then Admin gets message "class details updated Successfully " and see the updated values in data table
    
    
    
    
    
    
    
    