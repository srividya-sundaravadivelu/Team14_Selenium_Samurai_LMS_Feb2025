package driver;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pageObjects.*;
import utils.ConfigReader;
import utils.LogHelper;

public class TestContext {

	WebDriver driver;	
	private LoginPage loginPage;
	private ClassPage classPage;

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
	

}
