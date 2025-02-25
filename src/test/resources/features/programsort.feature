@programsort
Feature: Manage Program - Sorting Program
  
  	Background: 
		Given Admin is on login Page
    When 	Admin enter valid data from excel row "1"
    Then 	Admin clicks on Program page
    @programsort-01 
    Scenario: verify sorting Program Name in ascending order
    When Admin clicks on Program Name for ascending order in sort program page
    Then Admin validates the Program Name sorted in ascending order in program page
    @programsort-02 
    Scenario: verify sorting Program Name in descending order
    When Admin clicks on Program Name for descending order in sort program page
    Then Admin validates the Program Name sorted in descending order in program page
    @programsort-03 
    Scenario: verify sorting Program Description in ascending order
    When Admin clicks on Program Description for ascending order in sort program page
    Then Admin validates the Program Description sorted in ascending order in program page
    @programsort-04 
    Scenario: verify sorting Program Description in descending order
    When Admin clicks on Program Description for descending order in sort program page
    Then Admin validates the Program Description sorted in descending order in program page
    @programsort-05  
    Scenario: verify sorting  Program Status in ascending order
    When Admin clicks on Program Status for ascending order in sort program page
    Then Admin validates the Program Status sorted in ascending order in program page
    @programsort-06 
    Scenario: verify sorting  Program Status in descending order
    When Admin clicks on Program Status for descending order in sort program page
    Then Admin validates the Program Status sorted in descending order in program page