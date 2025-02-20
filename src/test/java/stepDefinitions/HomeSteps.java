package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import driver.TestContext;
import io.cucumber.java.en.Then;
import pageObjects.HomePage;
import utils.ConfigReader;
import utils.LogHelper;

public class HomeSteps {

	TestContext testContext;
	HomePage homePage;

	public HomeSteps(TestContext testContext) {
		this.testContext = testContext;
		this.homePage = testContext.getHomePage();
	}
	
	@Then("Admin should see LMS -Learning management system as title")
	public void admin_should_see_correct_title() {
		LogHelper.info("The Current title is:" + homePage.getPageTitle());
		Assert.assertEquals(homePage.getPageTitle(), ConfigReader.getHomePageTitle());
	}

	@Then("LMS title should be on the top left corner of page")
	public void lms_title_should_be_on_the_top_left_corner_of_page() {		
		Assert.assertTrue(homePage.isTitleOnTopLeft());
	}

	@Then("Admin should see correct spelling in navigation bar text")
	public void admin_should_see_correct_spelling_in_navigation_bar_text() throws IOException {
		Assert.assertFalse(homePage.hasNavBarSpellingMistakes());
	}
	
	@Then("Admin should see correct spelling and space in LMS title")
	public void admin_should_see_correct_spelling_and_space_in_lms_title() {
		LogHelper.info("The Current title is:" + homePage.getPageTitle());
		Assert.assertEquals(homePage.getPageTitle(), ConfigReader.getHomePageTitle());
	}
	
	@Then("Admin should see the navigation bar text on the top right side")
	public void admin_should_see_the_navigation_bar_text_on_the_top_right_side() {
		Assert.assertTrue(homePage.isNavBarOnTopRight());
	}
	
	@Then("Admin should see home in the 1st place")
	public void admin_should_see_home_in_the_1st_place() {
		Assert.assertEquals(homePage.getNavItemPosition("home"), 1);
	}
	
	@Then("Admin should see program in the 2nd place")
	public void admin_should_see_program_in_the_2nd_place() {
		Assert.assertEquals(homePage.getNavItemPosition("program"), 2);
	}
	
	@Then("Admin should see batch in the 3rd place")
	public void admin_should_see_batch_in_the_3rd_place() {
		Assert.assertEquals(homePage.getNavItemPosition("batch"), 3);
	}
	
	@Then("Admin should see class in the 4th place")
	public void admin_should_see_class_in_the_4th_place() {
		Assert.assertEquals(homePage.getNavItemPosition("class"), 4);
	}
	
	@Then("Admin should see logout in the 5th place")
	public void admin_should_see_logout_in_the_5th_place() {
		Assert.assertEquals(homePage.getNavItemPosition("logout"), 5);
	}

}
