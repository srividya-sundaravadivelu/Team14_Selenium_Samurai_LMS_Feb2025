package stepDefinitions;


import org.testng.Assert;

import driver.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageObjects.*;
import utils.ConfigReader;
import utils.LogHelper;

import java.util.HashMap;
import java.util.List;

public class ClassSteps {

	TestContext testContext;
	ClassPage classPage;
	LoginPage loginPage;
	List<HashMap<String, String>> datamap; // Data driven

	public ClassSteps(TestContext testContext) {
		this.testContext = testContext;
		this.classPage = testContext.getClassPage();
		this.loginPage = testContext.getLoginPage();
	}

	@Given("Admin is on the home Page for class")
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

	@Then("Admin should see the {string} Title On Class Page")
	public void admin_should_see_the_title_class(String pageTitile) {
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

	@Then("Admin should see the showing x to y of  z entries and enabled pagination controls under the data table")
	public void admin_should_see_the_showing_x_to_y_of_z_entries_and_enabled_pagination_controls_under_the_data_table()
			throws InterruptedException {
		String totalClassText = classPage.getTotalClassesText();
		Thread.sleep(2000);
		System.out.println("totalClassText = " + totalClassText);
		String paginationText = classPage.getPaginationText();
		int totalClasses = classPage.totalNoOfClasses();
		System.out.println(paginationText);
		System.out.println(classPage.getTotalClassesText());
		String sub = "of " + totalClasses + " entries";
		System.out.println("sub Text = " + sub);
		Assert.assertTrue(paginationText.contains(sub));
	}

	@Then("Admin should see the Sort icon of all the field in the datatable.")
	public void admin_should_see_the_sort_icon_of_all_the_field_in_the_datatable() {
		System.out.println("headerSortIconListState is enabled;" + classPage.isHeaderSortIconListVisible());
		Assert.assertEquals(classPage.isHeaderSortIconListVisible(), true);
	}

	@Then("Admin should see the Delete button under the Manage class page header.")
	public void admin_should_see_the_delete_button_under_the_manage_class_page_header() {
		Assert.assertTrue(classPage.isDeleteAllBtnDisplayed());
	}

	@Then("Admin should see Total no of classes in below of the data table.")
	public void admin_should_see_total_no_of_classes_in_below_of_the_data_table() {
		Assert.assertTrue(classPage.isTotalClassesDisplayed());
	}

    @When("Admin clicks Next page link on the class table")
    public void adminClicksNextPageLinkOnTheClassTable() throws InterruptedException {
		Assert.assertTrue(classPage.clicknextpage());
    }

	@Then("Admin should see the next page record on the table with Pagination has previous active link enabled")
	public void adminShouldSeeTheNextPageRecordOnTheTableWithPaginationHasNextActiveLinkEnabled() throws InterruptedException {

		String text = classPage.getShowingResultsText();
		LogHelper.info("Text found as : " + text);
		Assert.assertTrue(text.contains("Showing 11 to "));
	}

	@When("Admin clicks Previous page link on the class table")
	public void adminClicksPreviousPageLinkOnTheClassTable() throws InterruptedException {
		Assert.assertTrue(classPage.clickPreviousPage());
	}

	private void validateShowingOne() throws InterruptedException {
		String text = classPage.getShowingResultsText();
		LogHelper.info("Text found as : " + text);
		Assert.assertTrue(text.contains("Showing 1 to "));
	}

	@Then("Admin should see the previous page record on the table with Pagination has next active link enabled")
	public void adminShouldSeeThePreviousPageRecordOnTheTableWithPaginationHasNextActiveLinkEnabled() throws InterruptedException {
		validateShowingOne();
	}

	@When("Admin clicks Last page link on the class table")
	public void adminClicksLastPageLinkOnTheClassTable() {
		classPage.clickLastPage();
	}

	@Then("Admin should see the last page record on the table with Pagination has first active link enabled")
	public void adminShouldSeeTheLastPageRecordOnTheTableWithPaginationHasFirstActiveLinkEnabled() throws InterruptedException {
		String text = classPage.getShowingResultsText();
		LogHelper.info("Text found as : " + text);
		Assert.assertFalse(text.contains("Showing 1 to "));
	}

	@When("Admin clicks First page link on the class table")
	public void adminClicksFirstPageLinkOnTheClassTable() {
		classPage.clickFirstPage();
	}

	@Then("Admin should see the first page record on the table with Pagination has last active link enabled")
	public void adminShouldSeeTheFirstPageRecordOnTheTableWithPaginationHasLastActiveLinkEnabled() throws InterruptedException {
		validateShowingOne();
	}
}
