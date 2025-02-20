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

	@FindBy(id  = "username")
	private WebElement usernameField;

	@FindBy(id = "password")
	private WebElement passwordField;

	@FindBy(id = "mat-select-0")  
    private WebElement roleDropdown;

	@FindBy(id = "login")
	private WebElement loginButton;

	public void enterUsername(String username) {
		usernameField.sendKeys(username);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void selectRole(String role) {
		roleDropdown.click();  
	    WebElement roleOption = driver.findElement(By.xpath("//mat-option/span[contains(text(),'" + role + "')]"));
	    roleOption = WebDriverWaitUtility.waitForElementToBeVisible(roleOption);
        roleOption.click();
	}

	public void clickLoginButton() {
		loginButton.click();
	}
}