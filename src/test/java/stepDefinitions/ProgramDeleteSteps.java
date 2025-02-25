package stepDefinitions;

import org.testng.Assert;

import driver.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import pageObjects.ProgramDeletePage;

public class ProgramDeleteSteps {
	TestContext testContext;
	ProgramDeletePage programdeletepage;
	LoginPage loginPage;
	
	public ProgramDeleteSteps(TestContext testContext) {
		this.testContext = testContext;
		this.programdeletepage= testContext.getProgramDeletePage();
		this.loginPage=testContext.getLoginPage();
	}
	
	@Then("Admin clicks on Program page")
	public void admin_clicks_on_program_page() {
		programdeletepage.ClickOnProgram();
	}

	@When("Admin clicks on delete button on program page")
	public void admin_clicks_on_delete_button_on_program_page() {
		programdeletepage.ClickOnDeleteBtn();	    
	}

	@Then("Admin will get confirm deletion {string} in program page")
	public void admin_will_get_confirm_deletion_in_program_page(String string) {		
		String actualText = programdeletepage.getText(); 
	    System.out.println("Actual Text: " + actualText); 
	    Assert.assertNotNull(actualText);	    
	}

	@Given("Admin is on Confirm deletion form of program page")
	public void admin_is_on_confirm_deletion_form_of_program_page() {
		programdeletepage.ClickOnDeleteBtn();
	}

	@When("Admin clicks on Yes button for a program page")
	public void admin_clicks_on_yes_button_for_a_program_page() {
		programdeletepage.ClickYesDelete();
	}
	
	@Then("Admin can see Successful Program Deleted message in program page")
	public void admin_can_see_successful_program_deleted_message_in_program_page() {
		
		String actualMessage = programdeletepage.getSuccessMsg();		
		String[] words = actualMessage.split("\\s+");		
		String newactualMessage= words[0]+" "+words[1]+" "+words[2];			
	    String expectedMessage = "Successful Program Deleted";
	    	System.out.println(newactualMessage.equalsIgnoreCase(expectedMessage)); 	
	   	   Assert.assertEquals(expectedMessage, newactualMessage);
	}
	
	@When("Admin clicks on No button for a program page")
	public void admin_clicks_on_no_button_for_a_program_page() {
	    programdeletepage.ClickNoDelete();
	}

	@Then("Admin can see Confirmation form disappears in program page")
	public void admin_can_see_confirmation_form_disappears_in_program_page() {	    
		String actualTitle = programdeletepage.getPageTitle(); 
	    String expectedTitle = "Expected Page Title"; 
	    System.out.println("Actual Page Title: " + actualTitle); 
	    Assert.assertEquals("LMS", actualTitle);
	}

	@When("Admin clicks on multiple programs for delete in program page")
	public void admin_clicks_on_multiple_programs_for_delete_in_program_page() {
		programdeletepage.MultipleDeleteCheck();
	}

	@Then("Admin will get confirm deletion popup in program page for multiple deletes")
	public void admin_will_get_confirm_deletion_popup_in_program_page_for_multiple_deletes() {
		String actualText = programdeletepage.getConfimText();
		System.out.println("Actual Text: " + actualText); 
	    Assert.assertNotNull(actualText);
	}

	@When("Admin clicks on Yes button for multiple delete of program page")
	public void admin_clicks_on_yes_button_for_multiple_delete_of_program_page() {
		programdeletepage.MultipleDeleteProg();
	}
	@Then("Admin can see Successful Program Deleted message in program page for multiple")
	public void admin_can_see_successful_program_deleted_message_in_program_page_for_multiple() {
		String actualMessage = programdeletepage.multiGetSuccessMsg(); 
		String[] words = actualMessage.split("\\s+");		
		String newactualMessage= words[0];	
		String expectedMessage = "Successful";
	    	System.out.println(newactualMessage.equalsIgnoreCase(expectedMessage)); 	
	   	  Assert.assertEquals(expectedMessage, newactualMessage);
	}

	@When("Admin Click on X button for delete of program page")
	public void admin_click_on_x_button_for_delete_of_program_page() {
		programdeletepage.ClickClosePopup();
		//String actualTitle = programdeletepage.getPageTitle(); 
	}

	@Then("Admin can see Confirm Deletion form disappear from program page")
	public void admin_can_see_confirm_deletion_form_disappear_from_program_page() {
		String actualTitle = programdeletepage.getPageTitle(); 
	    String expectedTitle = "Expected Page Title"; // Replace with the correct expected title
	    System.out.println("Actual Page Title: " + actualTitle); 
	    Assert.assertEquals("LMS", actualTitle);
	}


}
