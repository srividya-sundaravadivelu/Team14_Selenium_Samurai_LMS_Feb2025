package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.WebDriverWaitUtility;


public class AddNewClassPage extends BasePage {

	public AddNewClassPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//button[@role='menuitem']")
	private WebElement addNewClass;
	@FindBy(xpath="//span[contains(text(),'Class Details')]") 
	private WebElement classDetails;
	@FindBy(xpath = "//span[text()='Cancel']")
	private WebElement cancelBtn;
	@FindBy(xpath = "//span[text()='Save']")
	private WebElement saveBtn;
	@FindBy(css = ".p-dialog-header-close")
	private WebElement closeIcon;
	
	@FindBy(xpath = "//label[text()='Batch Name']")
	private WebElement batchNamePopup;
	@FindBy(xpath = "//label[text()='Class Topic ']")
	private WebElement classTopicPopup;

	public String addNewProgram() {

		WebElement subMenuItem = WebDriverWaitUtility.waitForElementToBeClickable(addNewClass);
		
		return subMenuItem.getText();
	}

	public void addNewClassClick() {

		WebElement subMenuItem = WebDriverWaitUtility.waitForElementToBeClickable(addNewClass);
		subMenuItem.click();
	}
	public boolean isClassDetailsVisible() {
		WebElement subMenuItem = WebDriverWaitUtility.waitForElementToBeClickable(classDetails);
		return subMenuItem.isDisplayed();	
	}
	
	public String getWindowtitle() {
		return classDetails.getText();
	}

	public void saveButtonClick() {
		saveBtn.click();
	}
	public boolean isSaveBtnDisplayed() {
		return saveBtn.isDisplayed();
	}
	public void cancelButtonClick() {
		cancelBtn.click();
	}
	public boolean isCancelBtnDisplayed() {
		return cancelBtn.isDisplayed();
	}
	public void closeIconClick() {
		closeIcon.click();
	}
	public boolean isCloseIconDisplayed() {
		return closeIcon.isDisplayed();
	}
	public boolean batchNameOnPopupDisplayed() {
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement subMenuItem = WebDriverWaitUtility.waitForElementToBeClickable(batchNamePopup);
		//JavascriptExecutor js = (JavascriptExecutor) driver;
	//	js.executeScript("arguments[0].click();", subMenuItem);
		return subMenuItem.isDisplayed();
	}

	public boolean classTopicOnPopupDisplayed() {
//		WebElement subMenuItem = WebDriverWaitUtility.waitForElementToBeClickable(batchNamePopup);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click();", subMenuItem);
		return classTopicPopup.isDisplayed();
	}
	
}