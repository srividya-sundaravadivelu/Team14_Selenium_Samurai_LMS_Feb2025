package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import utils.WebDriverWaitUtility;

public class BasePage {

	WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public void navigateToPage(String url) {
		driver.get(url);
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public void waitForPageToLoad() {
		WebDriverWaitUtility.waitForPageLoad(driver);
	}

}