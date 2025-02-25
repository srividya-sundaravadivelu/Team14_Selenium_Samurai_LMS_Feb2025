package stepDefinitions;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import driver.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BatchPage;
import pageObjects.LoginPage;
import utils.ConfigReader;
import utils.DataReader;
import utils.LogHelper;

public class BatchSteps {
	TestContext testContext;
	LoginPage loginPage;
	BatchPage batchPage;
	List<HashMap<String, String>> datamap; // Data driven
	
	public BatchSteps (TestContext testContext) {
		this.testContext = testContext;
		this.loginPage = testContext.getLoginPage();
		this.batchPage = testContext.getBatchPage();
	}
	

	/*--- Below is starting of Batch page ---*/
	
	@Given("Admin is on the home Page")
	public void admin_is_on_the_home_page() {
	   // batchPage.navigateToPage(ConfigReader.getBaseUrl());
					LogHelper.info("Admin is on Home page");
			Assert.assertEquals(loginPage.getCurrentUrl(), ConfigReader.getBaseUrl());
		}
	

	@When("Admin Clicks on the Batch menu from the header")
	public void admin_clicks_on_the_batch_menu_from_the_header() {
	    batchPage.BatchButton();
	}

	@Then("Admin should be in the Manage Batch Page")
	public void admin_should_be_in_the_manage_batch_page() {
		String ExpectedUrl = "https://feb-ui-hackathon-bbfd38d67ea9.herokuapp.com/batch";
		Assert.assertEquals(ExpectedUrl, batchPage.ManageBatchUrl());
	}

	@Then("Admin should see the {string} Title")
	public void admin_should_see_the_title(String string) {
	    Assert.assertTrue(batchPage.LearningManagementSystemText());
	}

	@Then("Admin should see the {string} Heading")
	public void admin_should_see_the_heading(String string) {
		 Assert.assertTrue(batchPage.ManageBatchText());
	}

	@Then("Admin should see the disabled {string} under the header")
	public void admin_should_see_the_disabled_under_the_header(String string) {
	    Assert.assertTrue(!batchPage.isIconEnable());
	}

	@Then("Admin should see the enabled pagination controls under the data table")
	public void admin_should_see_the_enabled_pagination_controls_under_the_data_table() {
		Assert.assertTrue(batchPage.PaginationControlTable());
	}
	@Then("Admin should see the {string} in each row")
	public void admin_should_see_the_icon_in_each_row(String icon) {
		
		switch(icon) {
			case "edit icon in each row":
				Assert.assertTrue(batchPage.areEditButtonsEnable());
				break;
			case "delete icon in each row":
				Assert.assertTrue(batchPage.areDeleteButtonEnable());
				break;
			case "checkbox in each row":
				Assert.assertTrue(batchPage.areCheckBoxEnable());
				break;
	        case "Admin should see the datatable headers Batch name,Batch Description,Batch Status,No Of classes, Program Name, Edit/Delete":
				Assert.assertTrue(batchPage.areDatatableHeaderEnable());
				break;
			case "checkbox  in the datatable header row":
				Assert.assertTrue(batchPage.isCheckBoxHeaderEnable());
				break;
			case "sort icon next to all Datatable headers":
				Assert.assertTrue(batchPage.isSortingEnable());
				break;
		}
	}
	
	@Given("Admin is on the Batch Details Pop Up WIndow")
	public void admin_is_on_the_Batch_Details_Pop_Up_WIndow() {
		batchPage.BatchButton();
		batchPage.addBatchBtn();
	}
	@When("Admin checks all the fields are enabled")
	public void admin_checks_all_the_fields_are_enabled() {
		Assert.assertTrue(batchPage.checkElementEnable());
	}
	@Then("The pop up should include the fields Batch Name Number of classes and Description as text box Program Name as drop down Status as radio button")
	public void the_pop_up_should_include_the_fields_Batch_Name_Number_of_classes_and_Description_as_text_box_Program_Name_as_drop_down_Status_as_radio_button() {
		Assert.assertTrue(batchPage.checkElementTypes());
	}
	@When("Admin selects program name present in the dropdown")
	public void admin_selects_program_name_present_in_the_dropdown() {
		batchPage.selectProgramFromDropdown();
	}
	@Then("Admin should see selected program name in the batch name prefix box")
	public void admin_should_see_selected_program_name_in_the_batch_name_prefix_box() {
		Assert.assertEquals(batchPage.selectProgramFromDropdown(),batchPage.getBatchName(), "The selected program is correct");
	}
	@When("Admin enters alphabets in batch name suffix box")
	public void admin_enters_alphabets_in_batch_name_suffix_box() {
		batchPage.enterTextInBatchName();
	}
	@Then("Admin should get error message below the text box of respective field")
	public void admin_should_get_error_message_below_the_text_box_of_respective_field() {
		Assert.assertTrue(batchPage.getErrorMsg(),"Error is showing");
	}
	@When("Admin enters alphabets in batch name prefix box")
	public void admin_enters_alphabets_in_batch_name_prefix_box() {
		batchPage.enterTextInPreBatchName();
	}
	@Then("Admin should see empty text box")
	public void admin_should_see_empty_text_box() {
		Assert.assertTrue(batchPage.isTextInPreBatchName());
	}
	@When("Admin enters the data only to the mandatory fields and clicks save button")
	public void admin_enters_the_data_only_to_the_mandatory_fields_and_clicks_save_button() {
		batchPage.mandatoryDataEntry();
		batchPage.clickSaveBtn();
	}
	@Then("Admin should get a successful message")
	public void admin_should_get_a_successful_message() {
		Assert.assertTrue(batchPage.isSuccessMessageDisplayed());
	       
	    }
	}
	
