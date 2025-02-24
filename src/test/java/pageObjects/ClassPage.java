package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.WebDriverWaitUtility;

public class ClassPage extends BasePage {

	public ClassPage(WebDriver driver) {
		super(driver);
	}
	// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	@FindBy(xpath = "//span[normalize-space()='Class']")
	private WebElement classBtn;
	@FindBy(xpath = "//span[text()=' LMS - Learning Management System ']")
	private WebElement pageTitile;
	@FindBy(xpath = "//div[normalize-space()='Manage Class']")
	private WebElement pageHeader;
	@FindBy(xpath = "//input[@id='filterGlobal']")
	private WebElement searchBox;
	@FindBy(xpath = "//thead[@class = 'p-datatable-thead']/tr/th")
	private List<WebElement> dataTableHeaders;

	@FindBy(xpath = "//thead[@class = 'p-datatable-thead']/tr/th[2]")
	private WebElement batchName;

	@FindBy(xpath = "//div[@class='p-d-flex p-ai-center p-jc-between ng-star-inserted']")
	private WebElement totalNoOfClasses;

	@FindBy(xpath = "//span[@class='p-paginator-current ng-star-inserted']")
	private WebElement paginationText;

	@FindBy(xpath = "//*[@psortablecolumn]//i")
	private List<WebElement> headerSortIconList;

	@FindBy(xpath = "//button[@class='p-button-danger p-button p-component p-button-icon-only']")
	private WebElement deleteAll;
	
	

	public void clickBtnClass() {
		WebElement btnClass = WebDriverWaitUtility.waitForElementToBeClickable(classBtn);
		//return editBtnList;
				btnClass.click();
	}

	public String getPageTitle() {
		return pageTitile.getText();
	}

	public String getPageHeader() {
		return pageHeader.getText();
	}

	public boolean isSearchBoxVisible() {
		return searchBox.isDisplayed();
	}

	public String dataTableHeaders() {
		String headers = "";
		for (int i = 1; i < dataTableHeaders.size(); i++) {

			headers = headers + dataTableHeaders.get(i).getText() + ", ";
		}
		return headers.trim().substring(0, headers.length() - 2); // to remove the last 2 characters ", "
	}

	public String getBatchHeader() {
		return batchName.getText();
	}

	public String getPaginationText() {
		// WebElement subMenuItem =
		// wait.until(ExpectedConditions.elementToBeClickable(paginationText));
		WebElement subMenuItem = WebDriverWaitUtility.waitForElementToBeClickable(paginationText);
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		return subMenuItem.getText();
	}

	public String getTotalClassesText() {
		// WebElement subMenuItem =
		// wait.until(ExpectedConditions.elementToBeClickable(totalNoOfClasses));

		WebElement subMenuItem = WebDriverWaitUtility.waitForElementToBeClickable(totalNoOfClasses);
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		return subMenuItem.getText();
	}

	public int totalNoOfClasses() {
		String totalClassesDetails = totalNoOfClasses.getText();
		// System.out.println("Total no classes = "+ totalClassesDetails);
		String[] arr = totalClassesDetails.split(" ");
		int totalClasses = Integer.parseInt(arr[4]);
		return totalClasses;
	}

	public List<WebElement> getSortIcons() {
		return headerSortIconList;
	}

	public boolean isHeaderSortIconListVisible() {
		boolean state = true;
		for (WebElement sortIcon : headerSortIconList) {
			state = sortIcon.isDisplayed();
			if (!state) {
				break; // check if any of the sort icon is not displayedS
			}
		}
		return state;
	}

	public boolean isDeleteAllBtnDisplayed() {

		return deleteAll.isDisplayed();
	}

	public boolean isTotalClassesDisplayed() {

		return totalNoOfClasses.isDisplayed();
	}
	

}