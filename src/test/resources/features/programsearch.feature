@programsearch
Feature: Manage Program - Search Bar

  Background: 
    Given Admin is on login Page
    When Admin enter valid data from excel row "1"
    Then Admin clicks on Program page

  @tag1
  Scenario: Verify Admin can search for a Program Name with results found
    When Admin enters a valid "teamfourtnchek" in the search box on the Program Page
    Then Admin validates that the "teamfourtnchek" found in the searched results for program search

  @tag2
  Scenario: Verify Admin can search for a Program Description with results found
    When Admin enters a valid Description "teamfourteen" in the search box on the Program Page
    Then Admin validates that the "teamfourteen" match the searched Program Description

  @tag3
  Scenario: Verify Admin can search for a Program Name with no results found
    When Admin enters an "Automationyy" in the search box on the Program Page
    Then Admin verifies that " " has found zero results for the searched Program Name
