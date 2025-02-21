package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "username")
	public WebElement userNameInput;

	@FindBy(id = "password")
	public WebElement passwordInput;

	@FindBy(xpath = "//*[@id=\"mat-select-value-1\"]/span")
	public WebElement role;

	@FindBy(xpath = "//mat-option[span[text()[contains(.,'Admin')]]]")
	public WebElement adminRole;

	@FindBy(id = "login")
	public WebElement login;
	
	

	public void clickLogin(){
		login.click();
	}


}