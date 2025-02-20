package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.WebDriverWaitUtility;


public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "username")
	private WebElement userNameInput;

	@FindBy(id = "password")
	private WebElement passwordInput;

	@FindBy(xpath = "//*[@id=\"mat-select-value-1\"]/span")
	private WebElement role;

	@FindBy(id = "login")
	private WebElement login;
	
	
	public void enterUsername(String username) {
		userNameInput = WebDriverWaitUtility.waitForElementToBeClickable(userNameInput);
		userNameInput.sendKeys(username);
	}

	public void enterPassword(String password) {
		passwordInput = WebDriverWaitUtility.waitForElementToBeClickable(passwordInput);
		passwordInput.sendKeys(password);
	}

	public void selectRole(String roleName) {
		WebDriverWaitUtility.waitForElementToBeClickable(role).click();
		WebElement roleOption = driver.findElement(By.xpath("//mat-option[span[text()[contains(.," + roleName + ")]]]"));
		WebDriverWaitUtility.waitForElementToBeClickable(roleOption).click();
	}

	public void clickLogin(){
		WebDriverWaitUtility.waitForElementToBeClickable(login).click();
	}
}