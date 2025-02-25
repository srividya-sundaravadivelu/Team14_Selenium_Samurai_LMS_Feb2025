package stepDefinitions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.Assert;
import driver.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ProgramSearchPage;
import utils.LogHelper;

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
	//************************pagination****************************
	@When("Admin clicks Next page link on the program table")
	public void admin_clicks_next_page_link_on_the_program_table() {
	    programsearchpage.clickOnNextpage();
	}

	@Then("Admin validates Pagination has next active link on program table")
	public void admin_validates_pagination_has_next_active_link_on_program_table()throws InterruptedException {
		String text = programsearchpage.getShowingResultsText();
		LogHelper.info("Text found as : " + text);
	    Pattern pattern = Pattern.compile("Showing \\d+ to \\d+ of \\d+ entries");
	    Matcher matcher = pattern.matcher(text);
	    Assert.assertTrue(matcher.find(), "Paginator text does not match expected format: " + text);
//		Assert.assertTrue(text.contains("Showing 1 to "));
	
	}

	@When("Admin clicks Last page link on the program table")
	public void admin_clicks_last_page_link_on_the_program_table() {
		programsearchpage.ClickOnLastPage();
	}

	@Then("Admin validates last page record and next page link disabled in program")
	public void admin_validates_last_page_record_and_next_page_link_disabled_in_program() throws InterruptedException {
		String text = programsearchpage.getShowingResultsText();
		LogHelper.info("Text found as : " + text);
	    Pattern pattern = Pattern.compile("Showing \\d+ to \\d+ of \\d+ entries");
	    Matcher matcher = pattern.matcher(text);
	    Assert.assertTrue(matcher.find(), "Paginator text does not match expected format: " + text);
	}

	@When("Admin clicks Previous page link in program table")
	public void admin_clicks_previous_page_link_in_program_table() {
		programsearchpage.clickOnPreviousPage();
	}

	@Then("Admin validates previous page record and pagination has previous page link in program")
	public void admin_validates_previous_page_record_and_pagination_has_previous_page_link_in_program() throws InterruptedException {
		String text = programsearchpage.getShowingResultsText();
		LogHelper.info("Text found as : " + text);
	    Pattern pattern = Pattern.compile("Showing \\d+ to \\d+ of \\d+ entries");
	    Matcher matcher = pattern.matcher(text);
	    Assert.assertTrue(matcher.find(), "Paginator text does not match expected format: " + text);
	}

	@When("Admin clicks First page link in program table")
	public void admin_clicks_first_page_link_in_program_table() {
		programsearchpage.ClickOnFirstPage();
	}

	@Then("Admin validates very first page record and Previous page link are disabled in program")
	public void admin_validates_very_first_page_record_and_previous_page_link_are_disabled_in_program() throws InterruptedException {
		String text = programsearchpage.getShowingResultsText();
		LogHelper.info("Text found as : " + text);
	    Pattern pattern = Pattern.compile("Showing \\d+ to \\d+ of \\d+ entries");
	    Matcher matcher = pattern.matcher(text);
	    Assert.assertTrue(matcher.find(), "Paginator text does not match expected format: " + text);
	}



}
