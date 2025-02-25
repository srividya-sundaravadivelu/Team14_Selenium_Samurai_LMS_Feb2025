package stepDefinitions;

import java.util.List;

import org.testng.Assert;

import driver.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ClassPage;

public class SearchClassSteps {

	TestContext testContext;
	ClassPage classPage;
	String expectedName = "";

	public SearchClassSteps(TestContext testContext) {
		this.testContext = testContext;
		this.classPage = testContext.getClassPage();
	}

	@When("Admin enter the Batch Name in search textbox")
	public void admin_enter_the_batch_name_in_search_textbox() {
		expectedName = classPage.enterBatchNameInSearchTextBox();
	}

	@Then("Admin should see Class details are searched by Batch Name")
	public void admin_should_see_class_details_are_searched_by_batch_name() {
		List<String> batchNames = classPage.getBatchNamesFromTable();
		// Assert all batch names from the table match the expected batch name given in search text box
		for (String batch : batchNames) {
			Assert.assertEquals(batch, expectedName, "Batch name given in search box does not match!");
		}
	}

	@When("Admin enter the Class topic in search textbox")
	public void admin_enter_the_class_topic_in_search_textbox() {
		expectedName = classPage.enterClassNameInSearchTextBox();
	}

	@Then("Admin should see Class details are searched by Class topic")
	public void admin_should_see_class_details_are_searched_by_class_topic() {
		List<String> classNames = classPage.getClassNamesFromTable();
	    boolean isMatchFound = classNames.contains(expectedName);
	    Assert.assertTrue(isMatchFound, "No matching class name found in the table!");
	}

	@When("Admin enter the Staff Name in search textbox")
	public void admin_enter_the_staff_name_in_search_textbox() {
		expectedName = classPage.enterStaffNameInSearchTextBox();
	}

	@Then("Admin should see Class details are searched by Staff name")
	public void admin_should_see_class_details_are_searched_by_staff_name() {
		List<String> staffNames = classPage.getStaffNamesFromTable();
		// Assert all staff names from table match the expected staff name given in search textbox
		for (String staff : staffNames) {
			Assert.assertEquals(staff, expectedName, "Staff name given in search box does not match!");
		}
	}

}
