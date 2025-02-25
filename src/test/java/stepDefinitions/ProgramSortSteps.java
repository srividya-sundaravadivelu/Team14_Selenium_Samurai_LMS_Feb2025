package stepDefinitions;

import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import driver.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ProgramSortPage;

public class ProgramSortSteps {
	TestContext testContext;
	ProgramSortPage programsortpage;
	
	
	public ProgramSortSteps(TestContext testContext) {
		this.testContext = testContext;
		this.programsortpage = testContext.getProgramSortPage();		
	}
	
	@When("Admin clicks on Program Name for ascending order in sort program page")
	public void admin_clicks_on_program_name_for_ascending_order_in_sort_program_page() {
	    programsortpage.clickProgramNameAsc();
	}

	@Then("Admin validates the Program Name sorted in ascending order in program page")
	public void admin_validates_the_program_name_sorted_in_ascending_order_in_program_page() {
		List<String> originalList = programsortpage.getOriginalList("ProgramName");
		List<String> sortedList = programsortpage.getSortedListAscending(originalList);

		System.out.println("Original List: " + originalList);
		System.out.println("Sorted List Ascending: " + sortedList);		
		List<String> expectedSortedList = new ArrayList<>(originalList);
		expectedSortedList.sort(String.CASE_INSENSITIVE_ORDER);
		Assert.assertEquals(sortedList, expectedSortedList, "Sorting failed: Lists do not match!");
	}

	@When("Admin clicks on Program Name for descending order in sort program page")
	public void admin_clicks_on_program_name_for_descending_order_in_sort_program_page() {
		programsortpage.clickProgramNameDsc();
	}

	@Then("Admin validates the Program Name sorted in descending order in program page")
	public void admin_validates_the_program_name_sorted_in_descending_order_in_program_page() {
		List<String> originalList = programsortpage.getOriginalList("ProgramName");
		List<String> sortedList = programsortpage.getSortedListDescending(originalList);

		System.out.println("Original List: " + originalList);
		System.out.println("Sorted List Descending: " + sortedList);

		// Create expected sorted list for comparison			
		List<String> expectedSortedList = new ArrayList<>(originalList);
	    expectedSortedList.sort(String.CASE_INSENSITIVE_ORDER.reversed());

		Assert.assertEquals(sortedList, expectedSortedList, "Sorting failed: Lists do not match!");
	}

	@When("Admin clicks on Program Description for ascending order in sort program page")
	public void admin_clicks_on_program_description_for_ascending_order_in_sort_program_page() {
	    programsortpage.clickProgramDescriptionAsc();
	}

	@Then("Admin validates the Program Description sorted in ascending order in program page")
	public void admin_validates_the_program_description_sorted_in_ascending_order_in_program_page() {
		List<String> originalList = programsortpage.getOriginalList("ProgramDescription");
		List<String> sortedList = programsortpage.getSortedListAscending(originalList);
		System.out.println("Original List: " + originalList);
		System.out.println("Sorted List Ascending: " + sortedList);	
		List<String> expectedSortedList = new ArrayList<>(originalList);
		expectedSortedList.sort(String.CASE_INSENSITIVE_ORDER);
		Assert.assertEquals(sortedList, expectedSortedList, "Sorting failed: Lists do not match!");
	}

	@When("Admin clicks on Program Description for descending order in sort program page")
	public void admin_clicks_on_program_description_for_descending_order_in_sort_program_page() {
	   programsortpage.clickProgramDescriptionDsc();
	}

	@Then("Admin validates the Program Description sorted in descending order in program page")
	public void admin_validates_the_program_description_sorted_in_descending_order_in_program_page() {
		List<String> originalList = programsortpage.getOriginalList("ProgramDescription");
		List<String> sortedList = programsortpage.getSortedListDescending(originalList);
		System.out.println("Original List: " + originalList);
		System.out.println("Sorted List Descending: " + sortedList);
		List<String> expectedSortedList = new ArrayList<>(originalList);
	    expectedSortedList.sort(String.CASE_INSENSITIVE_ORDER.reversed());

		Assert.assertEquals(sortedList, expectedSortedList, "Sorting failed: Lists do not match!");
		
	}

	@When("Admin clicks on Program Status for ascending order in sort program page")
	public void admin_clicks_on_program_status_for_ascending_order_in_sort_program_page() {
	   programsortpage.clickProgramStatusAsc();
	}

	@Then("Admin validates the Program Status sorted in ascending order in program page")
	public void admin_validates_the_program_status_sorted_in_ascending_order_in_program_page() {
		List<String> originalList = programsortpage.getOriginalList("ProgramStatus");
		List<String> sortedList = programsortpage.getSortedListAscending(originalList);

		System.out.println("Original List: " + originalList);
		System.out.println("Sorted List Ascending: " + sortedList);		
		List<String> expectedSortedList = new ArrayList<>(originalList);
		expectedSortedList.sort(String.CASE_INSENSITIVE_ORDER);
		Assert.assertEquals(sortedList, expectedSortedList, "Sorting failed: Lists do not match!");
	}

	@When("Admin clicks on Program Status for descending order in sort program page")
	public void admin_clicks_on_program_status_for_descending_order_in_sort_program_page() {
	    programsortpage.clickProgramStatusDsc();
	}

	@Then("Admin validates the Program Status sorted in descending order in program page")
	public void admin_validates_the_program_status_sorted_in_descending_order_in_program_page() {
		List<String> originalList = programsortpage.getOriginalList("ProgramStatus");
		List<String> sortedList = programsortpage.getSortedListDescending(originalList);
		System.out.println("Original List: " + originalList);
		System.out.println("Sorted List Descending: " + sortedList);
		List<String> expectedSortedList = new ArrayList<>(originalList);
	    expectedSortedList.sort(String.CASE_INSENSITIVE_ORDER.reversed());

		Assert.assertEquals(sortedList, expectedSortedList, "Sorting failed: Lists do not match!");
	}


}
