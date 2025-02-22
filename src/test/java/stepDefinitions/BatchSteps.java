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
	
	
}
