package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import driver.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageObjects.*;
import utils.ConfigReader;
import utils.DataReader;
import utils.LogHelper;

import java.util.HashMap;
import java.util.List;

public class EditClassSteps {

	TestContext testContext;
	
	EditClassPage editClassPage;
	List<HashMap<String, String>> datamap; // Data driven



	public EditClassSteps(TestContext testContext) {
		this.testContext = testContext;
		
		this.editClassPage = testContext.getEditClassPage();
	}

	@When("Admin clicks on the edit icon")
	public void admin_clicks_on_the_edit_icon() {
		LogHelper.info("Clicking random edit button");
		editClassPage.getRandomEditButton();
	   
	}

	@Then("A new pop up with class details appears")
	public void a_new_pop_up_with_class_details_appears() {
	    
	}
}
