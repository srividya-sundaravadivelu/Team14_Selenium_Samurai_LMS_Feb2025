package stepDefinitions;

import driver.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.LogoutPage;
import utils.ConfigReader;
import utils.LogHelper;

public class LogoutSteps {
    TestContext testContext;
    LogoutPage logoutPage;


    public LogoutSteps(TestContext testContext) {
        this.testContext = testContext;
        this.logoutPage = testContext.getLogoutpage();
    }
    @Given("Admin is on home page")
    public void admin_is_on_home_page() {
        logoutPage.navigateToPage(ConfigReader.getBaseUrl());
        LogHelper.info(logoutPage.getCurrentUrl());
    }

    @When("Admin clicks on the logout in the menu bar")
    public void admin_clicks_on_the_logout_in_the_menu_bar() {
        logoutPage.logout();

    }
    @Then("Admin should be redirected to login page")
    public void admin_should_be_redirected_to_login_page() {
        Assert.assertEquals(logoutPage.getCurrentUrl(), ConfigReader.getLoginUrl());
        LogHelper.info("Admin is on Login page");
    }
    @Given("Admin is on login page")
    public void admin_is_on_login_page() {
        logoutPage.navigateToPage(ConfigReader.getLoginUrl());
        LogHelper.info(logoutPage.getCurrentUrl());
    }
    @When("Admin clicks  browser back button")
    public void admin_clicks_browser_back_button() {
        logoutPage.clickBackButton();
    }
    @Then("Admin should receive error message")
    public void admin_should_receive_error_message() {
        Assert.assertEquals(logoutPage.getCurrentUrl(), ConfigReader.getLoginUrl());
    }
}
