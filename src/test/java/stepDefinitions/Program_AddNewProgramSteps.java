package stepDefinitions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;

import driver.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Program1Page;
import utils.DataReader;
import utils.LogHelper;

public class Program_AddNewProgramSteps {
	TestContext testContext;
	Program1Page addNewProgramPage;
	List<HashMap<String, String>> datamap; // Data driven
	int index;
	
	public Program_AddNewProgramSteps(TestContext testContext) {
		this.testContext = testContext;
		this.addNewProgramPage = testContext.getProgramPage();
		
	}
	
	//**********Scenario 6********
		@When("Admin clicks on {string} under the {string} menu bar")
		public void admin_clicks_on_under_the_menu_bar(String string, String string2) throws InterruptedException {
			addNewProgramPage.click_On_Add_New_Program_Btn();
		}

		@Then("Admin should see pop up window for program details")
		public void admin_should_see_pop_up_window_for_program_details(){
			Assert.assertTrue(addNewProgramPage.admin_should_see_pop_up_window_for_program_details());
		    
		}
		//**********Scenario 7********
		@Then("Admin should see window title as {string}")
		public void admin_should_see_window_title_as(String expectedTitle) {
			String actualTitle =addNewProgramPage.admin_should_see_window_title_as(); 
			System.out.println("Actual Title is : "+actualTitle);
			Assert.assertEquals(actualTitle, expectedTitle);
		}
		//**********Scenario 8********
		@Then("Admin should see red  asterisk mark  beside mandatory field {string}")
		public void admin_should_see_red_asterisk_mark_beside_mandatory_field(String string) {
			Assert.assertTrue(addNewProgramPage.admin_should_see_red_asterisk_mark_beside_mandatory_field());
		  
		}
		//**********Scenario 9********
		@Given("Admin is on Program details form")
		public void admin_is_on_program_details_form() {		
			LogHelper.info("Admin is on Program details form");
			addNewProgramPage.click_On_Add_New_Program_Btn();
		   
		}

		@When("Admin clicks save button without entering mandatory fields")
		public void admin_clicks_save_button_without_entering_mandatory_fields() throws InterruptedException {
					
			addNewProgramPage.clickOnSaveBtn();
		}
		@Then("Admin gets message {string}")
		public void admin_gets_message(String string) {
			List<String> expectedErrors = Arrays.asList(
				    "Program name is required.",
				    "Description is required.",
				    "Status is required."
				);
			List<String> actualErrors = addNewProgramPage.validate_RequiredFields_ErrorMessage();
			Assert.assertEquals(actualErrors, expectedErrors);
		   
		}
		//**********Scenario 10********
		@When("Admin clicks Cancel button")
		public void admin_clicks_cancel_button() {
			addNewProgramPage.clickOnCancelBtn();
		   
		}

		@Then("Admin can see Program Details form disappears")
		public void admin_can_see_program_details_form_disappears() {
			Assert.assertTrue(addNewProgramPage.disappears_Program_Details_form(), "The pop-up window did not disappear after clicking the Cancel button.");			
		    
		}
		//**********Scenario 11********
		@When("Admin enters the Name in the text box from excel row {string}")
		public void admin_enters_the_name_in_the_text_box_from_excel_row(String rows) {
			LogHelper.info("entering program name");
			datamap = DataReader.data(System.getProperty("user.dir") + "\\testData\\ExcelData.xlsx", "ProgramPage");
			LogHelper.info("user fills data from excel");
			index = Integer.parseInt(rows) - 1;		
			
			addNewProgramPage.enterProgramname(datamap.get(index).get("Programname"));
		    
		}
		@Then("Admin can see the text entered in Name box")
		public void admin_can_see_the_text_entered_in_name_box() {
			String expectedProgramName = datamap.get(index).get("Programname");
			String actualProgramName = addNewProgramPage.enterProgramname(expectedProgramName);
			System.out.println(expectedProgramName+"**************");
			System.out.println(actualProgramName+"**************");
			Assert.assertEquals(actualProgramName, expectedProgramName,"The Program names do not match.");
		}
	
		//*******************Checking code For multiple fields
		
		/*@When("Admin enters the respective {string} in the text box from excel row {string}")
		public void admin_enters_the_respective_in_the_text_box_from_excel_row(String rows, String string2) {
			LogHelper.info("entering username and password");
			datamap = DataReader.data(System.getProperty("user.dir") + "\\testData\\ExcelData.xlsx", "ProgramPage");
			LogHelper.info("user fills data from excel");
			index = Integer.parseInt(rows) - 1;		
			
			addNewProgramPage.enterProgramname(datamap.get(index).get("Programname"));
			addNewProgramPage.enterProgramDesc(datamap.get(index).get("Programdescription"));
			
		    
		}

		@Then("Admin can see the text entered in respective {string} box")
		public void admin_can_see_the_text_entered_in_respective_box(String string) {
			String expectedProgramName = datamap.get(index).get("Programname");
			String actualProgramName = addNewProgramPage.enterProgramname(expectedProgramName);
			System.out.println(expectedProgramName+"**************");
			System.out.println(actualProgramName+"**************");
			Assert.assertEquals(actualProgramName, expectedProgramName,"The Program names do not match.");
			System.out.println(datamap.get(index).get("Programdescription"));
		  
		}*/
		
		
		//**********Scenario 12********
		@When("Admin enters the Description in the text box from excel row {string}")
		public void admin_enters_the_description_in_the_text_box_from_excel_row(String rows) {
			LogHelper.info("entering program description");
			datamap = DataReader.data(System.getProperty("user.dir") + "\\testData\\ExcelData.xlsx", "ProgramPage");
			LogHelper.info("user fills data from excel");
			index = Integer.parseInt(rows) - 1;		
			
			addNewProgramPage.enterProgramDesc(datamap.get(index).get("Programdescription"));
		   
		}

		@Then("Admin can see the text entered in Description box")
		public void admin_can_see_the_text_entered_in_description_box() {
			String expectedProgramDesc = datamap.get(index).get("Programdescription");
			String actualProgramDesc = addNewProgramPage.enterProgramDesc(expectedProgramDesc);
			System.out.println(expectedProgramDesc+"**************");
			System.out.println(actualProgramDesc+"**************");
			Assert.assertEquals(actualProgramDesc, expectedProgramDesc,"The Program descriptions do not match.");
		    
		}
		
		//**********Scenario 13********
		@When("Admin selects the Status of the program by clicking on the radio button {string}")
		public void admin_selects_the_status_of_the_program_by_clicking_on_the_radio_button(String status) {
			addNewProgramPage.selectStatus();
		   
		}

		@Then("Admin can see {string} Status selected")
		public void admin_can_see_status_selected(String string) {
			
			
		    
		}
		//**********Scenario 14********
		
		@When("Admin enter valid details for mandatory fields from excel row {string} and Click on Save button")
		public void admin_enter_valid_details_for_mandatory_fields_from_excel_row_and_click_on_save_button(String rows) {
			datamap = DataReader.data(System.getProperty("user.dir") + "\\testData\\ExcelData.xlsx", "ProgramPage");
			LogHelper.info("user fills data from excel");
			index = Integer.parseInt(rows) - 1;		
			addNewProgramPage.enterProgramname(datamap.get(index).get("Programname"));
			addNewProgramPage.enterProgramDesc(datamap.get(index).get("Programdescription"));
			addNewProgramPage.selectStatus();
			addNewProgramPage.clickOnSaveBtn();
		}

		
		@Then("Admin gets success message as {string}")
		public void admin_gets_success_message_as(String expectedSuccessMessage) {
			//String actualSuccessMessage = addNewProgramPage.ValidateSuccessProgramCreatedMessage();
			//System.out.println("Actual Message after creating Program----> "+actualSuccessMessage);
			//Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage);
			
					  
		}
		//**********Scenario 17********
		@When("Admin Click on {string} button")
		public void admin_click_on_button(String string) {
		    addNewProgramPage.click_On_Close_Icon();
		}




}
