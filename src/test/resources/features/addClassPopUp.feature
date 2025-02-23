@AddClassPopUp
Feature: Add new class

  Background: User is on base page
    Given Admin is on login Page
    When Admin enter valid data from excel row "1"
    And Admin clicks the Class Navigation bar in the Header
    Then Admin clicks a add new class under the class menu bar

  #Scenario Outline: Check if class is created when only mandatory fields are entered with valid data
  #Given Admin is on the Class Popup window
  #When Admin enters mandatory fields in the form from excel row "<row_index>" and clicks on save button
  #Then Admin gets message Class added Successfully
  #
  #Examples:
  #| row_index |
  #|         1 |
  
  #Scenario Outline: Check if class is created when only optional fields are entered with valid data
    #Given Admin is on the Class Popup window
    #When Admin skips to add value in mandatory field and enter only the optional field from excel row "<row_index>" and clicks on save button
    #Then Admin should see error message below the test field and the field will be highlighted in red color
#
    #Examples: 
      #| row_index |
      #|         2 |
  #Scenario: Empty form submission
    #Given Admin is on the Class Popup window
    #When Admin clicks on save button without entering data 
    #Then class wont be created and Admin gets error message

################################ Edit Class Details  ##############################








  