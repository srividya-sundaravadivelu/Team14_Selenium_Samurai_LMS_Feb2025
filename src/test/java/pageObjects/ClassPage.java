package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lombok.Data;

@Data
public class ClassPage extends BasePage {

	
	public ClassPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[normalize-space()='Class']")
	private WebElement classBtn;
	@FindBy(xpath = "//span[text()=' LMS - Learning Management System ']")
	private WebElement pageTitile;
	@FindBy(xpath = "//div[normalize-space()='Manage Class']")
	private WebElement pageHeader;
	@FindBy(xpath = "//input[@id='filterGlobal']")
	private WebElement searchBox;
	@FindBy(xpath = "//thead[@class = 'p-datatable-thead']/tr/th")
	private List<WebElement>dataTableHeaders;

	@FindBy(xpath = "//thead[@class = 'p-datatable-thead']/tr/th[2]")
	private WebElement batchName;
	
	public void clickBtnClass() {
		classBtn.click();
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
}