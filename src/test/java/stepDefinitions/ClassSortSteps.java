package stepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;


import java.util.List;
import org.testng.Assert;

import driver.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ClassSortPage;


public class ClassSortSteps {
	TestContext testContext;
	ClassSortPage classSortPage;

	List<String> originalListBeforeSort;
	List<String> ExpectedSortedList;
	List<String> listAfterSorting;

	public ClassSortSteps(TestContext testContext) {
		this.testContext = testContext;
		this.classSortPage = testContext.getClassSortPage();
	}

	@When("Admin clicks on the Batchname sort icon")
	public void admin_clicks_on_the_batchname_sort_icon() throws InterruptedException {
		Thread.sleep(3000);
		originalListBeforeSort = classSortPage.getOriginalList("BatchName");
		classSortPage.clickBatchNameAsc();
	}

	@Then("Admin should see Class details are sorted by Batch Name")
	public void admin_should_see_class_details_are_sorted_by_batch_name() {
		// Create expected sorted list for comparison
		listAfterSorting = classSortPage.getOriginalList("BatchName");
		ExpectedSortedList = classSortPage.getSortedListAscending(listAfterSorting);

		System.out.println("Original List: " + originalListBeforeSort);
		System.out.println("List after clicking sort btn " + listAfterSorting);
		System.out.println("Expected Sorted List Ascending: " + ExpectedSortedList);
		// checking if list shown on page is not same after clicking sort
		assertNotEquals(listAfterSorting, originalListBeforeSort, "Sorting failed: List didn't change!");
		// check if the shown list is sorted
		Assert.assertEquals(listAfterSorting, ExpectedSortedList, "Sorting failed: Lists do not match!");
	}

	@When("Admin clicks on the Class topic sort icon")
	public void admin_clicks_on_the_class_topic_sort_icon() throws InterruptedException {

		Thread.sleep(3000);
		originalListBeforeSort = classSortPage.getOriginalList("ClassTopic");
		classSortPage.clickClassTopicAsc();
	}

	@Then("Admin should see Class details are sorted by Class Topic")
	public void admin_should_see_class_details_are_sorted_by_class_topic() {
		// Create expected sorted list for comparison
		listAfterSorting = classSortPage.getOriginalList("ClassTopic");
		ExpectedSortedList = classSortPage.getSortedListAscending(listAfterSorting);

		System.out.println("Original List: " + originalListBeforeSort);
		System.out.println("List after clicking sort btn " + listAfterSorting);
		System.out.println("Expected Sorted List Ascending: " + ExpectedSortedList);
		// checking if list shown on page is not same after clicking sort
		assertNotEquals(listAfterSorting, originalListBeforeSort, "Sorting failed: List didn't change!");
		// check if the shown list is sorted
		Assert.assertEquals(listAfterSorting, ExpectedSortedList, "Sorting failed: Lists do not match!");
	}

	@When("Admin clicks on the Class description  sort icon")
	public void admin_clicks_on_the_class_description_sort_icon() throws InterruptedException {
		Thread.sleep(3000);
		originalListBeforeSort = classSortPage.getOriginalList("ClassDescription");
		classSortPage.clickClassDcpnAsc();

//		int count = 1;
//		do {
//			List<String> elementsInOnePage = new ArrayList<>();
//			
//			elementsInOnePage = classSortPage.getOriginalList("ClassDescription");
//			System.out.println("elementsInOnePage=="+elementsInOnePage);
//			if(count == 1) {
//				// initializing originalListBeforeSort
//				originalListBeforeSort = elementsInOnePage;
//				count++;
//				System.out.println("count == " +count);
//			}
//			else {
//				originalListBeforeSort = Stream.concat(originalListBeforeSort.stream(), elementsInOnePage.stream())
//	                    .collect(Collectors.toList());
//			}
//				
//			
//			System.out.println("originalListBeforeSort=="+originalListBeforeSort);
//		}while(classSortPage.clickNextPageButton());
//		
//		//if(classSortPage.clickNextPageButton() == tr)
//		//originalListBeforeSort = classSortPage.getOriginalList("ClassDescription");
//		System.out.println("originalListBeforeSort=="+originalListBeforeSort);
//	    classSortPage.clickStatusAsc();
	}

	@Then("Admin should see Class details are sorted by Class Description")
	public void admin_should_see_class_details_are_sorted_by_class_description() {

		// Create expected sorted list for comparison
		listAfterSorting = classSortPage.getOriginalList("ClassDescription");
		ExpectedSortedList = classSortPage.getSortedListAscending(listAfterSorting);

		System.out.println("Original List: " + originalListBeforeSort);
		System.out.println("List after clicking sort btn " + listAfterSorting);
		System.out.println("Expected Sorted List Ascending: " + ExpectedSortedList);
		// checking if list shown on page is not same after clicking sort
		assertNotEquals(listAfterSorting, originalListBeforeSort, "Sorting failed: List didn't change!");
		// check if the shown list is sorted
		Assert.assertEquals(listAfterSorting, ExpectedSortedList, "Sorting failed: Lists do not match!");

	}

	@When("Admin clicks on the Status sort icon")
	public void admin_clicks_on_the_status_sort_icon() throws InterruptedException {

		Thread.sleep(3000);
		originalListBeforeSort = classSortPage.getOriginalList("Status");
		System.out.println("originalListBeforeSort==" + originalListBeforeSort);
		classSortPage.clickStatusAsc();
	}

	@Then("Admin should see Class details are sorted by Status")
	public void admin_should_see_class_details_are_sorted_by_status() {

		// Create expected sorted list for comparison
		listAfterSorting = classSortPage.getOriginalList("Status");
		ExpectedSortedList = classSortPage.getSortedListAscending(listAfterSorting);

		System.out.println("Original List: " + originalListBeforeSort);
		System.out.println("List after clicking sort btn " + listAfterSorting);
		System.out.println("Expected Sorted List Ascending: " + ExpectedSortedList);
		// checking if list shown on page is not same after clicking sort
		//assertNotEquals(listAfterSorting, originalListBeforeSort, "Sorting failed: List didn't change!");
		// check if the shown list is sorted
		Assert.assertEquals(listAfterSorting, ExpectedSortedList, "Sorting failed: Lists do not match!");
	}

	@When("Admin clicks on the Class Date sort icon")
	public void admin_clicks_on_the_class_date_sort_icon() throws InterruptedException {
		Thread.sleep(3000);
		originalListBeforeSort = classSortPage.getOriginalList("ClassDate");
		classSortPage.clickClassDateAsc();
	}

	@Then("Admin should see Class details are sorted by Class Date")
	public void admin_should_see_class_details_are_sorted_by_class_date() {
		// Create expected sorted list for comparison
		listAfterSorting = classSortPage.getOriginalList("ClassDate");
		ExpectedSortedList = classSortPage.getSortedListAscending(listAfterSorting);

		System.out.println("Original List: " + originalListBeforeSort);
		System.out.println("List after clicking sort btn " + listAfterSorting);
		System.out.println("Expected Sorted List Ascending: " + ExpectedSortedList);
		// checking if list shown on page is not same after clicking sort
		assertNotEquals(listAfterSorting, originalListBeforeSort, "Sorting failed: List didn't change!");
		// check if the shown list is sorted
		Assert.assertEquals(listAfterSorting, ExpectedSortedList, "Sorting failed: Lists do not match!");
	}

	@When("Admin clicks on the Staff Name sort icon")
	public void admin_clicks_on_the_staff_name_sort_icon() throws InterruptedException {
		Thread.sleep(3000);
		originalListBeforeSort = classSortPage.getOriginalList("StaffName");
		classSortPage.clickStaffNameAsc();
	}

	@Then("Admin should see Class details are sorted by Staff name")
	public void admin_should_see_class_details_are_sorted_by_staff_name() {
		// Create expected sorted list for comparison
		listAfterSorting = classSortPage.getOriginalList("StaffName");
		ExpectedSortedList = classSortPage.getSortedListAscending(listAfterSorting);

		System.out.println("Original List: " + originalListBeforeSort);
		System.out.println("List after clicking sort btn " + listAfterSorting);
		System.out.println("Expected Sorted List Ascending: " + ExpectedSortedList);
		// checking if list shown on page is not same after clicking sort
		assertNotEquals(listAfterSorting, originalListBeforeSort, "Sorting failed: List didn't change!");
		// check if the shown list is sorted
		Assert.assertEquals(listAfterSorting, ExpectedSortedList, "Sorting failed: Lists do not match!");

	}

}
