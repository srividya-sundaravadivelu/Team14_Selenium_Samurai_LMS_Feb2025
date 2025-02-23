@program

Feature: Navigation_MenuBar

Background: Admin is logged in to LMS Portal
Given Admin is on login Page
When Admin enter valid data from excel row "1"

@ProgramPageNavigation @ProgramTC_001
Scenario Outline: Verify that Admin is able to navigate to Program page
Given Admin is on home page after Login
When Admin clicks "<module>" on the navigation bar
Then Admin should be navigated to "<module>" page

Examples:
|module|
|Program|


#Scenario Outline: Verify Logout displayed in menu bar
#Given Admin is on home page after Login
#When Admin clicks "<module>" on the navigation bar
#Then Admin should see "Logout" in menu bar
#
#Examples:
#|module|
#|Program|

@ProgramPageMenuBar @ProgramTC_002
Scenario: Verify Logout displayed in menu bar
Given Admin is on home page after Login
When Admin clicks "Program" on the navigation bar
Then Admin should see "Logout" in menu bar

@ProgramPageMenuBar @ProgramTC_003
Scenario: Verify heading in menu bar
Given Admin is on home page after Login
When Admin clicks "Program" on the navigation bar
Then Admin should see the heading "LMS - Learning Management System"

@ProgramPageMenuBar	@ProgramTC_004
Scenario Outline: Verify other page's name displayed in menu bar
Given Admin is on home page after Login
When Admin clicks "Program" on the navigation bar
Then Admin should see the page names as in order "<expectedModules>"

Examples:
|expectedModules                     |
|Home, Program, Batch, Class, Logout |

@ProgramPageMenuBar	@ProgramTC_005
Scenario Outline: Verify sub menu displayed in program menu bar
Given Admin is on Program page
When Admin clicks "<module>" on the navigation bar
Then Admin should see sub menu in menu bar as "Add New Program"

Examples:
|module |
|Program|









