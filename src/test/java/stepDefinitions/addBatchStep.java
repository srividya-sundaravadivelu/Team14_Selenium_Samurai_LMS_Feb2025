package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import driver.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BatchPage;
import pageObjects.LoginPage;
import pageObjects.addBatchPage;

public class addBatchStep  {
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
		addbatchPage.inValidEditDescription();
		addbatchPage.inValidClasses();
		addbatchPage.SaveButton();
	}
	@Then("Admin should get a error message under the respective field")
	public void admin_should_get_a_error_message_under_the_respective_field() {
		Assert.assertEquals(addbatchPage.ClassesErrorMessage(),addbatchPage.ExpectedNumberClassesMessage());
		Assert.assertEquals(addbatchPage.DescriptionMessage(),addbatchPage.ExpectedDescriptionMessage());
	}
	@When("Admin enters the valid data to all the mandatory fields and click save button")
	public void admin_enters_the_valid_data_to_all_the_mandatory_fields_and_click_save_button() {
		addbatchPage.validEditDescription();
		addbatchPage.clickActiveButton();
		addbatchPage.ValidClasses();
		addbatchPage.SaveButton();
	}
	@Then("Admin should get a successful message for editing the batch")
	public void admin_should_get_a_successful_message_for_editing_the_batch() {
		Assert.assertEquals(addbatchPage.expectedSucessEditMessage(), addbatchPage.successEditMessage(), "Sucessful message");
	}
	@When("Admin enters the valid data to all the mandatory fields and click cancel button")
	public void admin_enters_the_valid_data_to_all_the_mandatory_fields_and_click_cancel_button() {
		addbatchPage.validEditDescription();
		addbatchPage.clickActiveButton();
		addbatchPage.ValidClasses();
		addbatchPage.CancelButton();
		
	}
	@Then("Admin can see the batch details popup closes without editing the batch")
	public void admin_can_see_the_batch_details_popup_closes_without_editing_the_batch() {
		Assert.assertTrue(addbatchPage.isBatchDetailsPopUpInvisible(),"Batch detail pop up is cancelled");
	}
	@When("Admin clicks the delete Icon on any row")
	public void admin_clicks_the_delete_Icon_on_any_row() {
		addbatchPage.clickDeleteButton();
	}
	@Then("Admin should see the confirm alert box with yes and no button")
	public void admin_should_see_the_confirm_alert_box_with_yes_and_no_button() {
		Assert.assertTrue(addbatchPage.confirmTextVisible(),"We are in delete page");
	}
	@Given("Admin is on the batch confirm popup page")
	public void admin_is_on_the_batch_confirm_popup_page() {
		addbatchPage.clickDeleteButton();
	}
	@When("Admin clicks on the delete icon and click yes button")
	public void admin_clicks_on_the_delete_icon_and_click_yes_button() {
		addbatchPage.deleteYesButton();
	}
	@Then("Admin should see the successful message and the batch should be deleted")
	public void admin_should_see_the_successful_message_and_the_batch_should_be_deleted() {
		Assert.assertEquals(addbatchPage.deleteMessageSuccess(), addbatchPage.expectedDeletMessageSuccess());
	}
	@When("Admin clicks on the delete icon and click no button")
	public void admin_clicks_on_the_delete_icon_and_click_no_button() {
		addbatchPage.deleteNoButton();
	}
	@Then("Admin should see the alert box closed and the batch is not deleted")
	public void admin_should_see_alert_box_closed_and_the_batch_is_not_deleted() {
		Assert.assertTrue(addbatchPage.backOnManagePage());
	}
	@When("Admin clicks on the close icon")
	public void admin_clicks_on_the_close_icon() {
		addbatchPage.deleteCloseButton();
	}
	@Then("Admin should see the alert box closed")
	public void admin_should_see_the_alert_box_closed() {
		Assert.assertTrue(addbatchPage.backOnManagePage());
	}
//	@When("Admin clicks on the delete icon under the Manage batch header")
//	public void admin_clicks_on_the_delete_icon_under_the_Manage_batch_header() {
//		addbatchPage.checkboxDelete();
//		addbatchPage.deleteSelectedCheckBox();
//		addbatchPage.deleteCheckBoxButton();
//	}
//	@Then("The respective row in the table should be deleted")
//	public void the_respective_row_in_the_table_should_be_deleted() {
//		Assert.assertEquals(addbatchPage.deleteMessageSuccess(), addbatchPage.expectedDeletMessageSuccess());
//	}
//Pagination
	@When("Admin clicks next page link on the data table")
	public void admin_clicks_next_page_link_on_the_data_table() {
		addbatchPage.clickNextButton();
	}
	@Then("Admin should see the Next enabled link")
	public void admin_should_see_the_Next_enabled_link() {
		Assert.assertTrue(addbatchPage.isNextButtonEnabled());
	}
	@When("Admin clicks last page link on the data table")
    public void  admin_clicks_last_page_link_on_the_data_table() {
		addbatchPage.clickLastLink();
	}
	@Then("Admin should see the last page link with next page link disabled on the table")
	public void admin_should_see_the_last_page_link_with_next_page_link_disabled_on_the_table() {
		Assert.assertTrue(!addbatchPage.isLastButtonEnabled());
		Assert.assertTrue(!addbatchPage.isNextButtonEnabled());
	}
	@When("Admin clicks previous page link on the data table")
	public void admin_clicks_previous_page_link_on_the_data_table() {
		addbatchPage.clickPreviousLink();
	}
	@Then("Admin should see the previous page on the table")
	public void admin_should_see_the_previous_page_on_the_table() {
		Assert.assertTrue(!addbatchPage.isPreviousButtonEnabled());
	}
	@When("Admin clicks first page link on the data table")
	public void admin_clicks_first_page_link_on_the_data_table() {
		addbatchPage.clickFirstLink();
	}
	@Then("Admin should see the very first page on the data table")
	public void admin_should_see_the_very_first_page_on_the_data_table() {
		Assert.assertTrue(!addbatchPage.isFirstButtonEnabled());
	}
	@When("Admin enters the batch name {string} in the search text box") // make sure you change it to match the feature file
	public void admin_enters_the_batch_name_in_the_search_text_box(String searchText) {
		addbatchPage.enterSearchText(searchText);
	}

	@Then("Admin should see the filtered batches containing {string} in the data table")
	public void admin_should_see_the_filtered_batches_in_the_data_table(String searchText) {
		
		    int count = addbatchPage.getMatchingRowsCount(searchText);
		    Assert.assertTrue(count > 0);

	}

}
	



