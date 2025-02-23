package stepDefinitions;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import driver.TestContext;
import io.cucumber.java.en.*;
import pageObjects.HomePage;
import pageObjects.Program1Page;
import utils.ConfigReader;
import utils.LogHelper;

public class Program1Steps {
	
	TestContext testContext;
	Program1Page programPage;	
	HomePage homePage;
	
	public Program1Steps(TestContext testContext) {
		this.testContext = testContext;
		this.programPage = testContext.getProgramPage();
		this.homePage = testContext.getHomePage();		
	}
		
	@Given("Admin is on home page after Login")
	public void admin_is_on_home_page_after_login() {				
		LogHelper.info(homePage.getCurrentUrl());		
		LogHelper.info("Admin is on Home page");				
		Assert.assertEquals(homePage.getCurrentUrl(), ConfigReader.getBaseUrl());
				
	}

	@When("Admin clicks {string} on the navigation bar")
	public void admin_clicks_on_the_navigation_bar(String string) {
	    programPage.clickOnNavigationBar(string);
	}

	@Then("Admin should be navigated to {string} page")
	public void admin_should_be_navigated_to_page(String string) {
		System.out.println("****************"+programPage.getCurrentUrl());
		programPage.admin_should_be_navigated_to_page(string);
	   
	}
	//**********Scenario 2********
	@Then("Admin should see {string} in menu bar")
	public void admin_should_see_in_menu_bar(String string) {
	    programPage.admin_should_see_in_menu_bar(string);
	}
	
	//**********Scenario 3********
	@Then("Admin should see the heading {string}")
	public void admin_should_see_the_heading(String string) {
		programPage.admin_should_see_the_heading(string);
	    
	}
	//**********Scenario 4********
	@Then("Admin should see the page names as in order {string}")
	public void admin_should_see_the_page_names_as_in_order(String expectedPages) {
		List<String> expectedModules = Arrays.asList(expectedPages.split(", "));
	    List<String> actualModules = programPage.admin_should_see_the_page_names_as_in_order();
	    Assert.assertEquals(actualModules, expectedModules);
	
	}
	//**********Scenario 5********
	@Given("Admin is on Program page")
	public void admin_is_on_program_page() {
		//programPage.navigateToPage(ConfigReader.getProgramUrl());
		LogHelper.info(programPage.getCurrentUrl());		
		LogHelper.info("Admin is on Program page");
	    
	}

	@Then("Admin should see sub menu in menu bar as {string}")
	public void admin_should_see_sub_menu_in_menu_bar_as(String add_new_program) {
		programPage.admin_should_see_sub_menu_in_menu_bar_as(add_new_program);
	    
	}
	

}
