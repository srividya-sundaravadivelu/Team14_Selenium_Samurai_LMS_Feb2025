@addBatch
Feature: Add New Batch

  Background: User is on base page
    Given Admin is on login Page
    When Admin enter valid data from excel row "1"
    And Admin Clicks on the Batch menu from the header

  #Scenario: Verify sub menu displayed in batch menu bar
  #Then Admin should see sub menu in menu bar as Add New Batch
  #
  #Scenario: Validate Admin able to click on the Add new Batch Option
  #Given Admin is on the batch page
  #When Admin clicks on Add New batch under the batch menu bar
  #Then Admin should see the Batch Details pop up window
 #
  #Scenario: Validate Edit icon feature in any row
  #Given Admin is on the batch page
  #Then Admin should see the Batch details pop up window
  #
  #Scenario: Validate program name value is disabled to edit
  #Given Admin is on the batch page
  #Then Admin should see Program name value field is disabled for editing
  #
  #Scenario: Validate batch name  value is disabled to edit
  #Given Admin is on the batch page
  #Then Admin should see batch name value field is disabled for editing
 #
  #Scenario: Validate editing description and No. of classes fields with invalid data in the pop up
  #Given Admin is on the Batch Details Page
  #When Admin Updates any fields with invalid data and click save button
  #Then Admin should get a error message under the respective field
 #
  #Scenario: Validate save button in Batch details pop up
    #Given Admin is on the Batch Details Page
    #When Admin enters the valid data to all the mandatory fields and click save button
    #Then Admin should get a successful message for editing the batch
#
  #Scenario: Validate cancel button in Batch details pop up
  #Given Admin is on the Batch Details Page
  #When  Admin enters the valid data to all the mandatory fields and click cancel button
  #Then  Admin can see the batch details popup closes without editing the batch
 #
  #Scenario: Validate delete Icon on any row
    #Given Admin is on the batch page
    #When Admin clicks the delete Icon on any row
    #Then Admin should see the confirm alert box with yes and no button
#
  #Scenario: Validate yes button on the confirm alert box
    #Given Admin is on the batch confirm popup page
    #When Admin clicks on the delete icon and click yes button
    #Then Admin should see the successful message and the batch should be deleted
    #
   #Scenario: Validate no button on the confirm alert box
   #Given Admin is on the batch confirm popup page
   #When  Admin clicks on the delete icon and click no button
   #Then  Admin should see the alert box closed and the batch is not deleted
   #
   #Scenario: Validate close Icon on the alert box
    #Given Admin is on the batch confirm popup page
    #When Admin clicks on the close icon
    #Then Admin should see the alert box closed 
       #
    #Scenario: Validate single row delete with checkbox
    #Given Admin is on the batch page
    #When Admin clicks on the delete icon under the Manage batch header
    #Then The respective row in the table should be deleted
   #
   #Scenario: Validate next page link
   #Given Admin is on the batch page
   #When Admin clicks next page link on the data table
   #Then Admin should see the Next enabled link
   #
   #Scenario: Validate last page link
   #Given Admin is on the batch page
   #When Admin clicks last page link on the data table
   #Then Admin should see the last page link with next page link disabled on the table 
   #
   #Scenario: Validate the previous page link
   #Given Admin is on the batch page
   #When Admin clicks previous page link on the data table
   #Then Admin should see the previous page on the table
   #
   #Scenario: Validate the first page link
   #Given Admin is on the batch page
   #When Admin clicks first page link on the data table
   #Then Admin should see the very first page on the data table
   #
   Scenario:
   Given Admin is on the batch page
   When Admin enters the batch name "Playwright" in the search text box
  Then  Admin should see the filtered batches containing "Playwright" in the data table 
   
   
   
   
   
   
   
   
   
