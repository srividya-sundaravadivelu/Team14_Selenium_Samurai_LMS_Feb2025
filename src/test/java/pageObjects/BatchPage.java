package pageObjects;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import io.cucumber.java.en.Then;

public class BatchPage extends BasePage {
	 
	// BatchPage constructor
	public BatchPage(WebDriver driver) {
		super(driver);
	}
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	@FindBy(xpath="//button[contains(@class,'mat-button')]/span[text()='Batch']")
	private WebElement BatchButton;
	
	@FindBy(xpath="//div[text()=' Manage Batch']")
	private WebElement ManageBatchText;
	
	@FindBy(xpath="//mat-toolbar//span[text()=' LMS - Learning Management System ']")
	private WebElement LearningManagementSystemText;
	
	@FindBy(xpath="//button[contains(@class, 'p-button-danger')]")
	private WebElement DeleteIcon;
	@FindBy(xpath="//div[@class='p-paginator-bottom p-paginator p-component ng-star-inserted']")
	private WebElement PaginationControlTable;
	@FindBy(xpath="//span[@class='p-button-icon pi pi-pencil']")
	private List<WebElement> isEditButtonEnable;
	@FindBy(xpath="//span[@class='p-button-icon pi pi-trash']")
	private List<WebElement>isDeleteButtonEnable;
	@FindBy(xpath="//div[@role='checkbox']")
	private List<WebElement>isCheckBoxEnable;
	@FindBy(xpath="//th[@class='p-sortable-column']|//th[text()=' Edit / Delete ']")
	private List<WebElement>isDatatableHeaderEnable;
	@FindBy(xpath="//div[@role='checkbox' and contains(@class, 'p-checkbox-box')]")
	private WebElement isCheckBoxHeaderEnable;
	@FindBy(xpath="//i[@class='p-sortable-column-icon pi pi-fw pi-sort-alt']")
	private List<WebElement>isSortingEnable;
	//.............Add New Batch
	@FindBy(xpath="//button[@role='menuitem' and contains(text(),'Add New Batch')]")
	private WebElement AddBatch;
	@FindBy(xpath="//div[contains(@class, 'p-dropdown')]")
	private WebElement DropDownProgramDis;
	@FindBy(xpath="//span[contains(@class,'p-dropdown-trigger')]")
	private List< WebElement> SelectFromDropDown;
	@FindBy(id="batchProg")
	private WebElement PreBatchName;
	@FindBy(id="batchName")
	private WebElement BatchName;
	@FindBy(id="batchDescription")
	private WebElement BatchDes;
	@FindBy(xpath="//div[@class='p-radiobutton-box']")
	private List<WebElement> radioButtons;
	@FindBy(id="batchNoOfClasses")
	private WebElement NoOfClasses;
	@FindBy(id="text-danger")
	private WebElement ErrorMsg;
	@FindBy(xpath="(//span[@class='p-radiobutton-icon'])[1]")
	private WebElement ActiveBtn;
	@FindBy(xpath="//span[text()='Save']")
	private WebElement SaveBtn;
	@FindBy(xpath="//*[@role='alert']//div[contains(text(),'Successful')]")
	private WebElement MsgDisplay;
	
	public boolean isSuccessMessageDisplayed() {
		return MsgDisplay.isDisplayed();
	}
//	public String MsgDisplayed() {
//		String Msg = "Successful";
//		return Msg;
//	}
//	 
	
	public void mandatoryDataEntry() {
		
		selectProgramFromDropdown();
		// wait.until(ExpectedConditions.invisibilityOfAllElements(SelectFromDropDown)); 
		
		wait.until(ExpectedConditions.elementToBeClickable(BatchName));

		BatchName.sendKeys("12");

		wait.until(ExpectedConditions.elementToBeClickable(NoOfClasses)); 
		NoOfClasses.sendKeys("5"); 
		wait.until(ExpectedConditions.visibilityOf(ActiveBtn));

		wait.until(ExpectedConditions.elementToBeClickable(ActiveBtn)).click();

		wait.until(ExpectedConditions.elementToBeClickable(BatchDes));
		BatchDes.sendKeys("Hackathoan");
	}
	
	public void clickSaveBtn() {
		SaveBtn.click();
	}
	public void enterTextInPreBatchName() {
		PreBatchName.sendKeys("a");
	
	}
	
	public boolean isTextInPreBatchName() {
		return PreBatchName.getAttribute("value").isEmpty();
	}
	
	public boolean getErrorMsg() {
		return ErrorMsg.isDisplayed();
	}
		
	public String selectProgramFromDropdown() {
		
		   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		   wait.until(ExpectedConditions.elementToBeClickable(DropDownProgramDis));
	
		    DropDownProgramDis.click(); // Open the dropdown
		    wait.until(ExpectedConditions.visibilityOfAllElements(SelectFromDropDown)); // Wait for options to load
		    System.out.println("Options are now visible. Attempting to click the first option...");
		    WebElement firstOption = SelectFromDropDown.get(0); 		    // Get the first option
		    
		    System.out.println("First option text: " + firstOption.getText());
		    wait.until(ExpectedConditions.elementToBeClickable(firstOption)).click();
//		    JavascriptExecutor js = (JavascriptExecutor) driver;
//		    js.executeScript("arguments[0].click();", firstOption);

		     //firstOption.click(); // Click the first option
		    String text = firstOption.getText(); // Get the selected text
		    
		    return text; // Return the selected text
		}

	public String getBatchName() {
		String text= PreBatchName.getText();
		return text;
	}
	
	public void enterTextInBatchName() {
		wait.until(ExpectedConditions.elementToBeClickable(BatchName));
		BatchName.click();
		BatchName.sendKeys("a");
	}
		
	public boolean checkElementEnable() {
		if(!DropDownProgramDis.isEnabled()) {
			System.out.println("DropDown");
			return false;
		}
		if(!PreBatchName.isEnabled()) {
			System.out.println("Prebatch");
			return false;
		}
		if(!BatchName.isEnabled()) {
			System.out.println("batch");
			return false;
		}
		if(!BatchDes.isEnabled()) {
			System.out.println("batchdes");
			return false;
		}
		if(radioButtons.isEmpty() || !radioButtons.get(0).isEnabled() || !radioButtons.get(1).isEnabled()) {
			System.out.println("radio");
			return false;
		}
		if(!NoOfClasses.isEnabled()) {
			System.out.println("classes");
			return false;
		}
		return true;
	}
	
	public boolean checkElementTypes() {
		if(!DropDownProgramDis.getAttribute("class").contains("p-dropdown")) {
			return false;
		}
		if(!PreBatchName.getAttribute("type").contains("text")) {
			return false;
		}
		if(!BatchName.getAttribute("type").contains("text")) {
			return false;
		}
		if(!BatchDes.getAttribute("type").contains("text")) {
			return false;
		}
		if(!NoOfClasses.getAttribute("type").contains("number")) {
			return false;
		}
		return true;
	}
	
	public void addBatchBtn() {
		//driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(AddBatch));
		AddBatch.click();
	}
	
	public String getBatchPageUrl() {
		String CurrentUrl=driver.getCurrentUrl();
		return CurrentUrl;
	}
	public String ExpectedBatchUrl() {
		String ExpectedUrl = "https://feb-ui-hackathon-bbfd38d67ea9.herokuapp.com/batch";
		return ExpectedUrl;
	}
	
	public boolean isSortingEnable() {
		for(WebElement sorting:isSortingEnable) {
		wait.until(ExpectedConditions.visibilityOf(sorting));
		if(!sorting.isEnabled()) {
			System.out.println("Sorting is not enable");
			return false;
			}
    	}
		System.out.println("Sorting is enable");
		return true;
	}
	public boolean isCheckBoxHeaderEnable() {
		return isCheckBoxHeaderEnable.isEnabled();
	}
	
	public boolean areDatatableHeaderEnable() {
		for(WebElement datatable:isDatatableHeaderEnable) {
			wait.until(ExpectedConditions.visibilityOf(datatable));
			if(!datatable.isEnabled()) {
				System.out.println("the datatable is not enabled");
				return false;
			}
		}
		System.out.println("the datatable is enabled ");
		return true;
	}
	
	public boolean areCheckBoxEnable() {
		for(WebElement checkbox:isCheckBoxEnable) {
			wait.until(ExpectedConditions.visibilityOf(checkbox));
			if(!checkbox.isEnabled()) {
				System.out.println("The checkboxes are not enable");
				return false;
			}
		}
		return true;
	}
	
	
	public boolean areDeleteButtonEnable() {
		for(WebElement delete:isDeleteButtonEnable) {
			wait.until(ExpectedConditions.visibilityOf(delete));
			if(!delete.isEnabled()) {
				System.out.println("The delete button icon is not enabled");
				return false;
			}
		}
		System.out.println("Delete button is enabled");
		return true;
	}
	
	public boolean areEditButtonsEnable() {
		for(WebElement edit:isEditButtonEnable) {
			wait.until(ExpectedConditions.visibilityOf(edit));
			if(!edit.isEnabled()) {
				System.out.println("edit button is not enabled");
				return false;
			}
		}
		System.out.println("edit button are enabled");
		return true;
		
	}
	
	public boolean PaginationControlTable() {
		return PaginationControlTable.isEnabled();
	}
	public boolean isIconEnable() {
		return DeleteIcon.isEnabled();	
	}
	
	public boolean LearningManagementSystemText() {
		return LearningManagementSystemText.isDisplayed();
	}
	
	public boolean ManageBatchText() {
		return ManageBatchText.isDisplayed();
	}
	public String ManageBatchUrl() {
		String CurrentUrl = driver.getCurrentUrl();
		return CurrentUrl;
	}
	
	public void BatchButton() {
		BatchButton.click();
	}
		

//	public void clickLogin(){
//		login.click();
//	}
	
	
}
