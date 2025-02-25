package pageObjects;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverWaitUtility;

public class ProgramDeletePage extends BasePage {
	private Actions actions;
      
	public ProgramDeletePage(WebDriver driver) {
		super(driver);
		this.actions = new Actions(driver);		 		
	}
	 
	//single delete Locators
	 @FindBy(xpath = "//button//span[text()='Program']")private WebElement programTab;	
	 @FindBy(xpath = "//*[@id=\"deleteProgram\"]/span[1]")private WebElement delebutn;	
	 @FindBy(xpath = "//button//span[text()='Yes']")private WebElement deleYes;	
	 @FindBy(xpath = "//button//span[text()='No']")private WebElement deleNo;	
	 @FindBy(xpath = "//div/div/div[1]/div/button/span")private WebElement closePopup;
	 @FindBy(xpath = "//div/p-toastitem/div/div/div")private WebElement successdelete;		
	 @FindBy(xpath = "//div/div/div[2]/span")private WebElement confirmpopTxt;
	 //multiple delete Locators
	 @FindBy(xpath = "//tr[1]/td[1]/p-tablecheckbox/div/div[2]")private WebElement checkBox1;
	 @FindBy(xpath = "//tr[2]/td[1]/p-tablecheckbox/div/div[2]")private WebElement checkBox2;	
	 @FindBy(xpath = "//div[2]/div[1]/button/span[1]")private WebElement doubledeletebtn;	
	 @FindBy(xpath = "//div/div/div[1]/div/button/span")private WebElement closePopupmultdelete;	
	 @FindBy(xpath = "//div/div/div[3]/button[2]/span[2]")private WebElement multiDeleteYes;	
	 @FindBy(xpath = "//div/p-toastitem/div/div/div/div")private WebElement dubsuccessdelete;
	
	 public void ClickOnProgram() { 
		 
		    WebElement programTabElement = WebDriverWaitUtility.waitForElementToBeClickable(programTab);  		   
		    actions.doubleClick(programTabElement).perform();		    
		    String pageTitle = driver.getTitle();
		    
		}
	 
	 public void ClickOnDeleteBtn() {	
		 WebElement programDeleteElement = WebDriverWaitUtility.waitForElementToBeClickable(delebutn);	
		 programDeleteElement.click();
	 }
	 public String getText() { 
		    String text1 = confirmpopTxt.getText();		   
		    return text1; 
		} 	
	 public void ClickNoDelete() {
		 deleNo.click();
	 }	
	 
	 public String getPageTitle() {
		 String pageTitle = driver.getTitle();
		return pageTitle;
	 }
	 
	 public void ClickYesDelete() {
		 deleYes.click();

	 }
	 public String getSuccessMsg() {
		 
		 WebElement successMessageElement = WebDriverWaitUtility.waitForElementToBeVisible(successdelete);
		 new WebDriverWait(driver, Duration.ofSeconds(30))
	        .until(ExpectedConditions.textToBePresentInElement(successdelete, "Successful"));		 
		 String text2 = successMessageElement.getText();
		    System.out.println("Successfully deleted: " + text2); 
		    return text2;  
	
	 } 
	 
	 public String multiGetSuccessMsg() {
	        try {
	        	
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));	         
	            System.out.println("before get web element");
	            wait.until(ExpectedConditions.visibilityOf(dubsuccessdelete)); 	            
	            return dubsuccessdelete.getText();
	        } catch (Exception e) {
	           
	            return "";
	        }
	 }
	 	 
	 public void MultipleDeleteCheck() {
		 WebElement programChekbxElement1 = WebDriverWaitUtility.waitForElementToBeClickable(checkBox1);	
		 programChekbxElement1.click();
		 WebElement programChekbxElement2 = WebDriverWaitUtility.waitForElementToBeClickable(checkBox2);	
		 programChekbxElement2.click();
		 WebElement programDeleteicon = WebDriverWaitUtility.waitForElementToBeClickable(doubledeletebtn);			 
		 programDeleteicon.click();
		 
	 	 }	 

	public String getConfimText() {
		String text3=confirmpopTxt.getText();
		 System.out.println(text3);	
		 return text3;
	}	
	public void MultipleDeleteProg() {
		System.out.println("befor cliking delete" + multiDeleteYes.getText());
		multiDeleteYes.click();
		System.out.println("after cliking delete");
	}
	public void ClickClosePopup() {
		 closePopup.click();
	 }	
	
}
