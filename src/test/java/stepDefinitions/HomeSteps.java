package stepDefinitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;

import driver.TestContext;
import io.cucumber.java.en.Then;
import pageObjects.HomePage;
import utils.ConfigReader;
import utils.DataReader;
import utils.LogHelper;

public class HomeSteps {

	TestContext testContext;
	HomePage homePage;
	private static int VALID_LOGIN_ROW_INDEX = 0;
	private static String ADMIN_ROLE = "ADMIN";
	private static int PAGE_SIZE = 5;

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
	
	@Then("Admin should see piechart")
	public void admin_should_see_piechart() {
		Assert.assertTrue(homePage.isPieChartVisible());
	}
	
	@Then("Admin should see welcome message with user name and role")
	public void admin_should_see_welcome_message_with_user_name_and_role() {
		List<HashMap<String, String>> datamap = DataReader.data(System.getProperty("user.dir") + "\\testData\\ExcelData.xlsx", "LoginPage");
		datamap = DataReader.data(System.getProperty("user.dir") + "\\testData\\ExcelData.xlsx", "LoginPage");
		String userName = datamap.get(VALID_LOGIN_ROW_INDEX).get("Username");
		
		Assert.assertEquals(homePage.getWecomeMessage(),"Welcome "+ userName); 
		Assert.assertEquals(homePage.getRoleName(), ADMIN_ROLE);
	}
	
	@Then("Admin should see bar chart for Active and inactive user")
	public void admin_should_see_bar_chart_for_active_and_inactive_user() {
		Assert.assertTrue(homePage.isBarChartVisible());
	}
	
	@Then("Admin should see user count")
	public void admin_should_see_user_count() {
		Assert.assertTrue(homePage.getUserCount() >= 0);
	}
	
	@Then("Admin should see staff count")
	public void admin_should_see_staff_count() {
		Assert.assertTrue(homePage.getStaffCount() >= 0);
	}
	
	@Then("Admin should see Program count")
	public void admin_should_see_program_count() {
		Assert.assertTrue(homePage.getProgramCount() >= 0);
	}
	
	@Then("Admin should see batch count")
	public void admin_should_see_batch_count() {
		Assert.assertTrue(homePage.getBatchCount() >= 0);
	}
	
	@Then("Admin should see staff table with pagination icons")
	public void admin_should_see_staff_table_with_pagination_icons() {
		Assert.assertTrue(homePage.isStaffTableVisibleWithPagination());
	}
	
	@Then("Admin should see 5 staff data in a page")
	public void admin_should_see_5_staff_data_in_a_page() {
		Assert.assertEquals(homePage.getStaffTablePageSize(), PAGE_SIZE);
	}
	
	@Then("Admin should see previous page icon disabled")
	public void admin_should_see_previous_page_icon_disabled() {
		Assert.assertFalse(homePage.isPreviousPageButtonEnabled());
	}
	
	@Then("Admin should see first page icon disabled")
	public void admin_should_see_first_page_icon_disabled() {
		Assert.assertFalse(homePage.isFirstPageButtonEnabled());
	}

}
