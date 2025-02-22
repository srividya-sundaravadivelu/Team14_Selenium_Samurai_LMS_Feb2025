package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage{

    @FindBy(id = "logout")
    public WebElement logout;

    public LogoutPage(WebDriver driver) {super(driver);}

    public void logout(){
        logout.click();
    }

    public void clickBackButton() {
        driver.navigate().back();
    }
}
