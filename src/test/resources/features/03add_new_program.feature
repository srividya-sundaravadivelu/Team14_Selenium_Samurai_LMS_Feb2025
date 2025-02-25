@program

Feature: Menu bar - Program - Add New Program

Background: Admin is on program page after reaching home
Given Admin is on login Page
When Admin enter valid data from excel row "1"
When Admin clicks "Program" on the navigation bar
Then Admin should be navigated to "Program" page

@ProgramPageMenuBar_AddNewProgram @ProgramTC_006
Scenario: Verify add New Program
Given Admin is on Program page
When Admin clicks on "Add New Program" under the "Program" menu bar
Then Admin should see pop up window for program details


@ProgramPageMenuBar_AddNewProgram @ProgramTC_007
Scenario: Verify title of the pop up window
Given Admin is on Program page
When Admin clicks on "Add New Program" under the "Program" menu bar
Then Admin should see window title as "Program Details"


@ProgramPageMenuBar_AddNewProgram @ProgramTC_008
Scenario: Verify mandatory fields with red asterisk mark 
Given Admin is on Program page
When Admin clicks on "Add  New Program" under the "Program" menu bar
Then Admin should see red  asterisk mark  beside mandatory field "Name"


@ProgramPageMenuBar_AddNewProgram @ProgramTC_009
Scenario: Verify empty form submission
Given Admin is on Program details form
When Admin clicks save button without entering mandatory fields
Then Admin gets message '<field> is required'


@ProgramPageMenuBar_AddNewProgram @ProgramTC_010
Scenario: Verify cancel button
Given Admin is on Program details form
When Admin clicks Cancel button
Then Admin can see Program Details form disappears 


#Scenario Outline: Verify enter program name
#Given Admin is on Program details form
#When Admin enters the respective "<Fields>" in the text box from excel row "<row_index>"
#Then Admin can see the text entered in respective "<Fields>" box 
#
   #Examples:
   #| row_index |Fields|
   #|   1       |Name|
   #|   1       |Description|
   #|   1       |Status|
   #
   
     
@ProgramPageMenuBar_AddNewProgram @ProgramTC_011   
Scenario Outline: Verify enter name
Given Admin is on Program details form
When Admin enters the Name in the text box from excel row "<row_index>"
Then Admin can see the text entered in Name box
Examples:
| row_index |
|    1      |


@ProgramPageMenuBar_AddNewProgram @ProgramTC_012
Scenario Outline: Verify enter description
Given Admin is on Program details form
When Admin enters the Description in the text box from excel row "<row_index>"
Then Admin can see the text entered in Description box
Examples:
| row_index |
|    1      |


@ProgramPageMenuBar_AddNewProgram @ProgramTC_013
Scenario: Verify select Status
Given Admin is on Program details form
When Admin selects the Status of the program by clicking on the radio button "<Status>"
Then Admin can see "Active/Inactive" Status selected


@ProgramPageMenuBar_AddNewProgram @ProgramTC_014
Scenario Outline: Verify Admin is able to save the program details
Given Admin is on Program details form
When Admin enter valid details for mandatory fields from excel row "<row_index>" and Click on Save button
Then Admin gets success message as 'Program Created Successfully'

Examples:
| row_index |
|    1      |

@ProgramPageMenuBar_AddNewProgram @ProgramTC_015
Scenario: Verify close window with "X" 
Given Admin is on Program details form
When Admin Click on "X" button
Then Admin can see Program Details form disappears


