package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import driver.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageObjects.*;
import utils.ConfigReader;
import utils.DataReader;
import utils.LogHelper;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;

public class EditClassSteps {

	TestContext testContext;
	AddClassPopUp addClassPopUp;
	EditClassPage editClassPage;
	List<HashMap<String, String>> datamap; // Data driven



	public EditClassSteps(TestContext testContext) {
		this.testContext = testContext;
		this.addClassPopUp = testContext.getAddClassPopUp();
		this.editClassPage = testContext.getEditClassPage();
	}

	@When("Admin clicks on the class edit icon")
	public void admin_clicks_on_the_edit_icon() {
		LogHelper.info("Clicking random edit button");
		editClassPage.getRandomEditButton();
	   
	}

	@Then("A new pop up with class details appears")
	public void a_new_pop_up_with_class_details_appears() {
		assertTrue(editClassPage.isEditPopUpDisplayed());
	    
	}
	@Then("Admin should see batch name field is disabled")
	public void admin_should_see_batch_name_field_is_disabled() {
	    assertFalse(editClassPage.isBatchNameDrpdwnDisabled());
	}
	@Then("Admin should see class topic field is disabled")
	public void admin_should_see_class_topic_field_is_disabled() {
		assertFalse(editClassPage.isClassTopicDisabled());
	}
	/////////////////// Edit Class Details  ///////////////////////
	@Given("Admin is on the Edit Class Popup window")
	public void admin_is_on_the_edit_class_popup_window() {
		LogHelper.info("Clicking random edit button");
		editClassPage.getRandomEditButton();
	}

	@When("Admin updates the fields with valid data from excel row {string} and clicks on save button")
	public void admin_updates_the_fields_with_valid_data_from_excel_row_and_clicks_on_save_button(String rowNumber) throws InterruptedException {
		LogHelper.info("entering edit class details");
		datamap = DataReader.data(System.getProperty("user.dir") + "\\testData\\ExcelData.xlsx", "ClassPage");
		LogHelper.info("user fills data from excel");
		int index = Integer.parseInt(rowNumber) - 1;
		HashMap<String,String> classDetails = datamap.get(index);
		addClassPopUp.editClassDtetails(classDetails);
		//classCreatedMessage = addClassPopUp.addingMandatoryFields(classDetails);
		
		//classCreatedMessage = addClassPopUp.addingMandatoryFields(classDetails);
		//classCreatedMessage = addClassPopUp.getClassCreatedMessage();
	}

	@Then("Admin gets message {string} and see the updated values in data table")
	public void admin_gets_message_and_see_the_updated_values_in_data_table(String string) {
	    
	}
}
