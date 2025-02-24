package stepDefinitions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.testng.Assert;

import driver.TestContext;
import io.cucumber.java.en.*;
import pageObjects.ManageProgramPage;
import pageObjects.Program1Page;

public class ManageProgramSteps {
	TestContext testContext;
	ManageProgramPage manageProgramPage;

	public ManageProgramSteps(TestContext testContext) {
		this.testContext = testContext;
		this.manageProgramPage = testContext.getManageProgramPage();

	}
	
	//****************Scenario 19**********************
	@Then("Admin should see the heading as {string}")
	public void admin_should_see_the_heading_as(String expectedHeading) {
		
		Assert.assertEquals(manageProgramPage.admin_should_see_the_heading_as(), expectedHeading);
	}
	
	//****************Scenario 20**********************
	
	@Then("Admin should able to see Program name, description, and status for each program as {string}")
	public void admin_should_able_to_see_program_name_description_and_status_for_each_program_as(String expectedColumnHeaders) {
		List<String> actualColumnHeadersList = manageProgramPage.admin_should_able_to_see_program_name_description_and_status_for_each_program();			
		List<String> expectedColumnHeadersList = Arrays.asList(expectedColumnHeaders.split(", "));

		Assert.assertEquals(actualColumnHeadersList, expectedColumnHeadersList);
	   
	}
	//****************Scenario 21**********************
	@Then("Admin should see a Delete button in left top is disabled")
	public void admin_should_see_a_delete_button_in_left_top_is_disabled() {
		String actual = manageProgramPage.admin_should_see_a_delete_button_in_left_top_is_disabled();
	    Assert.assertEquals(actual,"true");
	}
	//****************Scenario 22**********************
	@Then("Admin should see Search bar with text as {string}")
	public void admin_should_see_search_bar_with_text_as(String expectedOutput) {
		String actualOutput = manageProgramPage.admin_should_see_search_bar_with_text_as();
		Assert.assertEquals(actualOutput, expectedOutput);		
	   
	}
	//****************Scenario 23**********************
	@Then("Admin should see data table with column header as {string}")
	public void admin_should_see_data_table_with_column_header_as(String expectedColumnHeaders) {
		List<String> actualColumnHeadersList = manageProgramPage.admin_should_able_to_see_program_name_description_and_status_for_each_program();
		List<String> expectedColumnHeadersList = Arrays.asList(expectedColumnHeaders.split(", "));
		Assert.assertEquals(actualColumnHeadersList, expectedColumnHeadersList);
	}
	
	//****************Scenario 24 And Scenario 25**********************
	@Then("Admin should see {string} beside Program Name column header and each Program names in the data table")
	public void admin_should_see_beside_program_name_column_header_and_each_program_names_in_the_data_table(String checkboxDefaultState) {
	   
		switch(checkboxDefaultState) {
		
	    case  "checkbox default state as unchecked beside Program Name column header":	    	
	    	Assert.assertFalse(manageProgramPage.admin_should_see_beside_program_name_column_header(),"Checkbox should be unchecked, but it is checked.");
	    	break;
	    	
	    case  "checkbox default state as unchecked on the left side in all rows against program name":
	    	Assert.assertTrue(manageProgramPage.admin_should_see_beside_each_program_names_in_the_data_table(), "All row-wise Checkboxes should be unchecked, but it is checked.");
	    	break;
	    	
	    }				
	}
	
	
	@Then("Admin should see the {string} in manage program page")
	public void admin_should_see_the_in_manage_program_page(String icon) {
		
		switch(icon) {
		
		case "sort arrow icon beside to each column header except Edit and Delete" :
			Assert.assertTrue(manageProgramPage.admin_should_see_the_sort_arrow_icon_beside_each_column_header(), "Column header sort arrow icons are not displayed.");
			break;
			
		case "Edit button on each row of the data table" :
			Assert.assertTrue(manageProgramPage.admin_should_see_the_edit_button_on_each_row_of_the_data_table(),"Edit button on each row of the data table is not displayed");
			break;
			
		case "Delete button on each row of the data table" :
			Assert.assertTrue(manageProgramPage.admin_should_see_the_delete_button_on_each_row_of_the_data_table(),"Delete button on each row of the data table");
			break;
		}
		
	    
	}

	@Then("Admin should see the \"text as \"Showing x to y of z entries\" along with Pagination icon below the table\" in manage program page")
	public void admin_should_see_the_text_as_showing_x_to_y_of_z_entries_along_with_pagination_icon_below_the_table_in_manage_program_page() throws InterruptedException {		
		String actualFooterText = manageProgramPage.getFooterTextMessage();	
		String paginationText = manageProgramPage.getProgramPaginationText();	
		int totalPrograms = manageProgramPage.calculateTotalNoOfPrograms();		
		System.out.println("Pagination Text is : "+paginationText);	
		System.out.println(manageProgramPage.getFooterTextMessage());
		String sub = "of " + totalPrograms + " entries";
		System.out.println("sub Text = " + sub);
		Assert.assertTrue(paginationText.contains(sub));
		
		
	}
	
	@Then("Admin should see the footer as {string} in manage program page.")
	public void admin_should_see_the_footer_as_in_manage_program_page(String expectedFooterText) throws InterruptedException {
		String actualFooterText = manageProgramPage.getFooterTextMessage();	
		int totalPrograms = manageProgramPage.calculateTotalNoOfPrograms();
		System.out.println("Actual footer Text is : " + actualFooterText);
		expectedFooterText ="In total there are " +totalPrograms + " programs.";
		Assert.assertEquals(actualFooterText, expectedFooterText);
	}




}
