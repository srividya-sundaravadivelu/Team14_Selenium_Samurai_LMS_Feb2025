package driver;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.*;
import utils.ConfigReader;
import utils.LogHelper;
import utils.WebDriverWaitUtility;

public class TestContext {

	WebDriver driver;
	private LoginPage loginPage;

	private ClassPage classPage;
	private AddNewClassPage addNewClassPage;
	private AddClassPopUp addClassPopUp;
	private EditClassPage editClassPage;
	private Actions actions;
	private ProgramDeletePage programdeletepage;

	private BatchPage batchPage;
	private addBatchPage addbatchPage;

	private LogoutPage logoutpage;
	private HomePage homePage;

	public void setDriver(String browser) {
		LogHelper.info("Browser value inside SetDriver method in TestContext:" + browser);
		long pageLoadTimeout = Long.parseLong(ConfigReader.getPageLoadTimeout());

		switch (browser.toLowerCase()) {
		case "chrome":
			ChromeOptions chromeOptions = new ChromeOptions();
			if (ConfigReader.isChromeHeadless())
				chromeOptions.addArguments("--headless");
			driver = new ChromeDriver(chromeOptions);
			LogHelper.info("Chrome Driver is created");
			break;
		case "firefox":
			FirefoxOptions ffOptions = new FirefoxOptions();
			if (ConfigReader.isFireFoxHeadless())
				ffOptions.addArguments("--headless");
			driver = new FirefoxDriver(ffOptions);
			LogHelper.info("Firefox Driver is created");
			break;
		case "edge":
			EdgeOptions edgeOptions = new EdgeOptions();
			if (ConfigReader.isEdgeHeadless())
				edgeOptions.addArguments("--headless");
			driver = new EdgeDriver(edgeOptions);
			LogHelper.info("Edge Driver is created");
			break;
		default:
			throw new RuntimeException("Browser not supported: " + browser);
		}

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTimeout));
		driver.manage().window().maximize();

	}

	public WebDriver getdriver() {
		return driver;
	}

	public void quitDriver() {
		if (driver != null) {
			LogHelper.info("Quitting WebDriver instance: " + driver);
			driver.quit();
		} else {
			LogHelper.warn("WebDriver instance is already null or has been quit.");
		}
	}

	public LoginPage getLoginPage() {
		if (loginPage == null)
			loginPage = new LoginPage(driver);
		return loginPage;
	}

	public ClassPage getClassPage() {
		if (classPage == null)
			classPage = new ClassPage(driver);
		return classPage;
	}

	public AddNewClassPage getAddNewClassPage() {
		if (addNewClassPage == null)
			addNewClassPage = new AddNewClassPage(driver);
		return addNewClassPage;
	}

	public AddClassPopUp getAddClassPopUp() {
		if (addClassPopUp == null)
			addClassPopUp = new AddClassPopUp(driver);
		return addClassPopUp;
	}

	public EditClassPage getEditClassPage() {
		if (editClassPage == null)
			editClassPage = new EditClassPage(driver);
		return editClassPage;
	}

	public BatchPage getBatchPage() {
		if (batchPage == null)
			batchPage = new BatchPage(driver);
		return batchPage;
	}

	public addBatchPage getaddBatchPage() {
		if (addbatchPage == null)
			addbatchPage = new addBatchPage(driver);
		return addbatchPage;
	}

	public Actions getActions() {
		return actions;
	}

	public ProgramDeletePage getProgramDeletePage() {
		if (programdeletepage == null)
			programdeletepage = new ProgramDeletePage(driver);
		return programdeletepage;
	}

	public HomePage getHomePage() {
		if (homePage == null)
			homePage = new HomePage(driver);
		return homePage;

	}

	public LogoutPage getLogoutpage() {
		if (logoutpage == null)
			logoutpage = new LogoutPage(driver);
		return logoutpage;
	}

}