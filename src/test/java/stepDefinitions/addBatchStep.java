package stepDefinitions;

import org.testng.Assert;

import driver.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BatchPage;
import pageObjects.LoginPage;
import pageObjects.addBatchPage;

public class addBatchStep {
	TestContext testContext;
	LoginPage loginPage;
	BatchPage batchPage;
	addBatchPage addbatchPage;
	
	public addBatchStep (TestContext testContext) {
		this.testContext = testContext;
		this.loginPage = testContext.getLoginPage();
		this.batchPage = testContext.getBatchPage();
		this.addbatchPage = testContext.getaddBatchPage();
	}
	@Then("Admin should see sub menu in menu bar as Add New Batch")
	public void admin_should_see_sub_menu_in_menu_bar_as_Add_New_Batch() {
		Assert.assertTrue(addbatchPage.getBatchButtonResult());	
	}
	@Given("Admin is on the batch page")
	public void admin_is_on_the_batch_page() {
		Assert.assertEquals(batchPage.getBatchPageUrl(), batchPage.ExpectedBatchUrl());
	}
	
	@When("Admin clicks on Add New batch under the batch menu bar")
	public void admin_clicks_on_add_new_batch_under_the_batch_menu_bar() {
		addbatchPage.NewBatchButton();
	}
	
	@Then("Admin should see the Batch Details pop up window")
	public void admin_should_see_the_batch_details_pop_up_window() {
		Assert.assertTrue(addbatchPage.BatchDetailsText(),"Admin can see the pop up window");
	}
	
	@Then("Admin should see the Batch details pop up window")
	public void admin_should_see_the_Batch_details_pop_up_window() {
		Assert.assertTrue(addbatchPage.areEditWindowsEnable(), "Admin can see all edit button windows");
	}
	@Then("Admin should see Program name value field is disabled for editing")
	public void admin_should_see_Program_name_value_field_is_disabled_for_editing() {
		Assert.assertTrue(addbatchPage.areProgramDropDownDisable(),"The Program name value field is disable");
	}
	@Then("Admin should see batch name value field is disabled for editing")
	public void admin_should_see_batch_name_value_field_is_disabled_for_editing() {
		Assert.assertTrue(addbatchPage.areBatchNameDisable());
	}
	@Given("Admin is on the Batch Details Page")
	public void admin_is_on_the_Batch_Details_Page() {
		addbatchPage.clickEditButton();
				
	}
	@When("Admin Updates any fields with invalid data and click save button")
	public void admin_updates_any_fields_with_invalid_data_and_click_save_button() {
		addbatchPage.BatchDescription();
		addbatchPage.NumberOfClasses();
		addbatchPage.SaveButton();
	}
	@Then("Admin should get a error message under the respective field")
	public void admin_should_get_a_error_message_under_the_respective_field() {
		Assert.assertEquals(addbatchPage.ClassesErrorMessage(),addbatchPage.ExpectedNumberClassesMessage());
		Assert.assertEquals(addbatchPage.DescriptionMessage(),addbatchPage.ExpectedDescriptionMessage());
	}
	
}
	



