package stepDefinitions;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

import org.testng.Assert;

import driver.TestContext;
import io.cucumber.java.en.*;
import pageObjects.EditProgramPage;
import utils.DataReader;
import utils.LogHelper;

public class EditProgramSteps {
	TestContext testContext;
	EditProgramPage editProgramPage;
	List<HashMap<String, String>> datamap; // Data driven
	int index;
	
		
	public EditProgramSteps(TestContext testContext) {
		this.testContext = testContext;
		this.editProgramPage = testContext.getEditProgramPage();
		
	}
	//**********Scenario 30 ,Scenario 31 Scenario 32********
	@When("Admin clicks on Edit option for particular program")
	public void admin_clicks_on_edit_option_for_particular_program(){
		editProgramPage.getRandomEditButton();
		
	}
		
	@Then("Admin lands on Program details form")
	public void admin_lands_on_program_details_form()  {
		Assert.assertTrue(editProgramPage.admin_lands_on_program_details_form());
	    
	}
	//**********Scenario 33********
	@When("Admin edits the program and click on save button")
	public void admin_edits_the_program_and_click_on_save_button() {
		datamap = DataReader.data(System.getProperty("user.dir") + "\\testData\\ExcelData.xlsx", "ProgramPage");
		String desiredProgram = datamap.get(index).get("Programname");
		editProgramPage.updateProgram(desiredProgram);
	   
	}
	
	@Then("Updated program name is seen by the Admin")
	public void updated_program_name_is_seen_by_the_admin() {
	    
	}	
	//**********Scenario 34********
	@When("Admin edits the details from excel row {string} and click on save button")
	public void admin_edits_the_details_from_excel_row_and_click_on_save_button(String desiredProgramName){	
		editProgramPage.clickEditButtonForProgram();
		
	}

	@Then("Admin can see the successful message as {string}")
	public void admin_can_see_the_successful_message_as(String expectedSuccessMessage) {
		String actualSuccessMessage = editProgramPage.successUpdateMessage();
		
		String[] words = actualSuccessMessage.split("\\s+");
		System.out.println("Actual message is : " + words[0]+" "+words[1]+" "+words[2]);
		String newActualMessage= words[0]+" "+words[1]+" "+words[2];
		System.out.println(words[0]);
		
	    String expectedMessage = "Successful Program Updated";
	    System.out.println(newActualMessage.equalsIgnoreCase(expectedMessage)); 	
	   	Assert.assertEquals(expectedMessage, newActualMessage);		
	}

}
