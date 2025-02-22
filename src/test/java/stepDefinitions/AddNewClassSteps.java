package stepDefinitions;

import org.testng.Assert;

import driver.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageObjects.*;
import utils.ConfigReader;
import utils.DataReader;
import utils.LogHelper;

import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;

public class AddNewClassSteps {

	TestContext testContext;
	LoginPage loginPage;
	AddNewClassPage addNewClassPage;
	List<HashMap<String, String>> datamap; // Data driven

	public AddNewClassSteps(TestContext testContext) {
		this.testContext = testContext;
		this.loginPage = testContext.getLoginPage();
		this.addNewClassPage = testContext.getAddNewClassPage();
	}
	@Given("Admin is on the Manage class page")
	public void admin_is_on_the_manage_class_page() {
		LogHelper.info("Admin is on the Manage class page");
		Assert.assertEquals(addNewClassPage.getCurrentUrl(), ConfigReader.getManageClassUrl());
	}

	@When("Admin clicks a add new class under the class menu bar")
	public void admin_clicks_a_add_new_class_under_the_class_menu_bar() {
	   addNewClassPage.addNewProgramClick();
	}

	@Then("Admin should see a popup open for class details along with SAVE and CANCEL button and Close\\(X) Icon")
	public void admin_should_see_a_popup_open_for_class_details_along_with_save_and_cancel_button_and_close_x_icon() {
		
		assertTrue(addNewClassPage.isClassDetailsVisible());
		assertTrue(addNewClassPage.isSaveBtnDisplayed());
		assertTrue(addNewClassPage.isCancelBtnDisplayed());
		assertTrue(addNewClassPage.isCloseIconDisplayed());
	}
	@Then("Admin should see few input fields and their respective text boxes in the class details window")
	public void admin_should_see_few_input_fields_and_their_respective_text_boxes_in_the_class_details_window() {
		assertTrue(addNewClassPage.batchNameOnPopupDisplayed());
		LogHelper.info("BatchName is visible");
		assertTrue(addNewClassPage.classTopicOnPopupDisplayed());
		LogHelper.info("Class Topic is visible");
	}


}
