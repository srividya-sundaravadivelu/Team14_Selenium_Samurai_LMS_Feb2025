package stepDefinitions;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import driver.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageObjects.*;
import utils.ConfigReader;
import utils.DataReader;
import utils.LogHelper;

import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;

public class AddClassPopUpSteps {

	TestContext testContext;
	LoginPage loginPage;
	AddNewClassPage addNewClassPage;
	AddClassPopUp addClassPopUp;
	List<HashMap<String, String>> datamap; // Data driven
	String classCreatedMessage;

	public void dataInitialization() {
        if (datamap == null) {
            datamap = DataReader.data(System.getProperty("user.dir") + "\\testData\\ExcelData.xlsx", "ClassPage");
        }
    }
	public AddClassPopUpSteps(TestContext testContext) {
		this.testContext = testContext;
		this.addNewClassPage = testContext.getAddNewClassPage();
		this.addClassPopUp = testContext.getAddClassPopUp();
	}
	@Given("Admin is on the Class Popup window")
	public void admin_is_on_the_class_popup_window() {
		LogHelper.info("Admin is on the Class Popup window");
		Assert.assertEquals(addNewClassPage.getWindowtitle(), "Class Details");
	}

	@When("Admin enters mandatory fields in the form from excel row {string} and clicks on save button")
	public void admin_enters_mandatory_fields_in_the_form_from_excel_row_and_clicks_on_save_button(String rows) throws InterruptedException {
		
		LogHelper.info("entering new class details");
		dataInitialization();
		//datamap = DataReader.data(System.getProperty("user.dir") + "\\testData\\ExcelData.xlsx", "ClassPage");
		LogHelper.info("user fills data from excel");
		int index = Integer.parseInt(rows) - 1;
		HashMap<String,String> classDetails = datamap.get(index);
		//classCreatedMessage = addClassPopUp.addingMandatoryFields(classDetails);
		System.out.println(classDetails.get("ClassDescription"));
		classCreatedMessage = addClassPopUp.addingMandatoryFields(classDetails);
		//Thread.sleep(1000);
		//classCreatedMessage = addClassPopUp.getClassCreatedMessage();
	}

	@Then("Admin gets message Class added Successfully")
	public void admin_gets_message_class_added_successfully() {
	    
	}

	@When("Admin skips to add value in mandatory field and enter only the optional field from excel row {string} and clicks on save button")
	public void admin_skips_to_add_value_in_mandatory_field_and_enter_only_the_optional_field_from_excel_row_and_clicks_on_save_button(String rows) throws InterruptedException {
		LogHelper.info("entering new class details");
		datamap = DataReader.data(System.getProperty("user.dir") + "\\testData\\ExcelData.xlsx", "ClassPage");
		LogHelper.info("user fills data from excel");
		int index = Integer.parseInt(rows) - 1;
		HashMap<String,String> classDetails = datamap.get(index);
		addClassPopUp.skippingMandatoryFields(classDetails);
//		classCreatedMessage = addClassPopUp.skippingMandatoryFields(classDetails);
//		System.out.println("message======"+classCreatedMessage);
	}

	@Then("Admin should see error message below the test field and the field will be highlighted in red color")
	public void admin_should_see_error_message_below_the_test_field_and_the_field_will_be_highlighted_in_red_color() {
		LogHelper.info("Mandatory fields required!");
		assertTrue(addClassPopUp.isBatchNameReqMsgVisible());
		assertTrue(addClassPopUp.isClassDateReqMsgVisible());
	}
	
	@When("Admin clicks on save button without entering data")
	public void admin_clicks_on_save_button_without_entering_data() {
		addClassPopUp.clickSaveBtn();
	}

	@Then("class wont be created and Admin gets error message")
	public void class_wont_be_created_and_admin_gets_error_message() {
		LogHelper.info("Mandatory fields required!");
		assertTrue(addClassPopUp.isBatchNameReqMsgVisible());
		assertTrue(addClassPopUp.isClassDateReqMsgVisible());
		assertTrue(addClassPopUp.isClassTopicReqMsgVisible());
		assertTrue(addClassPopUp.isNoOfClassesReqMsgVisible());
		assertTrue(addClassPopUp.isStaffNameReqMsgVisible());
		
	  
	}
	
	

}
