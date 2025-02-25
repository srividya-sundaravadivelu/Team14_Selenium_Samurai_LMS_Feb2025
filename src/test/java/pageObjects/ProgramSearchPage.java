package pageObjects;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.LogHelper;
import utils.WebDriverWaitUtility;

public class ProgramSearchPage extends BasePage {
	
	public ProgramSearchPage (WebDriver driver) {
		super(driver);
	}
	//program search locatiors
	@FindBy(xpath = "//*[@id=\"filterGlobal\"]")private WebElement searchbox;	
	@FindBy(xpath = "//tbody//td[2]")private List<WebElement> ProgNameList;
	@FindBy(xpath = "//tbody//td[3]")private List<WebElement> ProgDescrpList;
	@FindBy(xpath = "//tbody//td[4]")private List<WebElement> ProgStatus;	
	@FindBy(xpath = "//tbody/tr[1]/td[2]")private List<WebElement> row;
	@FindBy(xpath = "//p-table//table/tbody/tr/td[3]")private List<WebElement> rowdesc;
	@FindBy(xpath = "//p-paginator/div/span[1]")private List<WebElement> rownull;
	
	// pagination locators
	@FindBy(xpath = "//p-table/div/p-paginator/div/span[1]")private WebElement paginatorEntries;
	@FindBy(xpath = "//div[@class='p-d-flex p-ai-center p-jc-between ng-star-inserted']")
	private WebElement totalNoOfPrograms;
	@FindBy(xpath = "//p-table/div/p-paginator/div/button[3]")private WebElement clicknextpage;
	@FindBy(xpath = "//p-table/div/p-paginator/div/button[2]")private WebElement clickprevpage; 	
	@FindBy(xpath = "//p-paginator/div/button[4]")private WebElement clickLastpage;	
	@FindBy(xpath = "//p-paginator/div/button[1]")private WebElement clickFirstpage;
	@FindBy(xpath = "//p-table/div/p-paginator/div")private WebElement showAllresults;
	
	//********************search funtion Begins*******************************
	public void searchProgramName(String ProgramName) {	   
	    WebElement programSearchElement = WebDriverWaitUtility.waitForElementToBeClickable(searchbox);
	    programSearchElement.click();	   
	    searchbox.clear();                        
	    searchbox.sendKeys(ProgramName.trim());            
	    System.out.println("search completed: ");
    
	}
	public void searchProgramDescription(String ProgramDescription ) {	   
	    WebElement programSearchElement = WebDriverWaitUtility.waitForElementToBeClickable(searchbox);
	    programSearchElement.click();	   
	    searchbox.clear();                        
	    searchbox.sendKeys(ProgramDescription.trim());            
	             
	}
	public void searchInValidPName(String InValidPName ) {	   
	    WebElement programSearchElement = WebDriverWaitUtility.waitForElementToBeClickable(searchbox);
	    programSearchElement.click();	   
	    searchbox.clear();                        
	    searchbox.sendKeys(InValidPName.trim());            
	        
	}
	public List<WebElement> getDisplayedRows() {
	    return row;  // Return the list of rows
	}	
	public boolean progNameDisplayed(String ProgramName) {
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		 wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//p-table//table/tbody/tr[1]"), ProgramName));
	     return row.stream().anyMatch(row -> row.getText().equalsIgnoreCase(ProgramName));
    }
	public boolean progDescriptionDisplayed(String ProgramDescription) {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		 wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//p-table//table/tbody/tr/td[3]"), ProgramDescription));
		 return rowdesc.stream().anyMatch(rowdesc -> rowdesc.getText().equalsIgnoreCase(ProgramDescription));
    }
	
	public boolean InvalidPname(String InvalidprogName) {
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		 wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//p-paginator/div/span[1]"), "Showing 0 to 0 of 0 entries"));
		 List<WebElement> updatedRows = driver.findElements(By.xpath("//p-paginator/div/span[1]"));
		 for (WebElement row : updatedRows) {
			    System.out.println("invalid rows " + row.getText());
			}	 
		 //Showing 0 to 0 of 0 entries		 
        return rownull.stream().anyMatch(rownull -> rownull.getText().equalsIgnoreCase(InvalidprogName));
    }
	
	//********************end of search function****************************//
	
	public boolean clickOnNextpage() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        // Wait until the next page button is clickable
	        WebElement nextPageElement = wait.until(ExpectedConditions.elementToBeClickable(clicknextpage));	       
	        nextPageElement.click();      	
	        // Verify if the next page button is still displayed (optional)
	        boolean isDisplayed = nextPageElement.isDisplayed();
	        System.out.println("Next page button displayed: " + isDisplayed);
	        
	        return isDisplayed;  // Return the actual state instead of `true`
	    } catch (Exception e) {
	        System.out.println("Exception while clicking on next page: " + e.getMessage());
	        return false;
	    }
	}
	public String getShowingResultsText() throws InterruptedException {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        // Wait until the paginator element is visible and contains text
//	        wait.until(ExpectedConditions.visibilityOf(paginatorEntries));
//	        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//p-table/div/p-paginator/div/span[1]"), "Showing 1 to "));
	        By paginatorLocator = By.xpath("//p-table/div/p-paginator/div/span[1]");
	        WebElement paginatorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(paginatorLocator));
	        String resultsText = paginatorEntries.getText();
	        LogHelper.info("Showing results text: " + resultsText);

	        return resultsText;
	    } catch (Exception e) {
	        LogHelper.error("Error fetching showing results text: " + e.getMessage());
	        return "";
	    }
	}


	public boolean clickOnPreviousPage() {
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        // Wait until the next page button is clickable
        WebElement previousPageElement = wait.until(ExpectedConditions.elementToBeClickable(clickprevpage));	       
        previousPageElement.click();      	
        // Verify if the next page button is still displayed (optional)
        boolean isDisplayed = previousPageElement.isDisplayed();
        System.out.println("previous page button displayed: " + isDisplayed);
        return isDisplayed;  // Return the actual state instead of `true`
        
	    } catch (Exception e) {
	        System.out.println("Exception while clicking on previous page: " + e.getMessage());
	        return false;		
	    }
	}
	
	
	public boolean ClickOnLastPage() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        // Wait until the next page button is clickable
	        WebElement lastPageElement = wait.until(ExpectedConditions.elementToBeClickable(clickLastpage));	       
	        lastPageElement.click();      	
	        // Verify if the next page button is still displayed (optional)
	        boolean isDisplayed = lastPageElement.isDisplayed();
	        System.out.println("last page button displayed: " + isDisplayed);
	        return isDisplayed;  // Return the actual state instead of `true`
	        
		    } catch (Exception e) {
		        System.out.println("Exception while clicking on last page: " + e.getMessage());
		        return false;		
		    }				
	}
	
	public boolean ClickOnFirstPage() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        // Wait until the next page button is clickable
	        WebElement firstPageElement = wait.until(ExpectedConditions.elementToBeClickable(clickFirstpage));	       
	        firstPageElement.click();      	
	        // Verify if the next page button is still displayed (optional)
	        boolean isDisplayed = firstPageElement.isDisplayed();
	        System.out.println("first page button displayed: " + isDisplayed);
	        return isDisplayed;  // Return the actual state instead of `true`
	        
		    } catch (Exception e) {
		        System.out.println("Exception while clicking on first  page: " + e.getMessage());
		        return false;		
		    }				
		
	}
	
	}
	
	
	

