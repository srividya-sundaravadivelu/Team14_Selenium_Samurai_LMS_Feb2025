package pageObjects;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import utils.LogHelper;
import utils.WebDriverWaitUtility;

public class Program1Page extends BasePage {
	
	List<String> actualModules;
	
	public Program1Page(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//span[@class='mat-button-wrapper']")
	List<WebElement> modules;
	
	@FindBy(id="program")
	WebElement programBtn;
	
	@FindBy(xpath="//*[@class='mat-card-title']//div[1]")
	WebElement title;
	
	@FindBy(xpath = "//span[contains(text(),'LMS')]")
	WebElement headerBoardText;
	
	@FindBy(xpath="//button[@role='menuitem']")
	WebElement addNewSubMenuModule;
	
	@FindBy(xpath = "//span[contains(text(),'Program Details')]")
	WebElement programDetailsTitle;
	
	@FindBy(xpath="//span[contains(text(),'*')]")
	List<WebElement> asteriskMark;
	
	@FindBy(xpath = "//div[@role='dialog']")
	WebElement programDetailsForm; 
	
	@FindBy(xpath = "//button[@id='saveProgram']")
	WebElement saveBtn;
	
	@FindBy(xpath = "//div//small")
	List<WebElement> requiredFieldsErrorMessage;
	
	@FindBy(xpath = "//span[contains(text(),'Cancel')]")
	WebElement cancelBtn;
	
	@FindBy(id="programName")
	WebElement programNameInput;
	
	@FindBy(id="programDescription")
	WebElement programDescInput;
	
	@FindBy(xpath = "//div[contains(text(),'Program Created Successfully')]")
	WebElement successProgramCreatedMessage;
	
	@FindBy(xpath = "//div[@class='p-dialog-header-icons ng-tns-c81-9']//button")
	WebElement closeIcon;
	
//	@FindBy(xpath = "//div[@class='radio ng-star-inserted']")
//	WebElement status;
	
	@FindBy(xpath="//input[@type='radio' and @value='Active']")
	WebElement activeStatusRadio;
	
	@FindBy(xpath="//input[@type='radio' and @value='Inactive']")
	WebElement inAactiveStatusRadio;
	
	
	
	
	public List<WebElement> getModules() {
	    return driver.findElements(By.xpath("//span[@class='mat-button-wrapper']"));
	}
	
	public void clickOnNavigationBar(String target) {		
	    List<WebElement> modulesList = getModules(); // Always get fresh elements

	    for (WebElement module : modulesList) {
	        if (module.getText().equals(target)) {
	            module.click();
	            return;
	        }
	    }
	}
					
	public void admin_should_be_navigated_to_page(String titlePage) {
		System.out.println("Targeted module is "+titlePage);
		
		for(WebElement module:modules) {
			if(module.getText().equals(titlePage)) {
				System.out.println("The Title on the current module " + titlePage +" is "+title.getText());
			}
		}
		
	}
	//**********Scenario 2********
	public void admin_should_see_in_menu_bar(String expectModule){
		System.out.println("Expected Module is: " +expectModule);

		for(WebElement module:modules)
		{
			actualModules = new ArrayList<String>();
			actualModules.add(module.getText());			
		}
	
		if(actualModules.contains(expectModule))
		{

			System.out.println("The actualModule is :  "+ actualModules);
			Assert.assertEquals(actualModules.get(0), expectModule);
			
		}
		
	}
	//**********Scenario 3********
	public void admin_should_see_the_heading(String expectedHeading) {
		System.out.println("Expected Heading is : "+expectedHeading);
		String actualHeaderText =headerBoardText.getText();
		
		if(actualHeaderText.equals(expectedHeading)) {
			System.out.println("Actual Heading is : "+headerBoardText.getText());
			Assert.assertEquals(actualHeaderText, expectedHeading);
		}
		
	}
	//**********Scenario 4********
	public List<String> admin_should_see_the_page_names_as_in_order() {
		actualModules = new ArrayList<String>();
		for(WebElement module:modules) {
			module = WebDriverWaitUtility.waitForElementToBeClickable(module);
			System.out.println("The modules are : " +module.getText());
			actualModules.add(module.getText());
		}		
		return actualModules;
		
	}
	//**********Scenario 5********
	public void admin_should_see_sub_menu_in_menu_bar_as(String expectedSubMenu) {
		System.out.println("Expected Sub Menu is :  " +expectedSubMenu);
		if(addNewSubMenuModule.isDisplayed()) {
			String actualSubMenu = addNewSubMenuModule.getText();
			System.out.println("Actual Sub Menu is : "+actualSubMenu);
			Assert.assertEquals(actualSubMenu, expectedSubMenu);
			
		}
		
	}
	
	//**********Scenario 6********
	
	public void click_On_Add_New_Program_Btn() {		
		WebDriverWaitUtility.waitForElementToBeClickable(addNewSubMenuModule).click();
				
	}
	public boolean admin_should_see_pop_up_window_for_program_details(){		
		boolean isProgramDetailsPopUpVisible = WebDriverWaitUtility.waitForElementToBeVisible(programDetailsTitle).isDisplayed();
		if (!isProgramDetailsPopUpVisible)
			LogHelper.error("Program Pop up Window is not visible");
		
		return isProgramDetailsPopUpVisible;
		
	}
	
	//**********Scenario 7********
	
	public String admin_should_see_window_title_as() {		
		return WebDriverWaitUtility.waitForElementToBeVisible(programDetailsTitle).getText();		
	}
	//**********Scenario 8********
	public boolean admin_should_see_red_asterisk_mark_beside_mandatory_field() {
		boolean isAsteriskMarkVisible = false;
		for(WebElement eachAsteriskMark :asteriskMark) {
			isAsteriskMarkVisible = eachAsteriskMark.isDisplayed();
			if(!isAsteriskMarkVisible)
				LogHelper.error("Asterisk Mark is not visible");
			
		}
		return isAsteriskMarkVisible;
		
	}
				
	//**********Scenario 9********
	public void clickOnSaveBtn(){		
		WebDriverWaitUtility.waitForElementToBeClickable(saveBtn).click();
	}
	
		
	public List<String> validate_RequiredFields_ErrorMessage() {
		List<String> actualErrors = requiredFieldsErrorMessage.stream()
		    .map(WebElement::getText)
		    .collect(Collectors.toList());
		List<String> expectedErrors = Arrays.asList(
		    "Program name is required.",
		    "Description is required.",
		    "Status is required."
		);
		return actualErrors;

	}
	//**********Scenario 10********
	public void clickOnCancelBtn() {		
		cancelBtn.click();
		
	}
	public boolean disappears_Program_Details_form() {		
		boolean isPopupDisappeared = WebDriverWaitUtility.waitForElementToBeInvisible(programDetailsForm);		
		System.out.println(isPopupDisappeared);
		return isPopupDisappeared;
		
	}
	//**********Scenario 11********
	
	public String enterProgramname(String programname) {
		programNameInput = WebDriverWaitUtility.waitForElementToBeClickable(programNameInput);
		programNameInput.clear();
		programNameInput.sendKeys(programname);
		return programNameInput.getAttribute("value");
		
	}
	//**********Scenario 12********
	public String enterProgramDesc(String description) {
		programDescInput = WebDriverWaitUtility.waitForElementToBeClickable(programDescInput);
		programDescInput.clear();
		programDescInput.sendKeys(description);
		return programDescInput.getAttribute("value");
		
	}	
	
	/*public void visibilityRadio() {
		List<WebElement> radios = driver.findElements(By.xpath("//input[@type='radio']"));
		System.out.println("Total radio buttons found: " + radios.size());
		for (WebElement radio : radios) {
		    System.out.println("Radio button value: " + radio.getAttribute("value") + " - Enabled: " + radio.isEnabled() + " - Displayed: " + radio.isDisplayed());
		}
	}*/
	//**********Scenario 13********
	public void selectStatus() {
	
	    WebElement statusRadio = driver.findElement(By.xpath("//div[contains(@class, 'p-radiobutton-box')]/span[contains(@class, 'p-radiobutton-icon')]"));
	   //Using Javascript Executor to apply force click
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", statusRadio);
	    statusRadio = WebDriverWaitUtility.waitForElementToBeClickable(statusRadio);
	    statusRadio.click();
	}
	//**********Scenario 14********
	public String ValidateSuccessProgramCreatedMessage() {
		return successProgramCreatedMessage.getText();
	}
	//**********Scenario 15********
	public void click_On_Close_Icon() {
		closeIcon.click();
		
	}
	
	
	
	

}
