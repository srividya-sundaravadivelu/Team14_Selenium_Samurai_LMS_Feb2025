package utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWaitUtility {

	private static WebDriverWait wait;

	public static void initializeWait(WebDriver driver, long timeoutInSeconds) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	}

	public static WebElement waitForElementToBeVisible(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static List<WebElement> waitForListOfElementsToBeVisible(List<WebElement> webElelments) {
		
		return wait.until(ExpectedConditions.visibilityOfAllElements(webElelments));
	}
	public static WebElement waitForElementToBeClickable(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static boolean waitForPageLoad(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return wait.until(
				(ExpectedCondition<Boolean>) wd -> js.executeScript("return document.readyState").equals("complete"));
	}

	public static boolean waitForAlert() {
		return wait.until(ExpectedConditions.alertIsPresent()) != null;
	}
	
	public static void waitForTitle(WebDriver driver, String expectedTitle) {
	    new WebDriverWait(driver, Duration.ofSeconds(10))
	        .until(ExpectedConditions.titleIs(expectedTitle));
	}

}

