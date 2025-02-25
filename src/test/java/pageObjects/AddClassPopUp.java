package pageObjects;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.WebDriverWaitUtility;


public class AddClassPopUp extends BasePage {

	public AddClassPopUp(WebDriver driver) {
		super(driver);
	}
	
	private String batchName;
	private String classTopicName;
	String[] classDetails = new String[2];
	// Mandatory fields

		@FindBy(xpath = "//input[@placeholder='Select a Batch Name']")
		private WebElement batchNameDrpdw;
		@FindBy(xpath = "//input[@id='classTopic']")
		private WebElement classTopic;
		@FindBy(xpath = "//input[@id='classDescription']")
		private WebElement classDescription;
		@FindBy(xpath = "//input[@id='icon']")
		private WebElement datePicker;
		@FindBy(xpath = "//span[@class='p-button-icon pi pi-calendar']")
		private WebElement calenderBtn;
		
		@FindBy(xpath = "//label[normalize-space()='Staff Name']")
		private WebElement staffnameheader;
		@FindBy(className = "p-datepicker-month")
		private WebElement month;
		@FindBy(className = "pi-chevron-right")
		private WebElement nextMonth;
		@FindBy(xpath = "//span[normalize-space()='21']")
		private WebElement date;
		@FindBy(xpath = "//td[@ng-reflect-ng-class='[object Object]']")
		private List<WebElement> dateSel;
		@FindBy(xpath = "//input[@id='classNo']")
		private WebElement noOfClasses;
		@FindBy(xpath = "//input[@placeholder='Select a Staff Name']")
		private WebElement staffName;
		@FindBy(xpath = "//label[text()='No of Classes']")
		private WebElement noOfClassesHeader;
		
		@FindBy(xpath="//input[@id='icon']")
		private WebElement noOfClassesTextBox;
		@FindBy(className = "p-radiobutton-box")
		private WebElement statusActive;
		@FindBy(xpath = "(//div[@ng-reflect-ng-class='[object Object]'])[15]")
		private WebElement statusInActive;
		@FindBy(xpath = "//p-dropdownitem[@class='ng-tns-c171-12 ng-star-inserted']")
		private List<WebElement> batchNameList;
		@FindBy(id = "saveClass")
		private WebElement saveAddClass;
		@FindBy(xpath = "//div[text()='Successful']")
		private WebElement classCreated;

		// optional fields
		@FindBy(xpath = "//input[@id='classComments']")
		private WebElement classComments;
		@FindBy(xpath = "//input[@id='classNotes']")
		private WebElement notes;
		@FindBy(xpath = "//input[@id='classRecordingPath']")
		private WebElement recording;
		
		// required fields
		@FindBy(xpath = "//small[normalize-space()='Batch Name is required.']")
		private WebElement batchNameReq;
		@FindBy(xpath = "//small[normalize-space()='Class Topic is required.']")
		private WebElement classTopicReq;
		@FindBy(xpath = "//small[normalize-space()='Class Date is required.']")
		private WebElement classDateReq;
		@FindBy(xpath = "//small[normalize-space()='Staff Name is required.']")
		private WebElement staffNameReq;
		@FindBy(xpath = "//small[normalize-space()='No. of Classes is required.']")
		private WebElement noOfClassesReq;
		
		//buttons
		@FindBy(xpath = "//span[text()='Cancel']")
		private WebElement cancelBtn;
		@FindBy(xpath = "//span[text()='Save']")
		private WebElement saveBtn;
		@FindBy(css = ".p-dialog-header-close")
		private WebElement closeIcon;

		@FindBy(xpath = "//p-toastitem/div/div/div/div[1]")
		private WebElement successMessage;
		
		public boolean isSuccessMessageVisible() {
			WebElement subMenuItem = WebDriverWaitUtility.waitForElementToBeClickable(successMessage);
			
			// subMenuItem.click();
			return subMenuItem.isDisplayed();
		}
		public String getClassCreatedMessage() {
			return successMessage.getText();
			
		}
		

		public String addingMandatoryFields(HashMap<String,String> classDetails) throws InterruptedException {
			batchNameDrpdw.click();
			batchNameDrpdw.sendKeys(classDetails.get("BatchName"));
			classTopic.click();
			classTopic.sendKeys(classDetails.get("ClassTopic"));
			classDescription.click();
			classDescription.sendKeys(classDetails.get("ClassDescription"));
			classDate(classDetails.get("Month"), classDetails.get("Date"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", noOfClasses);

			staffName.click();
			staffName.sendKeys(classDetails.get("StaffName"));
			if (classDetails.get("Status").equals("Active")) {
				statusActive.click();
			} else {
				statusInActive.click();

			}
			saveAddClass.click();

			return classCreated.getText();
		}
		
		
		
		public void skippingMandatoryFields(HashMap<String,String> classDetails) throws InterruptedException {
			
			
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			//js.executeScript("arguments[0].scrollIntoView(true);", statusInActive);
			classComments.sendKeys(classDetails.get("Comments"));
			notes.sendKeys(classDetails.get("Notes"));
			recording.sendKeys(classDetails.get("Recording"));
			classDescription.sendKeys(classDetails.get("ClassDescription"));
			//saveAddClass.click();
			saveBtn.click();

			//return classCreated.getText();
		}
		
		
		//tbody[@class = 'ng-tns-c92-38']//td 
		//td[@ng-reflect-ng-class='[object Object]']
		// Date picker
		public void classDate(String Month, String date) {

			//calenderBtn.click();
			datePicker.click();
			do {
				nextMonth.click();
			} while (!month.getText().contains(Month));
			for (int i = 0; i < dateSel.size(); i++) {
				//ng-tns-c92-38 ng-star-inserted
				List<WebElement> dates = driver.findElements(By.xpath("//tbody[@class = 'ng-tns-c92-38']//td"));
				System.out.println("dates=="+dates.toString());
				String text = dates.get(i).getText();
				if (text.equalsIgnoreCase(date)) {
					dates.get(i).click();
					System.out.println("Date clicked "+ text );
				}
			}
			//calenderBtn.click();
			recording.click();
			//noOfClassesHeader.click();
			//noOfClassesTextBox.sendKeys("1");
		}
		
		public void editClassDtetails(HashMap<String,String> classDetails) throws InterruptedException {
			
			try {
				
				classDescription.click();
				staffName.click();
				statusActive.click();
				
			} catch (Exception e) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();arguments[1].click();arguments[2].click();",
						classDescription,staffName,statusActive);
			}
			
			classDescription.sendKeys(classDetails.get("ClassDescription"));
			staffName.clear();
			staffName.sendKeys(classDetails.get("StaffName"));
			try {
				
				saveBtn.click();
				
			} catch (Exception e) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();",
						saveBtn);
			}
			
		}
		
		
		public boolean isBatchNameReqMsgVisible() {
			return batchNameReq.isDisplayed();
		}
		public boolean isClassTopicReqMsgVisible() {
			return classTopicReq.isDisplayed();
		}
		public boolean isClassDateReqMsgVisible() {
			return classDateReq.isDisplayed();
		}
		public boolean isNoOfClassesReqMsgVisible() {
			return noOfClassesReq.isDisplayed();
		}
		public boolean isStaffNameReqMsgVisible() {
			return staffNameReq.isDisplayed();
		}
		public void clickSaveBtn() {
			saveBtn.click();
		}
		public String[] getEditedClassDetails() {
			

			this.batchName = batchNameDrpdw.getText();
			this.classTopicName = classTopic.getText();
			classDetails[0] = this.batchName;
			classDetails[1] = this.classTopicName;
			return classDetails;
		}
		
		public String getSelectedBatchName() {
			//WebElement bName = WebDriverWaitUtility.waitForElementToBeVisible(batchNameDrpdw);
//			try{	
//					batchNameDrpdw.click();
//				
//			} catch (Exception e) {
//				((JavascriptExecutor) driver).executeScript("arguments[0].click();",
//						batchNameDrpdw);
//			}
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        this.batchName = (String) js.executeScript("return arguments[0].textContent;", batchNameDrpdw);
			return this.batchName;
		}
		
		public String getSelectedClassTopic() {
			WebElement topic = WebDriverWaitUtility.waitForElementToBeVisible(classTopic);
			//this.classTopicName = topic.getText();
			 
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        this.classTopicName = (String) js.executeScript("return arguments[0].textContent;", topic);
	        System.out.println("topic========"+this.classTopicName);
			return this.classTopicName;
		}
		
		public void clickCancelBtn() {
			try {
				
				cancelBtn.click();
				
			} catch (Exception e) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();",cancelBtn);
			}
			
		}
}