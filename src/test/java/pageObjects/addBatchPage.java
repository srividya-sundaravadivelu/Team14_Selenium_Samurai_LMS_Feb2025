package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class addBatchPage extends BasePage{

	public addBatchPage(WebDriver driver) {
		super(driver);
		
	}
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	@FindBy(xpath="//button[text()='Add New Batch']")
	private WebElement NewBatchButton;
	@FindBy(xpath="//span[text()='Batch Details']")
	private WebElement BatchDetails;
	@FindBy(xpath="//div[@role='dialog']")
	private WebElement EditWindowEnable;
	@FindBy(xpath=".//button[contains(@class,'p-button-success')]")
	private List<WebElement>editButtons;
	@FindBy(xpath="//span[text()='Save']")
	private WebElement SaveButton;
	@FindBy(id="programName")
	private WebElement ProgramDropDown;
	@FindBy(id="batchName")
	private WebElement BatchNameTextBox;
	@FindBy(id="batchDescription")
	private WebElement BatchDescription;
//	@FindBy(id="batchNoOfClasses")
//	private WebElement NumberOfClasses;
//	@FindBy(id="text-danger")
//	private WebElement DescriptionErrorMessage;
	@FindBy(xpath="//small[contains(text(),'This field should start with an alphabet')]")
	private WebElement DescriptionMessage;
	@FindBy(xpath="//small[contains(text(),'Number of classes is required.')]")
	private WebElement ClassesErrorMessage;
	
	public void SaveButton() {
		SaveButton.click();
	}
	
	public String ClassesErrorMessage() {
		return  ClassesErrorMessage.getText();
	}
	
	public String DescriptionMessage() {
		return  DescriptionMessage.getText();
	}
	
	public void NumberOfClasses() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.id("batchNoOfClasses"));
		js.executeScript("arguments[0].click();", element);

		element.click();
		element.clear();
	}
	public String ExpectedDescriptionMessage() {
		String ExpectedText="This field should start with an alphabet and min 2 character.";
		return ExpectedText;
		
	}
	public String ExpectedNumberClassesMessage() {
		String ExpectedText="Number of classes is required.";
		return ExpectedText;
	}
	
	
	public void BatchDescription() {
		String original = BatchDescription.getText();
		System.out.println("Print the message" +original);
		 BatchDescription.clear();
		 BatchDescription.sendKeys("a");
	}
	
	public void clickEditButton() {	// clicks a single edit button
		if (!editButtons.isEmpty()) {	// makes sure that there exists at least one edit button
			WebElement button = editButtons.get(0); // stores the first edit button under the name button
			wait.until(ExpectedConditions.elementToBeClickable(button)); // waits for button to be clickable
			try {
				button.click();// clicks the button
			} catch (Exception e) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
			}
			
        } else {	// if no buttons exist, throw an exception
            throw new RuntimeException("No edit buttons found.");
        }
	}
	
	public boolean areBatchNameDisable() {
		for(WebElement button :editButtons ) {
			wait.until((ExpectedConditions.elementToBeClickable(button)));
			 clickButton(button);
			 if(!isBatchNameTextBox()) {
				 return false;
			 }
		}
		return true;
	}
	public boolean isBatchNameTextBox() {
		return !BatchNameTextBox.isEnabled();
	}
	
	public boolean areProgramDropDownDisable() {
		for(WebElement button : editButtons) {
			wait.until(ExpectedConditions.visibilityOf(button));
			clickButton(button);
			if(!isProgramDropDownDisable()) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isProgramDropDownDisable() {
		return !ProgramDropDown.isEnabled();
	}
	
	public boolean isEditWindowEnable() {
		return EditWindowEnable.isEnabled();
	}
	
	// is a method used for clicking any WebElement
	public void clickButton(WebElement button) { // button is a parameter of type WebElement
		button.click();
		return;
	}
	
	public boolean areEditWindowsEnable() {
		for(WebElement button : editButtons) {
			wait.until(ExpectedConditions.visibilityOf(button));
			clickButton(button);	// clicks the edit button
			if(!isEditWindowEnable()) {
				return false;
			}
		}
		return true;
	}
	
	public void NewBatchButton() {
		NewBatchButton.click();
	}

	public boolean getBatchButtonResult() {
		String ActualText= NewBatchButton.getText();
		String ExpectedText = "Add New Batch";
		return ActualText.equals(ExpectedText);
	}
	public boolean BatchDetailsText() {
		String ActualText= BatchDetails.getText();
		String ExpectedText = "Batch Details";
		return ActualText.equals(ExpectedText);
	}
	
	
}
