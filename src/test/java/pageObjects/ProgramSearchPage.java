package pageObjects;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.WebDriverWaitUtility;

public class ProgramSearchPage extends BasePage {
	
	public ProgramSearchPage (WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//*[@id=\"filterGlobal\"]")private WebElement searchbox;	
	@FindBy(xpath = "//tbody//td[2]")private List<WebElement> ProgNameList;
	@FindBy(xpath = "//tbody//td[3]")private List<WebElement> ProgDescrpList;
	@FindBy(xpath = "//tbody//td[4]")private List<WebElement> ProgStatus;	
	@FindBy(xpath = "//tbody/tr[1]/td[2]")private List<WebElement> row;
	@FindBy(xpath = "//p-table//table/tbody/tr/td[3]")private List<WebElement> rowdesc;
	@FindBy(xpath = "//p-paginator/div/span[1]")private List<WebElement> rownull;
	
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
	
	}
	
	
	

