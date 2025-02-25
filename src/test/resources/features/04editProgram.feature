@program

Feature: Manage Program - Edit Program

Background: Admin is on program page after reaching home
Given Admin is on login Page
When Admin enter valid data from excel row "1"
And Admin clicks "Program" on the navigation bar

@EditProgram	@ProgramTC_0030
Scenario: Verify Edit option
Given Admin is on Program page
When Admin clicks on Edit option for particular program 
Then Admin lands on Program details form

@EditProgram	@ProgramTC_0031
Scenario: Verify title of the pop up window
Given Admin is on Program page
When Admin clicks on Edit option for particular program 
Then Admin should see window title as "Program Details"

@EditProgram	@ProgramTC_0032
Scenario: Verify mandatory fields with red asterisk mark 
Given Admin is on Program page
When Admin clicks on Edit option for particular program 
Then Admin should see red asterisk mark beside mandatory field "Name"

@EditProgram	@ProgramTC_0033
Scenario Outline: Verify edited Program details
Given Admin is on Program page
And Admin clicks on Edit option for particular program 
When Admin edits the program and click on save button
Then Updated program name is seen by the Admin

Examples:
| row_index |
|    1      | 

@EditProgram	@ProgramTC_0034
Scenario: Verify Admin is able to click Save
Given Admin is on Program page
When Admin edits the details from excel row "1" and click on save button
Then Admin can see the successful message as "Successful Program Updated"

@EditProgram	@ProgramTC_0035
Scenario: Verify Admin is able to click Cancel
Given Admin is on Program details form
When Admin clicks Cancel button
Then Admin can see Program Details form disappears 

@EditProgram	@ProgramTC_0036
Scenario: Verify close the window with "X" 
Given Admin is on Program details form
When Admin Click on "X" button
Then Admin can see Program Details form disappears 

