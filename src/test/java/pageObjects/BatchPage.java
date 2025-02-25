package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BatchPage extends BasePage {
	 
	// BatchPage constructor
	public BatchPage(WebDriver driver) {
		super(driver);
	}
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
//	@FindBy(id = "username")
//	public WebElement userNameInput;
//
//	@FindBy(id = "password")
//	public WebElement passwordInput;
//
//	@FindBy(xpath = "//*[@id=\"mat-select-value-1\"]/span")
//	public WebElement role;
//
//	@FindBy(xpath = "//mat-option[span[text()[contains(.,'Admin')]]]")
//	public WebElement adminRole;
//
//	@FindBy(id = "login")
//	public WebElement login;
	
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
