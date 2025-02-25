package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.LogHelper;
import utils.WebDriverWaitUtility;

public class ClassPage extends BasePage {

	public ClassPage(WebDriver driver) {
		super(driver);
	}
	// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	@FindBy(xpath = "//span[normalize-space()='Home']")
	private WebElement homeBtn;
	@FindBy(xpath = "//span[normalize-space()='Class']")
	private WebElement classBtn;
	@FindBy(xpath = ("//span[normalize-space()='Batch']"))
	WebElement batchBtn;
	@FindBy(xpath = ("//span[normalize-space()='Program']"))
	WebElement programBtn;
	@FindBy(xpath = ("//button[@id='logout']"))
	WebElement logout;
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

	
	@FindBy(xpath = "/html/body/app-root/app-session/div/mat-card/mat-card-content/p-table/div/p-paginator/div/span[1]")
	private WebElement showingResults;
	
	@FindBy(xpath = "//tbody/tr[1]/td[2]")
	private WebElement firstBatchNameElement;

	@FindBy(xpath = "//tbody/tr[1]/td[3]")
	private WebElement firstClassNameElement;

	@FindBy(xpath = "//tbody/tr[1]/td[7]")
	private WebElement firstStaffNameElement;


	public void clickBtnClass() {
		WebElement btnClass = WebDriverWaitUtility.waitForElementToBeClickable(classBtn);
		// return editBtnList;
		try {
			btnClass.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnClass);
		}
	}

	public void clickProgramButton() {
		try {
			programBtn.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", programBtn);
		}
	}

	public void clickBatchButton() {
		//batchBtn.click();
		try {
			batchBtn.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", batchBtn);
		}
	}

	public void clickHomeButton() {
		//homeBtn.click();
		try {
			homeBtn.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", homeBtn);
		}
	}

	public void clickLogoutButton() {
		//logout.click();
		try {
			logout.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", logout);
		}
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

	public String getShowingResultsText() throws InterruptedException {
		Thread.sleep(2000);
		return showingResults.getText();
	}

	public boolean clicknextpage() throws InterruptedException {
		WebElement nextpagebutton = driver.findElement(By.xpath("//button[contains(@class, 'p-paginator-next')]"));
		LogHelper.info("Is Displayed: " + nextpagebutton.isDisplayed());
		LogHelper.info("Is Enabled: " + nextpagebutton.isEnabled());
		LogHelper.info("Is Selected: " + nextpagebutton.isSelected());

		WebDriverWaitUtility.clickElementUsingAction(driver, nextpagebutton);
		nextpagebutton.click();
		return true;
	}

	public boolean clickPreviousPage() throws InterruptedException {
		Thread.sleep(2000);
		WebElement previouspagebutton = driver.findElement(By.xpath("//button[contains(@class, 'p-paginator-prev')]"));
		LogHelper.info("Is Displayed: " + previouspagebutton.isDisplayed());
		LogHelper.info("Is Enabled: " + previouspagebutton.isEnabled());
		LogHelper.info("Is Selected: " + previouspagebutton.isSelected());

		WebDriverWaitUtility.clickElementUsingAction(driver, previouspagebutton);
		//previouspagebutton.click();
		return true;
	}

	public void clickLastPage() {
		WebElement lastpagebutton = driver.findElement(By.xpath("//button[contains(@class, 'p-paginator-last')]"));
		LogHelper.info("Is Displayed: " + lastpagebutton.isDisplayed());
		LogHelper.info("Is Enabled: " + lastpagebutton.isEnabled());
		LogHelper.info("Is Selected: " + lastpagebutton.isSelected());

		WebDriverWaitUtility.clickElementUsingAction(driver, lastpagebutton);
		lastpagebutton.click();
	}

	public void clickFirstPage() {
		WebElement firstpagebutton = driver.findElement(By.xpath("//button[contains(@class, 'p-paginator-first')]"));
		LogHelper.info("Is Displayed: " + firstpagebutton.isDisplayed());
		LogHelper.info("Is Enabled: " + firstpagebutton.isEnabled());
		LogHelper.info("Is Selected: " + firstpagebutton.isSelected());

		WebDriverWaitUtility.clickElementUsingAction(driver, firstpagebutton);
		//firstpagebutton.click();
	}
	
	public String enterBatchNameInSearchTextBox() {
		// Locate the first batch name from the table
		firstBatchNameElement = WebDriverWaitUtility.waitForElementToBeVisible(firstBatchNameElement);
		String batchName = firstBatchNameElement.getText();
		LogHelper.info("Batch Name: " + batchName);

		// Enter the batch name into the search box
		searchBox = WebDriverWaitUtility.waitForElementToBeClickable(searchBox);
		searchBox.clear();
		Actions actions = new Actions(driver);
		actions.moveToElement(searchBox).click().sendKeys(batchName).pause(1000).build().perform();

		return batchName;
	}

	public String enterClassNameInSearchTextBox() {
		// Locate the first class name from the table
		firstClassNameElement = WebDriverWaitUtility.waitForElementToBeVisible(firstClassNameElement);
		String className = firstClassNameElement.getText();
		LogHelper.info("Class Name: " + className);

		// Enter the class name into the search box
		searchBox = WebDriverWaitUtility.waitForElementToBeClickable(searchBox);
		searchBox.clear();
		Actions actions = new Actions(driver);
		actions.moveToElement(searchBox).click().sendKeys(className).pause(1000).build().perform();

		return className;
	}

	public String enterStaffNameInSearchTextBox() {
		// Locate the first staff name from the table
		firstBatchNameElement = WebDriverWaitUtility.waitForElementToBeVisible(firstStaffNameElement);
		String staffName = firstStaffNameElement.getText();
		LogHelper.info("Staff Name: " + staffName);

		// Enter the same staff name into the search box
		searchBox = WebDriverWaitUtility.waitForElementToBeClickable(searchBox);
		searchBox.clear();
		Actions actions = new Actions(driver);
		actions.moveToElement(searchBox).click().sendKeys(staffName).pause(1000).build().perform();

		return staffName;
	}

	public List<String> getBatchNamesFromTable() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> batchNameElements = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//tbody/tr/td[2]")));
		List<String> batchNames = new ArrayList<>();

		for (WebElement batchElement : batchNameElements) {
			batchElement = WebDriverWaitUtility.waitForElementToBeVisible(batchElement);
			batchNames.add(batchElement.getText().trim());
		}
		return batchNames;

	}
	
	public List<String> getClassNamesFromTable() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> classNameElements = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//tbody/tr/td[3]")));
		List<String> classNames = new ArrayList<>();

		for (WebElement classElement : classNameElements) {
			classElement = WebDriverWaitUtility.waitForElementToBeVisible(classElement);
			classNames.add(classElement.getText().trim());
		}
		return classNames;

	}
	
	public List<String> getStaffNamesFromTable() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> staffNameElements = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//tbody/tr/td[7]")));
		List<String> staffNames = new ArrayList<>();

		for (WebElement staffElement : staffNameElements) {
			staffElement = WebDriverWaitUtility.waitForElementToBeVisible(staffElement);
			staffNames.add(staffElement.getText().trim());
		}
		return staffNames;

	}
}