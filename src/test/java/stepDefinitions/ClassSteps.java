package stepDefinitions;

import org.openqa.selenium.By;
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

import java.util.HashMap;
import java.util.List;

public class ClassSteps {

	TestContext testContext;
	LoginPage loginPage;
	ClassPage classPage;
	List<HashMap<String, String>> datamap; // Data driven



	public ClassSteps(TestContext testContext) {
		this.testContext = testContext;
		this.loginPage = testContext.getLoginPage();
		this.classPage = testContext.getClassPage();
	}
	

	@Given("Admin is on the home Page")
	public void admin_is_on_the_home_page() {
		
		LogHelper.info("Admin is on class Home page");
		Assert.assertEquals(classPage.getCurrentUrl(), ConfigReader.getBaseUrl());
	}

	@When("Admin clicks the Class Navigation bar in the Header")
	public void admin_clicks_the_class_navigation_bar_in_the_header() {
	    classPage.clickBtnClass();
	    
	}

	@Then("Admin should land on the Manage class page")
	public void admin_should_land_on_the_manage_class_page() {
		LogHelper.info("Admin should land on the Manage class page");
		Assert.assertEquals(classPage.getCurrentUrl(), ConfigReader.getManageClassUrl());
	}
	@Then("Admin should see the {string} Title")
	public void admin_should_see_the_title(String pageTitile) {
		Assert.assertEquals(classPage.getPageTitle(), pageTitile);
	}

	@Then("Admin should see the {string} Header")
	public void admin_should_see_the_header(String pageHeader) {
		Assert.assertEquals(classPage.getPageHeader(), pageHeader);
	}
	@Then("Admin should see the Search Bar in Manage class page")
	public void admin_should_see_the_search_bar_in_manage_class_page() {
	    Assert.assertTrue(classPage.isSearchBoxVisible());
	}
	@Then("Admin should see the dataTable heading like {string}")
	public void admin_should_see_the_datatable_heading_like(String tableHeading) {
		Assert.assertEquals(classPage.dataTableHeaders(), tableHeading);
	}


}
