package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import utils.LogHelper;
import utils.WebDriverWaitUtility;

import org.languagetool.JLanguageTool;
import org.languagetool.language.AmericanEnglish;
import org.languagetool.rules.RuleMatch;

import java.io.IOException;
import java.time.Duration;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//mat-toolbar//span[contains(text(),'LMS - Learning Management System')]")
	private WebElement titleElement;

	@FindBy(xpath = "//mat-toolbar//div")
	private WebElement navBar;

	@FindBy(tagName = "app-doughnutchart")
	private WebElement pieChart;

	@FindBy(xpath = "//app-admindata //div[contains(@class,'bottom')]")
	private WebElement roleNameDiv;

	@FindBy(xpath = "//app-admindata //strong")
	private WebElement welcomeMessage;

	@FindBy(xpath = "//mat-card //canvas[contains(@class,'chartjs-render-monitor')]")
	private WebElement barChart;

	@FindBy(xpath = "//div[@class='bottom' and text()='User']/preceding-sibling::div[@class='top']")
	private WebElement userCountElement;

	@FindBy(xpath = "//div[@class='bottom' and text()='Staff']/preceding-sibling::div[@class='top']")
	private WebElement staffCountElement;

	@FindBy(xpath = "//div[@class='bottom' and text()='Batches']/preceding-sibling::div[@class='top']")
	private WebElement batchCountElement;

	@FindBy(xpath = "//div[@class='bottom' and text()='Programs']/preceding-sibling::div[@class='top']")
	private WebElement programCountElement;
	
	@FindBy(xpath = "//app-staffdata //mat-table")
	private WebElement staffTable;
	
	@FindBy(xpath = "//app-staffdata //mat-paginator")
	private WebElement staffTablePagination;
	
	@FindBy(xpath = "//button[contains(@class,'mat-paginator-navigation-first')]")
	private WebElement firstPageButton;
			
	@FindBy(xpath = "//button[contains(@class,'mat-paginator-navigation-previous')]")
	private WebElement previousPageButton;

	public String getPageTitle() {
		return WebDriverWaitUtility.waitForElementToBeVisible(titleElement).getText();
	}

	public boolean isTitleOnTopLeft() {
		Point location = WebDriverWaitUtility.waitForElementToBeVisible(titleElement).getLocation();
		int x = location.getX();
		int y = location.getY();
		int leftAlignmentThreshold = 20;

		return (x <= leftAlignmentThreshold && y <= leftAlignmentThreshold);
	}

	public boolean hasNavBarSpellingMistakes() throws IOException {
		Boolean hasSpellingMistake = false;
		// Initialize LanguageTool for American English
		JLanguageTool langTool = new JLanguageTool(new AmericanEnglish());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> navItems = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//mat-toolbar//button")));

		for (WebElement button : navItems) {

			// Retrieve the visible text of the button
			String text = WebDriverWaitUtility.waitForElementToBeVisible(button).getText().trim();

			// Skip buttons without visible text
			if (text.isEmpty()) {
				continue;
			}

			// Check the text for spelling mistakes
			List<RuleMatch> mistakes = langTool.check(text);

			if (!mistakes.isEmpty()) {
				hasSpellingMistake = true;
				LogHelper.error("Spelling mistakes found in button with ID: " + button.getAttribute("id"));
				for (RuleMatch mistake : mistakes) {
					LogHelper.error("Mistake: " + mistake.getMessage());
				}
			} else {
				LogHelper.info("No spelling mistakes found in button with ID: " + button.getAttribute("id"));
			}
		}

		return hasSpellingMistake;
	}

	public boolean isNavBarOnTopRight() {

		// Retrieve the browser window's dimensions
		Dimension windowSize = driver.manage().window().getSize();
		int windowWidth = windowSize.getWidth();

		// Retrieve the navigation bar's position and size

		Point navBarPosition = WebDriverWaitUtility.waitForElementToBeVisible(navBar).getLocation();
		int navBarX = navBarPosition.getX();
		int navBarY = navBarPosition.getY();
		int navBarWidth = navBar.getSize().getWidth();

		// Define the acceptable thresholds
		int rightThreshold = 40; // Pixels from the right edge
		int topThreshold = 15; // Pixels from the top edge

		// Calculate the navigation bar's right edge position
		int navBarRightEdge = navBarX + navBarWidth;

		// Verify the navigation bar is within the right threshold
		boolean isAlignedRight = (windowWidth - navBarRightEdge) <= rightThreshold;

		// Verify the navigation bar is within the top threshold
		boolean isAlignedTop = navBarY <= topThreshold;

		return (isAlignedRight && isAlignedTop);
	}

	public int getNavItemPosition(String itemName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> navItems = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//mat-toolbar//button")));

		for (int i = 0; i < navItems.size(); i++) {
			WebElement item = navItems.get(i);

			item = WebDriverWaitUtility.waitForElementToBeClickable(item);
			if (item.getText().equalsIgnoreCase(itemName)) {
				return i + 1; // Return position (1-based index)
			}

		}
		return -1; // Return -1 if item is not found
	}

	public boolean isPieChartVisible() {
		if (WebDriverWaitUtility.waitForElementToBeVisible(pieChart).isDisplayed()) {
			return true;
		} else {
			LogHelper.error("PieChart is not visible");
			return false;
		}
	}

	public String getWecomeMessage() {
		return WebDriverWaitUtility.waitForElementToBeVisible(welcomeMessage).getText().trim();
	}

	public String getRoleName() {
		return WebDriverWaitUtility.waitForElementToBeVisible(roleNameDiv).getText().trim();
	}

	public boolean isBarChartVisible() {
		if (WebDriverWaitUtility.waitForElementToBeVisible(barChart).isDisplayed()) {
			return true;
		} else {
			LogHelper.error("Barchart is not visible");
			return false;
		}
	}

	public int getUserCount() {
		userCountElement = WebDriverWaitUtility.waitForElementToBeVisible(userCountElement);
		int userCount;
		try {
			userCount = Integer.parseInt(userCountElement.getText());
		} catch (NumberFormatException e) {
			throw new AssertionError("Displayed user count is not a valid integer");
		}
		return userCount;
	}

	public int getStaffCount() {
		staffCountElement = WebDriverWaitUtility.waitForElementToBeVisible(staffCountElement);
		int staffCount;
		try {
			staffCount = Integer.parseInt(staffCountElement.getText());
		} catch (NumberFormatException e) {
			throw new AssertionError("Displayed staff count is not a valid integer");
		}
		return staffCount;
	}

	public int getProgramCount() {
		programCountElement = WebDriverWaitUtility.waitForElementToBeVisible(programCountElement);
		int programCount;
		try {
			programCount = Integer.parseInt(programCountElement.getText());
		} catch (NumberFormatException e) {
			throw new AssertionError("Displayed program count is not a valid integer");
		}
		return programCount;
	}

	public int getBatchCount() {
		batchCountElement = WebDriverWaitUtility.waitForElementToBeVisible(batchCountElement);
		int batchCount;
		try {
			batchCount = Integer.parseInt(batchCountElement.getText());
		} catch (NumberFormatException e) {
			throw new AssertionError("Displayed batch count is not a valid integer");			
		}
		return batchCount;
	}
	
	public boolean isStaffTableVisibleWithPagination() {
		boolean isStaffTableVisible = WebDriverWaitUtility.waitForElementToBeVisible(staffTable).isDisplayed();
		if (!isStaffTableVisible)
			LogHelper.error("Staff table is not visible");
		
		boolean isStaffPaginationVisible =  WebDriverWaitUtility.waitForElementToBeVisible(staffTablePagination).isDisplayed();
		if (!isStaffPaginationVisible)
			LogHelper.error("Staff table pagination is not visible");
		
		return isStaffTableVisible && isStaffPaginationVisible;

	}
	
	public int getStaffTablePageSize()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> staffRows = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//mat-table //mat-row")));
		
		return staffRows.size();
	}
	
	public boolean isPreviousPageButtonEnabled() {
		return WebDriverWaitUtility.waitForElementToBeVisible(previousPageButton).isEnabled();
	}
	
	public boolean isFirstPageButtonEnabled() {
		return WebDriverWaitUtility.waitForElementToBeVisible(firstPageButton).isEnabled();
	}
	

}
