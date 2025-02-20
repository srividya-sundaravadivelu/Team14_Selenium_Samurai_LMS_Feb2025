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

public class LoginSteps {

	TestContext testContext;
	LoginPage loginPage;
	List<HashMap<String, String>> datamap; // Data driven



	public LoginSteps(TestContext testContext) {
		this.testContext = testContext;
		this.loginPage = testContext.getLoginPage();
	}

	@Given("The browser is open")
	public void the_browser_is_open() {
		LogHelper.info("The browser is open");
	}

	@When("Admin gives the correct LMS portal URL")
	public void admin_gives_the_correct_lms_portal_url() {
		loginPage.navigateToPage(ConfigReader.getBaseUrl());
		LogHelper.info("Current page is " + loginPage.getCurrentUrl());
	}

	@Then("Admin should land on the login page")
	public void admin_should_land_on_the_login_page() {
		// TODO: Add more assertions as required.
		Assert.assertEquals(loginPage.getCurrentUrl(), ConfigReader.getLoginUrl());
	}
	@Given("Admin is on login Page")
	public void admin_is_on_login_page() {
    	loginPage.navigateToPage(ConfigReader.getLoginUrl());
		LogHelper.info(loginPage.getCurrentUrl());
	}

	@When("Admin enter valid data from excel row {string}")
	public void admin_enter_valid_data_from_excel_row(String rows) throws InterruptedException {
		LogHelper.info("entering username and password");
		datamap = DataReader.data(System.getProperty("user.dir") + "\\testData\\ExcelData.xlsx", "LoginPage");
		LogHelper.info("user fills data from excel");
		int index = Integer.parseInt(rows) - 1;		
		
		loginPage.enterUsername(datamap.get(index).get("Username"));
        loginPage.enterPassword(datamap.get(index).get("Password"));
        loginPage.selectRole("Admin");
        loginPage.clickLogin();
	}

	@Then("Admin should land on home page")
	public void admin_should_land_on_home_page() {
		LogHelper.info("Admin is on Home page");
		Assert.assertEquals(loginPage.getCurrentUrl(), ConfigReader.getBaseUrl());
	}
}
