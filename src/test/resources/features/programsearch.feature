 @programsearch
Feature: Manage Program - Search Bar

  Background: 
    Given Admin is on login Page
    When Admin enter valid data from excel row "1"
    Then Admin clicks on Program page

  @programsearch-01
  Scenario: Verify Admin can search for a Program Name with results found
  When Admin enters a valid "seleniumsamsung" in the search box on the Program Page
  Then Admin validates that the "seleniumsamsung" found in the searched results for program search
  
  @programsearch-02
  Scenario: Verify Admin can search for a Program Description with results found
  When Admin enters a valid Description "team14donotdelete" in the search box on the Program Page
  Then Admin validates that the "team14donotdelete" match the searched Program Description
  
  @programsearch-03
  Scenario: Verify Admin can search for a Program Name with no results found
  When Admin enters an "Automationyy" in the search box on the Program Page
  Then Admin verifies that " " has found zero results for the searched Program Name
  
  ##############################################pagination#####################
 
  @programpagination-04
  Scenario: Verify Admin is able to click Next page link in program
    When Admin clicks Next page link on the program table
    Then Admin validates Pagination has next active link on program table

  @programpagination-05
  Scenario: Verify Admin is able to click  Last page link in program
    When Admin clicks Last page link on the program table
    Then Admin validates last page record and next page link disabled in program

  @programpagination-06
  Scenario: Verify Admin is able to click Previous page link on program
    When Admin clicks Previous page link in program table
    Then Admin validates previous page record and pagination has previous page link in program

  @programpagination-06
  Scenario: Verify Admin is able to click  First page link
    When Admin clicks First page link in program table
    Then Admin validates very first page record and Previous page link are disabled in program
