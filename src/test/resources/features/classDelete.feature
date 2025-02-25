
@classDelete
Feature: Delete Class features

   Background: User is on base page
    Given Admin is on login Page
    When Admin enter valid data from excel row "2"
    And Admin clicks the Class Navigation bar in the Header
    
   Scenario: Class link on navigation bar
    Given Admin is on the Manage class page
    When Admin clicks the delete icon on class page
    Then Admin should see a alert open with heading "Confirm" along with  YES and NO button for deletion
    
    Scenario: Click Yes on deletion window
    Given Admin is on Confirm Deletion alert on class page
    When Admin clicks yes option on class page
    Then Admin gets a message "Successful Class Deleted" alert and do not see that Class in the data table
    
     #Scenario: Click No on deletion window
    #Given Admin is on Confirm Deletion alert on class page
    #When Admin clicks  No option on class page
    #Then Admin can see the deletion alert disappears without deleting on class page
    #
    #Scenario: Validate Close(X) icon on Confirm Deletion alert
    #Given Admin is on Confirm Deletion alert on class page
    #When Admin clicks on close button on class page
    #Then Admin can see the deletion alert disappears without any changes on class page
    #
    
    