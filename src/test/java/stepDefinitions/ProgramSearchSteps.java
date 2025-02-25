package stepDefinitions;

import org.testng.Assert;
import driver.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ProgramSearchPage;

public class ProgramSearchSteps {
	TestContext testContext;
	ProgramSearchPage programsearchpage;
	
	public ProgramSearchSteps(TestContext testContext) {
		this.testContext = testContext;
		this.programsearchpage = testContext.getProgramSearchPage();
	}
	
	@When("Admin enters a valid {string} in the search box on the Program Page")
	public void admin_enters_a_valid_in_the_search_box_on_the_program_page(String string) {
	    programsearchpage.searchProgramName(string);
	}

	@Then("Admin validates that the {string} found in the searched results for program search")
	public void admin_validates_that_the_found_in_the_searched_results_for_program_search(String string) {	

	    boolean progNameDisplayed = programsearchpage.progNameDisplayed(string); 
	    System.out.println("search results true or false : " + progNameDisplayed);	   
	    Assert.assertTrue(progNameDisplayed, "Expected Program Name not found in search results: " + string);

	}
	@When("Admin enters a valid Description {string} in the search box on the Program Page")
	public void admin_enters_a_valid_description_in_the_search_box_on_the_program_page(String string) {
		programsearchpage.searchProgramDescription(string);
	}

	@Then("Admin validates that the {string} match the searched Program Description")
	public void admin_validates_that_the_match_the_searched_program_description(String string) {
		
		boolean progDescriptionDisplayed = programsearchpage.progDescriptionDisplayed(string); 
	    System.out.println("search results true or false : " + progDescriptionDisplayed);	   
	    Assert.assertTrue(progDescriptionDisplayed, "Expected Program Description not found in search results: " + string);
	}

	@When("Admin enters an {string} in the search box on the Program Page")
	public void admin_enters_an_in_the_search_box_on_the_program_page(String string) {
	    programsearchpage.searchInValidPName(string);
	}

	@Then("Admin verifies that {string} has found zero results for the searched Program Name")
	public void admin_verifies_that_has_found_zero_results_for_the_searched_program_name(String string) {
		System.out.println("invalid call " + string);
		boolean invalidprogname = programsearchpage.InvalidPname(string);
	    Assert.assertFalse(invalidprogname, "Expected Program Name not found in search results: " + string);
	}



}
