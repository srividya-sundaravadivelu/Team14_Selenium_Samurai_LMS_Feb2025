package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	@FindBy(xpath="//div[@class='action']/span/button[contains(@class, 'p-button-success')]")
	private List<WebElement> editButtons;
//	@FindBy(xpath=".//button[contains(@class,'p-button-success')]")
//	private List<WebElement>editButtons;
	@FindBy(xpath="//span[text()='Save']")
	private WebElement SaveButton;
	@FindBy(id="programName")
	private WebElement ProgramDropDown;
	@FindBy(id="batchName")
	private WebElement BatchNameTextBox;
	@FindBy(xpath="//input[@type='number']")
	private WebElement NumberOfClasses;
	@FindBy(id="batchDescription")
	private WebElement BatchDescription;
	@FindBy(xpath="//span[text()='Cancel']")
	private WebElement CancelButton;
//	@FindBy(id="batchNoOfClasses")
//	private WebElement NumberOfClasses;
//	@FindBy(id="text-danger")
//	private WebElement DescriptionErrorMessage;
	@FindBy(xpath="//small[contains(text(),'This field should start with an alphabet')]")
	private WebElement DescriptionMessage;
	@FindBy(xpath="//small[contains(text(),'Number of classes is required.')]")
	private WebElement ClassesErrorMessage;
	@FindBy(xpath="//p-radiobutton[@id='batchStatus']//input[@id='ACTIVE']")
	private WebElement ActiveBtn;
	@FindBy(xpath="//div[@role='dialog']")
	private WebElement batchDetailPopUp;
	//delete page.................................................................
	@FindBy(xpath="//div[@class='action']//span/button[contains(@class, 'p-button-danger')]")
	private List<WebElement> DeleteBtn;
	@FindBy(xpath="//span[contains(text(),'Are you sure you want to delete')]")
	private WebElement ConfirmText;
	@FindBy(xpath="//button//span[text()='Yes']")
	private WebElement DeleteYesBtn;
	@FindBy(xpath="//button//span[text()='No']")
	private WebElement DeleteNoBtn;
	@FindBy(xpath="//div[normalize-space()='Manage Batch']")
	private WebElement DisplayBatch;
	@FindBy(xpath = "//button[contains(@class, 'p-dialog-header-icon')]")
	private WebElement CrossDeleteBtn;
	@FindBy(xpath="//div[@role='checkbox' and contains(@class,'p-checkbox-box')")
	private List<WebElement> CheckBox;
	@FindBy(xpath="//span[contains(@class,'pi-trash')]")
	private WebElement DeleteBox;
	@FindBy(xpath="//span[text()='Yes']")
	private WebElement YesDeleteCheckBoxBtn;
	//Search......................................................
	
	@FindBy(id="filterGlobal")
	private WebElement SearchBox;
	
	
	public void enterSearchText(String searchText) {
		SearchBox.clear();
		SearchBox.sendKeys(searchText);
		SearchBox.sendKeys(Keys.ENTER);
	}
	
	public int getMatchingRowsCount(String searchText) {
		List<WebElement> batches = driver.findElements(By.xpath("//tbody/tr[./td[contains(text(), '" + searchText + "')]]"));
		return batches.size();
	}
	
		
//......................................................................................
   //Pagination
	@FindBy(xpath="//span[@class='p-paginator-icon pi pi-angle-right']")
	private WebElement NextPageLink;
	
	@FindBy(xpath = "//button[contains(@class, 'p-paginator-page')]")
    private List<WebElement> pageButtons;
	
	@FindBy(xpath="//span[@class='p-paginator-icon pi pi-angle-double-right']")
	private WebElement LastPageLink;
	
	@FindBy(xpath="//span[@class='p-paginator-icon pi pi-angle-left']")
	private WebElement PreviousPageLink;
	
	@FindBy(xpath="//button[contains(@class, 'p-paginator-prev')]")
	private WebElement previousButton;
	
	@FindBy(xpath="//button[contains(@class, 'p-paginator-first')]")
	private WebElement firstButton;
	
	@FindBy(xpath="//button[contains(@class, 'p-paginator-next')]")
	private WebElement nextButton;
	
	@FindBy(xpath="//button[contains(@class, 'p-paginator-last')]")
	private WebElement lastButton;

	
	@FindBy(xpath="//span[@class='p-paginator-icon pi pi-angle-double")
	private WebElement doublePreviousPageLink;
	
	@FindBy(xpath="//span[@class='p-paginator-icon pi pi-angle-double-left']")
	private WebElement FirstPageLink;
		
	public void doublePreviousPageButton() {
		clickButton(doublePreviousPageLink);
	}
	public boolean isdoublePreviousBtn() {
		return !doublePreviousPageLink.getAttribute("class").contains("p-disabled");
	}
	
	
	public void clickPreviousLink() {
		clickNextButton();
		clickButton(PreviousPageLink);
	}
	
	public boolean isPreviousButtonEnabled() {
		return !previousButton.getAttribute("class").contains("p-disabled");
	}
	
	public void clickFirstLink() {
		clickNextButton();
		clickButton(FirstPageLink);
	}
	
	public boolean isFirstButtonEnabled() {
		 return !firstButton.getAttribute("class").contains("p-disabled");
	}
	
	public void clickNextButton() {
		clickButton(NextPageLink);
	}
	
	public boolean isNextButtonEnabled() {
		return !nextButton.getAttribute("class").contains("p-disabled");
	}
	
	public boolean isLastButtonEnabled() {
		return !lastButton.getAttribute("class").contains("p-disabled");
	}
	 
	public void clickLastLink() {
		clickButton(LastPageLink);
	}
	
	
	public void deleteCheckBoxButton() {
		wait.until(ExpectedConditions.elementToBeClickable(YesDeleteCheckBoxBtn));
		 YesDeleteCheckBoxBtn.click();
	}
	
	public void deleteSelectedCheckBox() {
		Actions actions = new Actions(driver);
		WebElement deleteButton = driver.findElement(By.xpath("//span[contains(@class,'pi-trash')]"));
		actions.moveToElement(deleteButton).click().perform();

		//	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop")));
//		wait.until(ExpectedConditions.elementToBeClickable(DeleteBox));
//		 DeleteBox.click();
	}
	
	public void checkboxDelete() {
		while (CheckBox.isEmpty()) {}
		if (!CheckBox.isEmpty()) {	// makes sure that there exists at least one checkbox button
			WebElement button = CheckBox.get(0); // stores the first checkbox button under the name button
			wait.until(ExpectedConditions.elementToBeClickable(button)); // waits for button to be clickable
			try {
				
				button.click();// clicks the button
				
			} catch (Exception e) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
			}
			
        } else {	// if no buttons exist, throw an exception
            throw new RuntimeException("No delete buttons found.");
        }
	}
	
	
	public void deleteCloseButton() {
		//wait.until(ExpectedConditions.elementToBeClickable(DeletecloseBtn));
		CrossDeleteBtn.click();
	}
	
	public boolean backOnManagePage() {
		return DisplayBatch.isDisplayed();
	}
	
	public void deleteYesButton() {
		wait.until(ExpectedConditions.elementToBeClickable(DeleteYesBtn));
		DeleteYesBtn.click();
	}
	
	public void deleteNoButton() {
		wait.until(ExpectedConditions.elementToBeClickable(DeleteNoBtn));
		DeleteNoBtn.click();
	}
	
	public String deleteMessageSuccess() {
			
	// Locate the element that shows the message on hover
			WebElement element = driver.findElement(By.xpath("//div[@role='alert']//div[text()='Successful']"));

			// Create an Actions object
			Actions actions = new Actions(driver);

			// Move the mouse to the element
			actions.moveToElement(element).perform();
			
			// Get the message text
			String messageText = element.getText();
			System.out.println("The actual message is " +messageText);
			return messageText;
	}
	public String expectedDeletMessageSuccess() {
		String ExpectedMessage = "Successful";
		return ExpectedMessage;
	}
	
	public boolean confirmTextVisible() {
		return ConfirmText.isDisplayed();
	}
	
	public void clickDeleteButton() {	// clicks a single edit button
		driver.navigate().refresh();
		while (DeleteBtn.isEmpty()) {}
		if (!DeleteBtn.isEmpty()) {	// makes sure that there exists at least one edit button
			WebElement button = DeleteBtn.get(0); // stores the first delete button under the name button
			wait.until(ExpectedConditions.elementToBeClickable(button)); // waits for button to be clickable
			try {
				
				button.click();// clicks the button
				
			} catch (Exception e) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
			}
			
        } else {	// if no buttons exist, throw an exception
            throw new RuntimeException("No delete buttons found.");
        }
	}
	
	
	public boolean isBatchDetailsPopUpInvisible() {
		  try {
	            wait.until(ExpectedConditions.invisibilityOf(batchDetailPopUp));
	            return true; // Pop-up is closed
	        } catch (Exception e) {
	            return false; // Pop-up is still visible
	        }
	}
	
	
	public String successEditMessage() {
		// Locate the element that shows the message on hover
		WebElement element = driver.findElement(By.xpath("//div[@role='alert']//div[text()='Successful']"));

		// Create an Actions object
		Actions actions = new Actions(driver);

		// Move the mouse to the element
		actions.moveToElement(element).perform();
		
		// Get the message text
		String messageText = element.getText();
		System.out.println("The actual message is " +messageText);
		return messageText;

	}
	
	public String expectedSucessEditMessage() {
		String ExpectedMessage = "Successful";
		return ExpectedMessage;
	}
	
	public void CancelButton() {
		wait.until(ExpectedConditions.elementToBeClickable(CancelButton));
		CancelButton.click();
	}
	
	public void clickActiveButton() {
		  Actions actions = new Actions(driver);
		  //wait.until(ExpectedConditions.elementToBeClickable(ActiveBtn));
		  actions.moveToElement(ActiveBtn).click().perform();
//		//wait.until(ExpectedConditions.elementToBeClickable(ActiveBtn));
//		while (!ActiveBtn.isSelected()) {
//			ActiveBtn.click();
	//	}		
	}
	
	public void SaveButton() {
		SaveButton.click();
	}
	
	public String ClassesErrorMessage() {
		return  ClassesErrorMessage.getText();
	}
	
	public String DescriptionMessage() {
		return  DescriptionMessage.getText();
	}
	
//	public static List<WebElement> waitForListOfElementsToBeVisible(List<WebElement> webElelments) {
//		
//		return wait.until(ExpectedConditions.visibilityOfAllElements(webElelments));
//	}
	
	public void editClasses(int num) {
		
		    WebElement element = wait.until(ExpectedConditions.visibilityOf(NumberOfClasses));
		    element.clear();
		    element.sendKeys(String.valueOf(num)); // Convert int to String
		}

	public void ValidClasses() {
		editClasses(10);
	}
	
	public void inValidClasses() {
		
		editClasses(0);
	}
	public String ExpectedDescriptionMessage() {
		String ExpectedText="This field should start with an alphabet and min 2 character.";
		return ExpectedText;
		
	}
	public String ExpectedNumberClassesMessage() {
		String ExpectedText="Number of classes is required.";
		return ExpectedText;
	}
	
	//make a common class to add and edit the data in batch module
	public void editDescription(String input) {
		String original = BatchDescription.getText();
		System.out.println("Print the message" +original);
		 BatchDescription.clear();
		 BatchDescription.sendKeys(input);
	}
	public void validEditDescription() {
		
		editDescription("abcd");
	}
	
	public void inValidEditDescription() {
		
		editDescription("s");
	}
	public void clickEditButton() {	// clicks a single edit button
		driver.navigate().refresh();
		while (editButtons.isEmpty()) {}
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
			try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop"))); // Wait for overlay
	         wait.until(ExpectedConditions.elementToBeClickable(button));
			 clickButton(button);
			 if(!isBatchNameTextBox()) {
				 return false;
			 }
		}catch (Exception e) {
            System.out.println("Exception checking Program Dropdown: " + e.getMessage());
            return false;
        }
		}
			 return true;
		
	}
	public boolean isBatchNameTextBox() {
		wait.until(ExpectedConditions.visibilityOf(BatchNameTextBox));
		return !BatchNameTextBox.isEnabled();
	}
	
	public boolean areProgramDropDownDisable() {
	    for (WebElement button : editButtons) {
	        try {
	        	// these two lines are important
	            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop"))); // Wait for overlay
	            wait.until(ExpectedConditions.elementToBeClickable(button));
	            clickButton(button);
	            if (!isProgramDropDownDisable()) {
	                return false;
	            }
	        } catch (Exception e) {
	            System.out.println("Exception checking Program Dropdown: " + e.getMessage());
	            return false;
	        }
	    }
	    return true;
	}

	public boolean isProgramDropDownDisable() {
		wait.until(ExpectedConditions.visibilityOf(ProgramDropDown)); // Ensure visibility
	    return !ProgramDropDown.isEnabled();
	}
	
	public boolean isEditWindowEnable() {
		wait.until(ExpectedConditions.visibilityOf(EditWindowEnable)); 
		return EditWindowEnable.isEnabled();
	}
	
	// is a method used for clicking any WebElement
	public void clickButton(WebElement button) { 
	    try {
	        // Wait for overlay to disappear
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop")));
	        // Wait until the button is clickable
	        wait.until(ExpectedConditions.elementToBeClickable(button));
	        
	        // Scroll to the element
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
	        
	        // Click the button
	        button.click();
	        
	    } catch (Exception e) {
	        System.out.println("Exception clicking button: " + e.getMessage());
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button); // Fallback to JS click
	    }
	}

	
	public WebElement getBatchDetailsPopup() {
	    return wait.until(ExpectedConditions.visibilityOf(EditWindowEnable));
	}

	
	public boolean areEditWindowsEnable() {
	    for (WebElement button : editButtons) {
	        try {
	            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop"))); // Wait for overlay to disappear
	            wait.until(ExpectedConditions.elementToBeClickable(button)); // Ensure button is clickable
	            clickButton(button);
	            if (!isEditWindowEnable()) {
	                return false;
	            }
	        } catch (Exception e) {
	            System.out.println("Exception in clicking Edit button: " + e.getMessage());
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
