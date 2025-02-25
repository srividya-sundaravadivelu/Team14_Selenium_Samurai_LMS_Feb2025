package pageObjects;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.WebDriverWaitUtility;

public class ClassDeletePage extends BasePage {
	private Actions actions;
      
	public ClassDeletePage(WebDriver driver) {
		super(driver);
		this.actions = new Actions(driver);		 		
	}
	//(//span[@class = 'p-button-label'])[2]
	//(//button[@icon='pi pi-trash'])[2])
	@FindBy(xpath = "(//button[@icon='pi pi-trash'])[2]")
	private WebElement deleteBtn;
	@FindBy(xpath = "//button//span[text()='Yes']")
	private WebElement confirmYes;
	@FindBy(xpath = "//button//span[text()='No']")
	private WebElement confirmNo;
	@FindBy(xpath = "//div[text()='Successful']")
	private WebElement successDelete;
	@FindBy(xpath="//span[text()='Confirm']")
	private WebElement confirmHeading;
	//@FindBy(xpath="//span[text()='Are you sure you want to delete Test?']")
	@FindBy(xpath="//span[text()='Confirm']")
	private WebElement confirmTxt;

	// delete multiple program locators
	@FindBy(xpath = "//div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[1]/td[1]/p-tablecheckbox/div/div[2]")
	private WebElement checkbox1;
	@FindBy(xpath = "//div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[3]/td[1]/p-tablecheckbox/div/div[2]")
	private WebElement checkbox2;
	@FindBy(xpath = "//div/mat-card/mat-card-title/div[2]/div[1]/button/span[1]")
	private WebElement dubdelete_icon;
	@FindBy(xpath = "//button//span[text()='Yes']")
	private WebElement dubdelete_yes;
	@FindBy(xpath = "//div/p-toastitem/div/div/div/div[2]")
	private WebElement success_dbdelete;
	
	public void clickOnDeleteIcon() {
//		Actions actions = new Actions(driver);
//		actions.doubleClick(deleteBtn).perform();
		 WebElement classDeleteBtn = WebDriverWaitUtility.waitForElementToBeClickable(deleteBtn);	
		 Actions actions = new Actions(driver);
			actions.doubleClick(classDeleteBtn).perform();

		}
	

	public void deleteSingleClass() {
		confirmYes.click();
		String text1;
		text1 = successDelete.getText();
		System.out.println(text1);
	}

	public void cancelDeleteSingleClass() {
		confirmNo.click();

	}

	public void SelectCheckBoxes() {
		Actions actions = new Actions(driver);
		actions.doubleClick(checkbox1).perform();
		checkbox2.click();
		System.out.println("this function executed:");

	}
	public void MultipleDelete() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(dubdelete_icon)).click();

	}
	public boolean isConfirmDeleteMsgDisplayed() {
		WebElement confirm = WebDriverWaitUtility.waitForElementToBeVisible(confirmTxt);
		return confirm.isDisplayed();
	}
	public boolean isConfirmYesBtnDisplayed() {
		WebElement confirmY = WebDriverWaitUtility.waitForElementToBeClickable(confirmYes);
		return confirmY.isDisplayed();
	}
	public boolean isConfirmNoBtnDisplayed() {
		WebElement confirmN = WebDriverWaitUtility.waitForElementToBeClickable(confirmNo);
		return confirmN.isDisplayed();
	}
	
	public void DeleteSuccess() {
		dubdelete_yes.click();
		String text2;
		text2 = success_dbdelete.getText();
		System.out.println(text2);
	}
	public String getSuccessMsg() {
		 
		 WebElement successMessageElement = WebDriverWaitUtility.waitForElementToBeVisible(successDelete);
		 new WebDriverWait(driver, Duration.ofSeconds(30))
	        .until(ExpectedConditions.textToBePresentInElement(successDelete, "Successful"));		 
		 String text2 = successMessageElement.getText();
		    System.out.println("Successfully deleted: " + text2); 
		    return text2;  
	
	 } 
	
}
