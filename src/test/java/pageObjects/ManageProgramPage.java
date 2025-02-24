package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.LogHelper;
import utils.WebDriverWaitUtility;

public class ManageProgramPage extends BasePage {
	List<String> actualColumnHeaders;

	public ManageProgramPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//div[text()=' Manage Program']")
	WebElement manageProgramText;
	
	@FindBy(xpath="//thead[@class='p-datatable-thead']/tr/th")
	List<WebElement> programTableColumnHeaderText;
	
	@FindBy(xpath="//button[@icon='pi pi-trash']")
	WebElement deleteIcon;
	
	@FindBy(id = "filterGlobal")
	WebElement searchBar;
	
	@FindBy(xpath = "//th//div[@role='checkbox']")
	WebElement tableHeaderCheckbox;
	
	@FindBy(xpath = "//tbody//td//div[@role='checkbox']")
	List<WebElement> RowWiseCheckbox;
	
	@FindBy(xpath = "//th[@role='columnheader']//p-sorticon")
	List<WebElement> sortIcon;
	
	@FindBy(id="editProgram")
	List<WebElement> editProgramBtn;
	
	@FindBy(id="deleteProgram")
	List<WebElement> deleteProgramBtn;
	
	@FindBy(xpath="//span[@class='p-paginator-current ng-star-inserted']")
	WebElement paginationTextProgram;
	
	@FindBy(xpath="//div[@class='p-d-flex p-ai-center p-jc-between ng-star-inserted']")
	WebElement footerProgramText;

	// Manage Program Feature

	public String admin_should_see_the_heading_as() {
		System.out.println("Actual Heading is : "+manageProgramText.getText());
		return manageProgramText.getText();

	}
	
	public List<String> admin_should_able_to_see_program_name_description_and_status_for_each_program() {						
		actualColumnHeaders = new ArrayList<String>();
		for (WebElement eachColumnHeaderText : programTableColumnHeaderText) {
	        String headerText = WebDriverWaitUtility.waitForElementToBeClickable(eachColumnHeaderText).getText().trim();
	        if (!headerText.isEmpty()) {  // Only add non-empty strings.
	            actualColumnHeaders.add(headerText);
	        }
	    }	
		System.out.println("actualColumnHeaders are------" +actualColumnHeaders);
		return actualColumnHeaders;
				
	}
	
	//****************Scenario 3**********************
	public String admin_should_see_a_delete_button_in_left_top_is_disabled() {		
		String isDisabled = deleteIcon.getAttribute("disabled");			
		if (isDisabled != null) {
		    System.out.println("The delete button is disabled.");
		} else {
		    System.out.println("The delete button is enabled.");
		}
		
		return isDisabled;
		
	}
	public String admin_should_see_search_bar_with_text_as() {
		String placeholderValue_SearchBar = searchBar.getAttribute("placeholder");
		System.out.println("Search Placeholder is----- " +placeholderValue_SearchBar);
		return placeholderValue_SearchBar;
	}
	
	public boolean admin_should_see_beside_program_name_column_header() {
		boolean isHeaderCheckboxUnchecked = tableHeaderCheckbox.isSelected();
		System.out.println("Is checkbox checked? --"+isHeaderCheckboxUnchecked);
		return isHeaderCheckboxUnchecked;
	}
	
	public boolean admin_should_see_beside_each_program_names_in_the_data_table() {		
		for(WebElement eachCheckBox:RowWiseCheckbox) {
			 if (eachCheckBox.isSelected()) {
		            System.out.println("A checkbox is checked! Test should fail.");
		            return false; // If any checkbox is checked, return false immediately
		        }
		    }
		    System.out.println("All row-wise checkboxes are unchecked.");
		    return true; 
	}
	
	public boolean admin_should_see_the_sort_arrow_icon_beside_each_column_header() {		
		for(WebElement eachColumnSortIcon :sortIcon) {
			 if (!eachColumnSortIcon.isDisplayed()) {
		            System.out.println("Sort icon not displayed for one of the column headers.");
		            return false;
		        }
			
			
		}
		System.out.println("Each Column header sort arrow icons are displayed.");
	    return true;
				
	}
	public boolean admin_should_see_the_edit_button_on_each_row_of_the_data_table() {
		for(WebElement eachEditBtn:editProgramBtn) {
			if(!eachEditBtn.isDisplayed()) {
				System.out.println("Edit buttons are not displayed");
				return false;
			}
		}
		System.out.println("Edit button on each row of the data table is displayed");
		return true;
		
		
		
	}
	public boolean admin_should_see_the_delete_button_on_each_row_of_the_data_table() {
		for(WebElement eachDeleteBtn:deleteProgramBtn) {
			if(!eachDeleteBtn.isDisplayed()) {
				System.out.println("Delete buttons are not displayed");
				return false;
			}
		}
		System.out.println("Delete button on each row of the data table is displayed");
		return true;
		
		
		
	}
	//Showing x to y of z entries
	public String getProgramPaginationText() {	
		
		WebElement paginationText = WebDriverWaitUtility.waitForElementToBeClickable(paginationTextProgram);		
		return paginationText.getText();
	}
	
	//Get program page footer message
	public String getFooterTextMessage() throws InterruptedException {	
		Thread.sleep(1000);
		WebElement footerProgramEle = WebDriverWaitUtility.waitForElementToBeClickable(footerProgramText);		
		return footerProgramEle.getText();
	}
	
	public int calculateTotalNoOfPrograms() {
		String totalProgramsDetails =  WebDriverWaitUtility.waitForElementToBeClickable(footerProgramText).getText();
		String[] arr = totalProgramsDetails.split(" ");
		int totalPrograms = Integer.parseInt(arr[4]);
		return totalPrograms;
	}
	

}
