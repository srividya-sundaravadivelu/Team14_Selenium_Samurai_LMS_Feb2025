@homePage
Feature: Home Page

	Background: 
		Given Admin gives the correct LMS portal URL

@homePage-01
  Scenario: Verify LMS title
    Given Admin is on login Page
    When Admin enter valid data from excel row "1"
    Then Admin should see LMS -Learning management system as title
    
@homePage-02
	Scenario: Verify LMS title alignment
		Given Admin is on login Page	
		When Admin enter valid data from excel row "1"
		Then LMS title should be on the top left corner of page
		
@homePage-03
	Scenario: Validate navigation bar text
		Given Admin is on login Page		
		When Admin enter valid data from excel row "1"
		Then Admin should see correct spelling in navigation bar text
		
@homePage-04
	Scenario: Validate LMS title has correct spelling and space
		Given Admin is on login Page
		When Admin enter valid data from excel row "1"	
		Then Admin should see correct spelling and space in LMS title
		
@homePage-05
	Scenario: Validate alignment for navigation bar
		Given Admin is on login Page
		When Admin enter valid data from excel row "1"
		Then Admin should see the navigation bar text on the top right side
		
@homePage-06
	Scenario: Validate navigation bar order 1st home
		Given Admin is on login Page
		When Admin enter valid data from excel row "1"
		Then Admin should see home in the 1st place
		
@homePage-07
	Scenario: Validate navigation bar order 2nd Program
		Given Admin is on login Page
		When Admin enter valid data from excel row "1"
		Then Admin should see program in the 2nd place
		
@homePage-08
	Scenario: Validate navigation bar order 3rd  batch
		Given Admin is on login Page
		When Admin enter valid data from excel row "1"
		Then Admin should see batch in the 3rd place
		
@homePage-09
	Scenario: Validate navigation bar order 4th  class
		Given Admin is on login Page
		When Admin enter valid data from excel row "1"
		Then Admin should see class in the 4th place
		
@homePage-10
	Scenario: validate navigation bar order 5th logout
		Given Admin is on login Page
		When Admin enter valid data from excel row "1"
		Then Admin should see logout in the 5th place
		
@homePage-11
	Scenario: verify pie-chart presence
		Given Admin is on login Page
		When Admin enter valid data from excel row "1"
		Then Admin should see piechart
		
@homePage-12
	Scenario: Verify user details
		Given Admin is on login Page
		When Admin enter valid data from excel row "1"
		Then Admin should see welcome message with user name and role

@homePage-13
	Scenario: Verify bar chart
		Given Admin is on login Page
		When Admin enter valid data from excel row "1"	
		Then Admin should see bar chart for Active and inactive user

@homePage-14
	Scenario: Verify user count
		Given Admin is on login Page
		When Admin enter valid data from excel row "1"	
		Then Admin should see user count
		
@homePage-15
	Scenario: Verify staff count
		Given Admin is on login Page
		When Admin enter valid data from excel row "1"
		Then Admin should see staff count
		
@homePage-16
	Scenario: verify program count
		Given Admin is on login Page
		When Admin enter valid data from excel row "1"	
		Then Admin should see Program count
		
@homePage-17
	Scenario: Verify batch count 
		Given Admin is on login Page
		When Admin enter valid data from excel row "1"
		Then Admin should see batch count

@homePage-18
	Scenario: Verify staff table pagination
		Given Admin is on login Page
		When Admin enter valid data from excel row "1"	
		Then Admin should see staff table with pagination icons
	
@homePage-19
	Scenario: Verify staff data page split
		Given Admin is on login Page
		When Admin enter valid data from excel row "1"
		Then Admin should see 5 staff data in a page
	
@homePage-20
	Scenario: verify previous page icon disable
		Given Admin is on login Page
		When Admin enter valid data from excel row "1"
		Then Admin should see previous page icon disabled
		
@homePage-21
	Scenario: verify first page icon disabled
		Given Admin is on login Page
		When Admin enter valid data from excel row "1"
		Then Admin should see first page icon disabled
		
		
