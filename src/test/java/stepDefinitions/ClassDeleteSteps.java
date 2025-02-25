package stepDefinitions;

import org.testng.Assert;

import driver.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ClassDeletePage;
import pageObjects.LoginPage;
import pageObjects.ProgramDeletePage;

public class ClassDeleteSteps {
	TestContext testContext;
	ClassDeletePage classDeletePage;
	LoginPage loginPage;
	
	public ClassDeleteSteps(TestContext testContext) {
		this.testContext = testContext;
		this.classDeletePage= testContext.getClassDeletePage();
		this.loginPage=testContext.getLoginPage();
	}
	
	@When("Admin clicks the delete icon on class page")
	public void admin_clicks_the_delete_icon() {
		classDeletePage.clickOnDeleteIcon();
	}

	@Then("Admin should see a alert open with heading {string} along with  YES and NO button for deletion")
	public void admin_should_see_a_alert_open_with_heading_along_with_yes_and_no_button_for_deletion(String string) {
		classDeletePage.isConfirmDeleteMsgDisplayed();
		classDeletePage.isConfirmNoBtnDisplayed();
		classDeletePage.isConfirmYesBtnDisplayed();
	}
	@Given("Admin is on Confirm Deletion alert on class page")
	public void admin_is_on_confirm_deletion_alert_on_class_page() {
		classDeletePage.clickOnDeleteIcon();
	}

	@When("Admin clicks yes option on class page")
	public void admin_clicks_yes_option_on_class_page() {
	   classDeletePage.deleteSingleClass();
	}

	@Then("Admin gets a message {string} alert and do not see that Class in the data table")
	public void admin_gets_a_message_alert_and_do_not_see_that_class_in_the_data_table(String msg) {
		String actualMessage = classDeletePage.getSuccessMsg();		
		//String[] words = actualMessage.split("\\s+");		
		//String newactualMessage= words[0]+" "+words[1]+" "+words[2];			
	    //String expectedMessage = "Successful Program Deleted";
		System.out.println("msg = "+msg);
		System.out.println("actualMessage = "+actualMessage);
	    	System.out.println(actualMessage.equalsIgnoreCase(msg.trim())); 	
	   	   Assert.assertEquals(msg, actualMessage);
	}
	@When("Admin clicks  No option on class page")
	public void admin_clicks_no_option_on_class_page() {
		classDeletePage.cancelDeleteSingleClass();
	}

	@Then("Admin can see the deletion alert disappears without deleting on class page")
	public void admin_can_see_the_deletion_alert_disappears_without_deleting_on_class_page() {
	   
	}
	@When("Admin clicks on close button on class page")
	public void admin_clicks_on_close_button_on_class_page() {
	   
	}

	@Then("Admin can see the deletion alert disappears without any changes on class page")
	public void admin_can_see_the_deletion_alert_disappears_without_any_changes_on_class_page() {
	   
	}


}
