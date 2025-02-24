@program

Feature: Manage Program Page validation

Background: Admin is logged in to LMS Portal
Given Admin is on login Page
When Admin enter valid data from excel row "1"
And Admin clicks "Program" on the navigation bar

@ManageProgram	@ProgramTC_0019
Scenario: Verify heading in manage program
Given Admin is on home page after Login
When Admin clicks "Program" on the navigation bar
Then Admin should see the heading as "Manage Program"

@ManageProgram	@ProgramTC_0020
Scenario Outline: Verify view details of programs
Given Admin is on home page after Login
When Admin clicks "Program" on the navigation bar
Then Admin should able to see Program name, description, and status for each program as "<ExpectedColumnHeaders>"
		Examples:
			|ExpectedColumnHeaders                     |
			| Program Name, Program Description, Program Status, Edit / Delete  |


@ManageProgram	@ProgramTC_0021
Scenario: Verify the Multiple Delete button state 
Given Admin is on home page after Login
When Admin clicks "Program" on the navigation bar
Then Admin should see a Delete button in left top is disabled


@ManageProgram	@ProgramTC_0022
Scenario: Verify the Search button 
Given Admin is on home page after Login
When Admin clicks "Program" on the navigation bar
Then Admin should see Search bar with text as "Search..."


@ManageProgram	@ProgramTC_0023
Scenario Outline: Verify column header name of data table
Given Admin is on home page after Login
When Admin clicks "Program" on the navigation bar
Then Admin should see data table with column header as "<ExpectedColumnHeaders>"

		Examples:
			|ExpectedColumnHeaders                     |
			| Program Name, Program Description, Program Status, Edit / Delete  |

@ManageProgram	@ProgramTC_0024 @ProgramTC_0025
Scenario Outline: Verify checkbox default state beside Program Name column header and each Program names in the data table
Given Admin is on home page after Login
When Admin clicks "Program" on the navigation bar
Then Admin should see "<checkbox_default_state>" beside Program Name column header and each Program names in the data table 

		Examples:
			|checkbox_default_state|
			|checkbox default state as unchecked beside Program Name column header |
			|checkbox default state as unchecked on the left side in all rows against program name |

@ManageProgram	@ProgramTC_0026 @ProgramTC_0027	@ProgramTC_0028 @ProgramTC_0029				
Scenario Outline: Verify Sort icon, edit and delete icon and pagination icons below data table in manage program
Given Admin is on home page after Login
When Admin clicks "Program" on the navigation bar
Then Admin should see the "<expected_icon>" in manage program page

		Examples:
			| expected_icon |
			| sort arrow icon beside to each column header except Edit and Delete |
			| Edit button on each row of the data table |
			| Delete button on each row of the data table |
			| text as "Showing x to y of z entries" along with Pagination icon below the table | 

@ManageProgram	@ProgramTC_0030
Scenario: Verify footer message in manage program
Given Admin is on home page after Login
When Admin clicks "Program" on the navigation bar
Then Admin should see the footer as "In total there are z programs" in manage program page.






