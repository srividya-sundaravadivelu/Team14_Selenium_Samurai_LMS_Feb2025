package stepDefinitions;

import org.testng.Assert;

import driver.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageObjects.*;
import utils.ConfigReader;
import utils.LogHelper;

public class LoginSteps {

	TestContext testContext;
	LoginPage loginPage;

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
	
	// Start of TODO - Change this after Login module is ready
	
	@Given("Admin is on login Page")
    public void admin_is_on_login_page() {
		loginPage.navigateToPage(ConfigReader.getLoginUrl());
    	LogHelper.info("Current page is " + loginPage.getCurrentUrl());
    }

    @When("Admin enter valid data in all field and clicks login button")
    public void admin_enters_valid_data_and_clicks_login() {
        loginPage.enterUsername("sdetnumpyninja@gmail.com");
        loginPage.enterPassword("Feb@2025");
        loginPage.selectRole("Admin");
        loginPage.clickLoginButton();
    }
    
    // End of TODO - Change this after Login module is ready

}
