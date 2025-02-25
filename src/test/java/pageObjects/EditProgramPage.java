package pageObjects;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.LogHelper;
import utils.WebDriverWaitUtility;

public class EditProgramPage extends BasePage {
		
	public EditProgramPage(WebDriver driver) {
		super(driver);
		this.program1Page = new Program1Page(driver);
		
	}
	
	Program1Page program1Page;
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	@FindBy(xpath ="//div[@role='dialog']")
	WebElement editProgramBtnEnable;
	
	@FindBy(xpath="//*[@id='editProgram']/span[1]")
	List<WebElement> editProgramBtn12;
	
	@FindBy(xpath="//div[@class='action']/span/button[contains(@class, 'p-button-success')]")
	List<WebElement> editProgramBtn;
	
	@FindBy(xpath = "//div[@role='dialog']")
	WebElement programDetailsPopUp;
	
		
	@FindBy(xpath="//input[@id='filterGlobal']")
	WebElement searchBtn;
	
	@FindBy(xpath="//table//tbody//td[2]")
	List<WebElement> programNameList;
	
	@FindBy(id="programName")
	WebElement programNameInput;
	
	@FindBy(id="programDescription")
	WebElement programDescInput;
	
	@FindBy(xpath = "//button[@id='saveProgram']")
	WebElement saveBtn;
	@FindBy(xpath = "//div/p-toastitem/div/div/div")
	WebElement successUpdateProgram;
		

	public List<WebElement> getEditbuttonList() {
		List<WebElement> btns = WebDriverWaitUtility.waitForListOfElementsToBeVisible(editProgramBtn);
		return editProgramBtn;
	}
	public void getRandomEditButton() {
		int number = new Random().nextInt(4);
		// clicking one random edit button from editButton list
		WebElement editProgBtn = getEditbuttonList().get(number);
		System.out.println("Edit Button Clicked--- " +editProgBtn);
		try {
			editProgBtn.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", editProgBtn);
		}
	}
	
	public boolean admin_lands_on_program_details_form() {		 
		boolean isProgramDetailsPopUpVisible = WebDriverWaitUtility.waitForElementToBeVisible(programDetailsPopUp).isDisplayed();
		if (!isProgramDetailsPopUpVisible)
			LogHelper.error("Program Pop up Window is not visible");
		
		return isProgramDetailsPopUpVisible;
	}
	
		
	public void searchForProgram(String programName) {
	    try {
	        WebElement searchInput = WebDriverWaitUtility.waitForElementToBeClickable(searchBtn);

	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchInput);
	        searchInput.clear();

	        searchInput.sendKeys(programName);
	        
	        // Press ENTER to trigger search
	        searchInput.sendKeys(Keys.ENTER);
	        System.out.println("Search triggered with: " + programName);

	        // Wait until search results are loaded
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        wait.until(ExpectedConditions.visibilityOfAllElements(programNameList));

	    } catch (Exception e) {
	        System.out.println("Error in searchForProgram: " + e.getMessage());
	    }
	}
	
	public void clickEditButtonForProgram() {
		
	    try {	       
	        //searchForProgram(desiredProgramName); // Ensure search is performed before locating elements

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        driver.navigate().refresh();

	        // Wait until at least one row appears in the table
	        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//tbody//tr")));

	        List<WebElement> programRows = driver.findElements(By.xpath("//tbody//tr")); // Fetch fresh rows
	        String desiredProgramName = programRows.get(0).findElement(By.xpath(".//td[2]")).getText();
	        int matchingIndex = -1;

	        // Iterate through table rows and find the matching program
	        System.out.println("Program rows size----"+programRows.size());
	        for (int i = 0; i < programRows.size(); i++) {
	            WebElement programNameCell = programRows.get(i).findElement(By.xpath(".//td[2]")); // Corrected relative XPath
	            String actualProgramName = programNameCell.getText().trim();
	            System.out.println("Found program: " + actualProgramName);

	            if (actualProgramName.equalsIgnoreCase(desiredProgramName.trim())) {
	                matchingIndex = i;
	                break;
	            }
	        }

	        if (matchingIndex == -1) {
	            throw new NoSuchElementException("Program not found: Expected '" + desiredProgramName + "', but it wasn't in the search results.");
	        }

	        // Re-fetch the row and locate elements again to avoid stale references
	        WebElement targetRow = driver.findElements(By.xpath("//tbody//tr")).get(matchingIndex);
	        WebElement editProgBtn = targetRow.findElement(By.xpath(".//td//button[contains(@class,'p-button-success')]")); // Improved XPath

	        System.out.println("Clicking Edit Button for: " + desiredProgramName);
	       	        
	        // Wait until the button is clickable and then click
	        wait.until(ExpectedConditions.elementToBeClickable(editProgBtn)).click();
	      	       
	        editProgramName();
	        editProgramDescription();	        
	        program1Page.selectStatus();
	        saveBtn.click();
	      			
	    } catch (Exception e) {
	        System.out.println("Error in clickEditButtonForProgram: " + e.getMessage());
	    }
	}
		
	public boolean isEditBtnEnable() {
		wait.until(ExpectedConditions.visibilityOf(editProgramBtnEnable)); 
		return editProgramBtnEnable.isEnabled();
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
	
	public boolean updateProgram(String desiredProgram) {
	    for (WebElement button : editProgramBtn) {	    	
	        try {
	        	searchForProgram(desiredProgram);
	            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop"))); // Wait for overlay to disappear
	            wait.until(ExpectedConditions.elementToBeClickable(button)); // Ensure button is clickable
	                      
	            clickButton(button);	           
	            editProgramName();	         
	            
	            if (!isEditBtnEnable()) {
	                return false;
	            }
	        } catch (Exception e) {
	            System.out.println("Exception in clicking Edit button: " + e.getMessage());
	            return false;
	        }
	    	  }	 
	    return true;
	}
			
	public void editProgramName() {		
		programNameInput.clear();		
		programNameInput.sendKeys("Updated");
		saveBtn.click();		
	}
	public void editProgramDescription() {
		programDescInput.clear();
		programDescInput.sendKeys("Updated Program Description");
		saveBtn.click();
	}
	public String successUpdateMessage() {
		WebElement successMessageElement = WebDriverWaitUtility.waitForElementToBeVisible(successUpdateProgram);
		String successMessage = successMessageElement.getText();
		return successMessage;
		
	}
	

}
