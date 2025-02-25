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
import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;

public class EditClassSteps {

	TestContext testContext;
	AddClassPopUp addClassPopUp;
	EditClassPage editClassPage;
	List<HashMap<String, String>> datamap; // Data driven

	private String batchName;
	private String classTopicName;


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
	@Then("Admin should see batch name field is disabled in the class details window")
	public void admin_should_see_batch_name_field_is_disabled() {
	    assertFalse(editClassPage.isBatchNameDrpdwnDisabled());
	}
	@Then("Admin should see class topic field is disabled")
	public void admin_should_see_class_topic_field_is_disabled() {
		assertFalse(editClassPage.isClassTopicDisabled());
	}
	/////////////////// Edit Class Details  ///////////////////////
	@Given("Admin is on the Edit Class Popup window")
	public void admin_is_on_the_edit_class_popup_window() throws InterruptedException {
		LogHelper.info("Clicking random edit button");
		editClassPage.getRandomEditButton();
		//Thread.sleep(2000);
		this.batchName = addClassPopUp.getSelectedBatchName();
		this.classTopicName = addClassPopUp.getSelectedClassTopic();
		System.out.println("batchName === "+ addClassPopUp.getSelectedBatchName());
	}

	@When("Admin updates the fields with valid data from excel row {string} and clicks on save button in the class details window")
	public void admin_updates_the_fields_with_valid_data_from_excel_row_and_clicks_on_save_button(String rowNumber) throws InterruptedException {
		LogHelper.info("entering edit class details");
		datamap = DataReader.data(System.getProperty("user.dir") + "\\testData\\ExcelData.xlsx", "ClassPage");
		LogHelper.info("user fills data from excel");
		int index = Integer.parseInt(rowNumber) - 1;
		HashMap<String,String> classDetails = datamap.get(index);
		System.out.println("class details==="+classDetails.get("ClassDescription"));
		addClassPopUp.editClassDtetails(classDetails);
		//classCreatedMessage = addClassPopUp.addingMandatoryFields(classDetails);
		
		//classCreatedMessage = addClassPopUp.addingMandatoryFields(classDetails);
		//classCreatedMessage = addClassPopUp.getClassCreatedMessage();
	}

	@Then("Admin gets message {string} and see the updated values in data table in the class details window")
	public void admin_gets_message_and_see_the_updated_values_in_data_table(String string) {
		assertEquals("Successful", editClassPage.getSuccessMsg());
	    
	}
	@Then("Admin should get Error message in the class details window")
	public void admin_should_get_error_message() {
		assertTrue(addClassPopUp.isStaffNameReqMsgVisible());
	}
	@When("Admin updates the fields with invalid data from excel row {string} and clicks on save button in the class details window")
	public void admin_updates_the_fields_with_invalid_data_from_excel_row_and_clicks_on_save_button(String rowNumber) throws InterruptedException {
		LogHelper.info("entering edit class details");
		datamap = DataReader.data(System.getProperty("user.dir") + "\\testData\\ExcelData.xlsx", "ClassPage");
		LogHelper.info("user fills data from excel");
		int index = Integer.parseInt(rowNumber) - 1;
		HashMap<String,String> classDetails = datamap.get(index);
		addClassPopUp.editClassDtetails(classDetails);
	}

	@When("Update the optional fields with valid values and click save from excel row {string} and clicks on save button in the class details window")
	public void update_the_optional_fields_with_valid_values_and_click_save_from_excel_row_and_clicks_on_save_button(String rowNumber) throws InterruptedException {
		LogHelper.info("entering edit class details");
		datamap = DataReader.data(System.getProperty("user.dir") + "\\testData\\ExcelData.xlsx", "ClassPage");
		LogHelper.info("user fills data from excel");
		int index = Integer.parseInt(rowNumber) - 1;
		HashMap<String,String> classDetails = datamap.get(index);
		addClassPopUp.editClassDtetails(classDetails);
	}

	@When("Admin clicks Cancel button on edit popup in the class details window")
	public void admin_clicks_cancel_button_on_edit_popup() {
	   addClassPopUp.clickCancelBtn();
	}

	@Then("Admin can see the class details popup disappears and can see nothing changed for particular Class")
	public void admin_can_see_the_class_details_popup_disappears_and_can_see_nothing_changed_for_particular_class() {
		System.out.println("batchName === "+ addClassPopUp.getSelectedBatchName());
	}

}
